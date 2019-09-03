package com.jcohy.scis.service.impl;

import com.jcohy.date.DateUtils;
import com.jcohy.scis.exception.ServiceException;
import com.jcohy.scis.model.Notice;
import com.jcohy.scis.model.Project;
import com.jcohy.scis.model.Type;
import com.jcohy.scis.repository.*;
import com.jcohy.scis.service.ProjectService;
import com.jcohy.scis.service.TeacherService;
import com.jcohy.scis.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 16:07 2018/4/7
 * Email: jia_chao23@126.com
 * ClassName: ProjectServiceImpl
 * Description:
 **/
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private TypeService typeService;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(Integer id) {
        return projectRepository.findById(id).get();
    }

    @Override
    public Project findByName(String name) {
        return projectRepository.findAllByName(name);
    }

    @Override
    public List<Project> findByStudent(Long num) {
        return projectRepository.findByStudent(studentRepository.findStudentByNum(num));
    }

    @Override
    public List<Project> findByTeacher(Long num) {
        return projectRepository.findByTeacher(teacherRepository.findTeacherByNum(num));
    }

    @Override
    public List<Project> findByExpert(Long num) {
        return null;
    }

    @Override
    public Project saveOrUpdate(Project project) throws Exception {
        if(project.getId() == null){
            project.setEReason("");
            project.setEStatus(0);
            project.setTStatus(0);
            project.setTReason("");
            if(project.getTeam() == null){
                project.setTeam("个人赛无团队");
            }
            project.setCreateDate(DateUtils.getCurrentDateStr());
            Notice notice = new Notice();
            notice.setStatus("创建项目");
            try {
                notice.setDate(DateUtils.getCurrentDateStr());
            } catch (Exception e) {
                e.printStackTrace();
            }
            notice.setContent(project.getStudent().getName()+"创建了"+project.getName()+"项目");
            notice.setOperation("创建项目");
            notice.setProjectName(project.getName());
            notice.setStudentNum(project.getStudent().getNum());
            notice.setLevel(1);

            typeService.addCount(project.getType().getNum());

            noticeRepository.save(notice);
        }else{
            project.setEReason("");
            project.setEStatus(0);
            project.setTStatus(0);
            project.setTReason("");
            project.setUpdateDate(DateUtils.getCurrentDateStr());
        }
        System.out.println(project);
        return projectRepository.save(project);
    }

    @Override
    public void delete(Integer id) {
        Project project = projectRepository.findById(id).get();

        if(project.getType().getNumber()>0){
            typeService.reduceCount(project.getType().getNum());
        }

        projectRepository.delete(project);
    }

    @Override
    public Page<Project> findAll(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public void changeStatus(Integer id, String role, String advise) {
        try {
            Project project = projectRepository.findById(id).get();
            Notice notice = new Notice();
            switch (role) {
                case "expert":
                    notice.setStudentNum(project.getStudent().getNum());
                    notice.setProjectName(project.getName());
                    notice.setOperation("项目专家审核");
                    notice.setContent(advise);
                    notice.setStatus(project.getEStatus() == 0 ? "通过" : "撤回");
                    notice.setDate(DateUtils.getCurrentDateStr());
                    notice.setLevel(project.getTStatus() == 0? 4:3);
                    projectRepository.changeExpertStatus(project.getEStatus() == 0 ? 1 : 0, advise, project.getId());
                    noticeRepository.save(notice);
                    break;
                case "teacher":
                    notice.setStudentNum(project.getStudent().getNum());
                    notice.setProjectName(project.getName());
                    notice.setOperation("教师审核");
                    notice.setContent(advise);
                    notice.setStatus(project.getTStatus() == 0 ? "通过" : "撤回");
                    notice.setLevel(project.getTStatus() == 0? 2:1);
                    notice.setDate(DateUtils.getCurrentDateStr());
                    projectRepository.changeTeacherStatus(project.getTStatus() == 0 ? 1 : 0, advise, project.getId());
                    noticeRepository.save(notice);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void reject(Integer id, String role, String advise) {
        try {
            Project project = projectRepository.findById(id).get();
            Notice notice = new Notice();
            switch (role) {
                case "expert":
                    notice.setStudentNum(project.getStudent().getNum());
                    notice.setProjectName(project.getName());
                    notice.setOperation("项目专家审核");
                    notice.setContent(advise);
                    notice.setStatus(project.getEStatus() == 0 ? "拒绝" : "" +
                            "");
                    notice.setDate(DateUtils.getCurrentDateStr());
                    notice.setLevel(project.getTStatus() == 0? 4:3);
                    projectRepository.changeExpertStatus(project.getEStatus() == 0 ? 2 : 0, advise, project.getId());
                    noticeRepository.save(notice);
                    break;
                case "teacher":
                    notice.setStudentNum(project.getStudent().getNum());
                    notice.setProjectName(project.getName());
                    notice.setOperation("教师审核");
                    notice.setContent(advise);
                    notice.setStatus(project.getTStatus() == 0 ? "拒绝" : "");
                    notice.setLevel(project.getTStatus() == 0? 2:1);
                    notice.setDate(DateUtils.getCurrentDateStr());
                    projectRepository.changeTeacherStatus(project.getTStatus() == 0 ? 2 : 0, advise, project.getId());
                    noticeRepository.save(notice);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Project> findByNameLike(String name) {
        return projectRepository.findByName(name);
    }

    @Override
    public List<Project> findByType(Type type) {
        return projectRepository.findByType(type);
    }
}
