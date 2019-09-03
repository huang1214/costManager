package com.jcohy.scis.common;

import com.jcohy.scis.directive.CircularDirective;
import com.jcohy.scis.directive.ProjectDirective;
import com.jcohy.scis.model.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class FreeMarkerConfig {

    @Autowired
    private freemarker.template.Configuration configuration;
    

    @Autowired
    private ProjectDirective projectDirective;

    @Autowired
    private CircularDirective circularDirective;

    @PostConstruct
    public void setSharedVariable() {
    	try {
			configuration.setSharedVariable("projectList", projectDirective);
			configuration.setSharedVariable("circularList",circularDirective);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
