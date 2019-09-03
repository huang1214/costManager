package com.jcohy.scis.controller;

import com.jcohy.scis.model.Book;
import com.jcohy.scis.model.Project;
import com.jcohy.scis.service.BookService;
import com.jcohy.scis.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jiac on 2018/5/10.
 * ClassName  : com.jcohy.scis.controller
 * Description  :
 */
@Controller
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/video/{id}")
    public String video(@PathVariable Integer id, ModelMap map){
        Project project = projectService.findById(id);
        Book video = project.getVideo();
        logger.warn("video:"+video);
        map.put("video",video);
        return "video";
    }
}
