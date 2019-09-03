package com.jcohy.scis.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 14:04 2018/4/7
 * Email: jia_chao23@126.com
 * ClassName: Allot
 * Description:
 **/

@Entity
@Table(name = "allot")
public class Allot {

    private static final long serialVersionUID = 9L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    private String start;

    private String end;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @OneToOne
    @JoinColumn(name = "expert_id")
    private Expert expert;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Expert getExpert() {
        return expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }
}
