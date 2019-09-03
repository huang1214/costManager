package com.jcohy.scis.directive;

import com.jcohy.scis.model.Project;
import com.jcohy.scis.service.ProjectService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by jiac on 2018/5/3.
 * ClassName  : com.jcohy.recruit.directive
 * Description  :
 */
@Component
public class ProjectDirective implements TemplateDirectiveModel{
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ProjectDirective.class);

    @Autowired
    private ProjectService projectService;
    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        List<Project> all = projectService.findAll();
        List<Project> list = all.stream().filter(x -> x.getEStatus() == 1).collect(Collectors.toList());
        logger.warn("Project:{}",list.size());
        environment.setVariable("list", new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25).build().wrap(list));
        if (templateDirectiveBody != null) {
            templateDirectiveBody.render(environment.getOut());
        }
    }
}
