package com.jcohy.scis.controller;

import com.jcohy.scis.common.Data;
import com.jcohy.scis.common.Graph;
import com.jcohy.scis.common.JsonResult;
import com.jcohy.scis.model.Dept;
import com.jcohy.scis.model.Project;
import com.jcohy.scis.model.Type;
import com.jcohy.scis.service.DeptService;
import com.jcohy.scis.service.ProjectService;
import com.jcohy.scis.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:50 2018/5/30
 * Email: jia_chao23@126.com
 * ClassName: GraphController
 * Description:
 **/
@RestController
@RequestMapping("/graph")
public class GraphController {


    @Autowired
    private ProjectService projectService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private DeptService deptService;


    @PostMapping("/type")
    public JsonResult graph(){
        Graph graph = new Graph();
        List<Project> projects = projectService.findAll();
        List<Type> types = typeService.findAll();
        List<Dept> depts = deptService.findAll();
        List<Data> typeMap = new ArrayList<>();
        List<Data> deptMap = new ArrayList<>();
        List<Data> yearMap = new ArrayList<>();
        for(Type type:types){
            Data data = new Data();
            List<Project> service = projectService.findByType(type);
            if(service.size() == 0){
                data.setLabel(type.getName());
                data.setValue(0);
            }else{
                data.setLabel(type.getName());
                data.setValue(service.size());
            }
            typeMap.add(data);
        }


        for(Dept dept:depts){
            Data data = new Data();
            String deptName = dept.getName();
            int count = 0;
            for(Project project:projects){
                if(project.getStudent().getMajor().getDept().getName().equals(deptName)){
                    count++;
                }
            }
            if(count == 0){
                data.setLabel(deptName);
                data.setValue(0);
            }else{
                data.setLabel(deptName);
                data.setValue(count);
            }
            deptMap.add(data);
        }

        int count2015 = 0;
        int count2016 = 0;
        int count2017 = 0;
        int count2018 = 0;
        for(Project project:projects){

            if(project.getCreateDate().indexOf("2015") == 0){
                count2015++;
            }else if(project.getCreateDate().indexOf("2016") == 0){
                count2016++;
            }else if(project.getCreateDate().indexOf("2017") == 0){
                count2017++;
            }else if(project.getCreateDate().indexOf("2018") == 0){
                count2018++;
            }
        }
        yearMap.add(new Data("2015",count2015));
        yearMap.add(new Data("2016",count2016));
        yearMap.add(new Data("2017",count2017));
        yearMap.add(new Data("2018",count2018));
        graph.setType(typeMap);
        graph.setDeptMap(deptMap);
        graph.setYear(yearMap);
        System.out.println(graph);

        return JsonResult.ok("msg",graph);
    }
}
