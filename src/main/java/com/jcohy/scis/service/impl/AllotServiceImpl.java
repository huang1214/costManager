package com.jcohy.scis.service.impl;

import com.jcohy.date.DateUtils;
import com.jcohy.lang.StringUtils;
import com.jcohy.scis.exception.ServiceException;
import com.jcohy.scis.model.*;
import com.jcohy.scis.repository.AllotRepository;
import com.jcohy.scis.repository.NoticeRepository;
import com.jcohy.scis.service.AllotService;
import com.jcohy.scis.service.ExpertService;
import com.jcohy.scis.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 20:43 2018/4/7
 * Email: jia_chao23@126.com
 * ClassName: AllotServiceImpl
 * Description:
 **/
@Service
public class AllotServiceImpl implements AllotService {

    @Autowired
    private AllotRepository allotRepository;

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ExpertService expertService;

    @Override
    public Page<Allot> findAll(Pageable pageable) {
        return allotRepository.findAll(pageable);
    }

    @Override
    public List<Allot> findAll() {
        return allotRepository.findAll();
    }

    @Override
    public Allot findById(Integer id) {
        return allotRepository.findById(id).get();
    }

    @Override
    public List<Project> findByExpert(Expert expert) {
        List<Allot> allots = allotRepository.findByExpert(expert);
        List<Project> experts = new ArrayList<>();
        for (Allot allot : allots) {
            experts.add(allot.getProject());
        }
        return experts;
    }

    @Override
    public Expert findByProject(Project project) {
        List<Allot> allots = allotRepository.findByProject(project);
        if (allots == null || allots.size() == 0) {
            return new Expert();
        }
        return allots.get(0).getExpert();
    }

    @Override
    public List<Allot> findByOtherId(Integer id, String type) {
        List<Allot> allots = null;
        if(type.equals("project")){
            allots = allotRepository.findByProject(projectService.findById(id));
        }else if(type .equals("expert")){
            allots =  allotRepository.findByExpert(expertService.findById(id));
        }
        return allots;
    }

    @Transactional
    @Override
    public Allot saveOrUpdate(Allot allot) throws ServiceException {
        Allot dballot = null;
        Notice notice = new Notice();
        Notice notice1 = new Notice();
        try {
            if (allot.getId() != null) {
                dballot = findById(allot.getId());
                if (allot.getProject() != null) dballot.setProject(allot.getProject());
                if (allot.getExpert() != null) dballot.setExpert(allot.getExpert());
                if (allot.getContent() != null) dballot.setContent(allot.getContent());
                if (allot.getProject() != null) dballot.setProject(allot.getProject());
                if (allot.getStart() != null) dballot.setStart(allot.getStart());
                if (allot.getEnd() != null) dballot.setEnd(allot.getEnd());
                notice.setStudentNum(dballot.getProject().getStudent().getNum());
                notice.setProjectName(dballot.getProject().getName());
                notice.setOperation("项目分配");
                notice.setContent("你的项目已修改分配至" + dballot.getExpert().getName());
                notice.setLevel(0);
                notice.setDate(DateUtils.getCurrentDateStr());

                notice1.setStudentNum(dballot.getProject().getStudent().getNum());
                notice1.setProjectName(dballot.getProject().getName());
                notice1.setOperation("项目分配");
                notice1.setContent("已经为您分配到了项目：" + dballot.getExpert().getName()+"，请及时审核");
                notice1.setLevel(3);
                notice1.setDate(DateUtils.getCurrentDateStr());
            } else {
                dballot = allot;
                notice.setStudentNum(dballot.getProject().getStudent().getNum());
                notice.setProjectName(dballot.getProject().getName());
                notice.setOperation("项目分配");
                notice.setContent("你的项目已被分配至" + dballot.getExpert().getName());
                notice.setStatus("0");
                notice.setDate(DateUtils.getCurrentDateStr());

                notice1.setStudentNum(dballot.getProject().getStudent().getNum());
                notice1.setProjectName(dballot.getProject().getName());
                notice1.setOperation("项目分配");
                notice1.setContent("已经为您分配到了项目：" + dballot.getExpert().getName()+"，请及时审核");
                notice1.setStatus("3");
                notice1.setDate(DateUtils.getCurrentDateStr());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        noticeRepository.save(notice);
        noticeRepository.save(notice1);
        return allotRepository.save(dballot);
    }

    @Override
    public void delete(Integer id) {
        allotRepository.deleteById(id);
    }

    @Override
    public boolean check(Allot allot) {
        if(allot.getId() == null){
            List<Allot> allots = allotRepository.findByProject(allot.getProject());
            if (allotRepository.findByProject(allot.getProject()).size() > 0) {
                return false;
            }
        }
        return true;
    }
}
