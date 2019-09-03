package com.jcohy.scis.controller;

import com.jcohy.lang.StringUtils;
import com.jcohy.scis.common.PageJson;
import com.jcohy.scis.model.*;
import com.jcohy.scis.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 20:38 2018/4/7
 * Email: jia_chao23@126.com
 * ClassName: ExpertController
 * Description:
 **/
@Controller
@RequestMapping("/expert")
public class ExpertController extends BaseController{

    @Autowired
    private StudentService studentService;

    @Autowired
    private AllotService allotService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ExpertService expertService;

    @GetMapping("/project/list")
    @ResponseBody
    public PageJson<Project> all(@SessionAttribute("user") Expert expert , ModelMap map){
        PageRequest pageRequest = getPageRequest();

        List<Project> projects = allotService.findByExpert(expert);
        projects.stream().forEach(string ->{
            string.setExpert(expert);
            string.setOperator("expert");
        });

        if(projects.size()>((pageRequest.getPageNumber()+1)*pageRequest.getPageSize())){
            List<Project> projects1 = projects.subList(0, pageRequest.getPageSize());
            projects.clear();
            projects.addAll(projects1);
        }
        PageJson<Project> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(projects.size());
        page.setData(projects);
        return page;
    }

    @GetMapping("/form")
    public String form(@RequestParam(required = false) Integer id, ModelMap map){
        List<Teacher> teachers = teacherService.findAll();
        map.put("teachers",teachers);
        if(id != null){
            Project project = projectService.findById(id);
            map.put("project",project);
        }
        return "student/form";
    }

    @GetMapping("/list")
    @ResponseBody
    public PageJson<Expert> teacher(@SessionAttribute("user") Expert expert , ModelMap map){
        List<Expert> experts = expertService.findAll();
        PageJson<Expert> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(experts.size());
        page.setData(experts);
        return page;
    }

    @GetMapping("/search")
    @ResponseBody
    public PageJson search(String keyword){
        List<Expert> experts = new ArrayList<>();
        if(!StringUtils.isEmpty(keyword)){
            boolean isNum = keyword.matches("[0-9]+");
            if(isNum){
                Expert teacher = expertService.findByNum(Long.parseLong(keyword));
                experts.add(teacher);
            }else{
                Expert teacher = expertService.findByName(keyword);
                experts.add(teacher);
            }
        }else{
           experts = expertService.findAll();
        }
        PageJson<Expert> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(experts.size());
        page.setData(experts);
        return page;
    }
}
