package com.jcohy.scis.controller;

import com.jcohy.scis.common.JsonResult;
import com.jcohy.scis.common.PageJson;
import com.jcohy.scis.model.Expert;
import com.jcohy.scis.model.Project;
import com.jcohy.scis.service.AllotService;
import com.jcohy.scis.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 18:07 2018/4/7
 * Email: jia_chao23@126.com
 * ClassName: ProjectController
 * Description:
 **/
@Controller
@RequestMapping("/project")
public class ProjectController extends BaseController{


    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    private ProjectService projectService;

    @Autowired
    private AllotService allotService;

    @GetMapping("/history")
    public String history(){
        return "/project/history";
    }
    @GetMapping("/all")
    @ResponseBody
    public PageJson<Project> all(){
        PageRequest pageRequest = getPageRequest();
        Page<Project> projects = projectService.findAll(pageRequest);
        for(Project project : projects.getContent()){
            Expert expert = allotService.findByProject(project);
            if(expert == null){
                project.setExpert(null);
            }
            project.setOperator("admin");
            project.setExpert(expert);
        }
        List<Project> collect = projects.getContent().stream().filter(x -> x.getEStatus() == 1).collect(Collectors.toList());
        PageJson<Project> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(collect.size());
        page.setData(collect);
        return page;
    }
    @DeleteMapping("/{id}/del")
    @ResponseBody
    public JsonResult del(@PathVariable("id") Integer id){
        try {
            allotService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail("删除失败");
        }
        return JsonResult.ok();
    }

    @GetMapping("/change/{id}")
    @ResponseBody
    public JsonResult change(@SessionAttribute("role")String role,@PathVariable("id") Integer id,@RequestParam("advise") String advise){
        logger.error("role:{} id: {} advice: {}",role,id,advise);
        try {
            projectService.changeStatus(id,role,advise);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail("修改失败");
        }
        return JsonResult.ok();
    }
    @GetMapping("/{id}")
    public String detail(@PathVariable Integer id, ModelMap map){
        Project project = projectService.findById(id);
        map.put("project",project);
        Expert expert = allotService.findByProject(project);
        map.put("expert",expert);
        return "detail";
    }

    /**
     * 搜索模糊查询
     * @param keyword
     * @return
     */
    @PostMapping("/search")
    @ResponseBody
    public JsonResult searchJob(String keyword){
        List<Project> projects = projectService.findByNameLike(keyword);
        System.out.println("=============================");
        projects.forEach(System.out::println);
        return JsonResult.ok().set("data", projects);
    }

    @GetMapping("/reject/{id}")
    @ResponseBody
    public JsonResult reject(@SessionAttribute("role")String role,@PathVariable("id") Integer id,@RequestParam("advise") String advise){
        logger.error("role:{} id: {} advice: {}",role,id,advise);
        try {
            projectService.reject(id,role,advise);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail("修改失败");
        }
        return JsonResult.ok();
    }

    @GetMapping("/video/{id}")
    public String video(@PathVariable("id") Integer id,ModelMap map){
        logger.error("id: {}",id);
        try {
//            projectService.changeStatus(id,role,advise);
            Project project = projectService.findById(id);
            map.put("url",project.getVideo().getDownloadUrl());
        } catch (Exception e) {
        }
        return "video";
    }
}
