package com.jcohy.scis.controller;

import com.jcohy.scis.common.PageJson;
import com.jcohy.scis.model.Project;
import com.jcohy.scis.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jiac on 2018/4/9.
 * ClassName  : com.jcohy.scis.controller
 * Description  :
 */
@Controller
@RequestMapping("/search")
public class SearchController {

    private Logger logger = LoggerFactory.getLogger(SearchController.class);
    @Autowired
    private ProjectService projectService;

    @GetMapping("/project")
    @ResponseBody
    public PageJson<Project> search(@PathParam("keyword") String keyword){
        logger.error("keyword :{}" ,keyword);
        List<Project> projectList = projectService.findAll();
        List<Project> projects = projectList.stream().filter(x -> x.getName().contains(keyword)).collect(Collectors.toList());
        PageJson<Project> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(projects.size());
        page.setData(projects);
        return page;
    }
}
