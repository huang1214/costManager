package com.jcohy.scis.model;

import javax.persistence.*;

/**
 * Created by jiac on 2018/4/10.
 * ClassName  : com.jcohy.scis.model
 * Description  :
 */
@Entity
@Table(name = "notice")
public class Notice {

    private static final long serialVersionUID = 9L;
    //Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "student_num")
    private Long studentNum;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "operation")
    private String operation;

    @Column(name = "status")
    private String status;

    @Column(name = "content")
    private String content;

    @Column(name = "operation_date")
    private String date;

    @Column(name = "level")
    private Integer level;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Notice() {
    }

    public Notice(Long studentNum, String projectName, String operation, String status, String content, String date) {
        this.studentNum = studentNum;
        this.projectName = projectName;
        this.operation = operation;
        this.status = status;
        this.content = content;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Long studentNum) {
        this.studentNum = studentNum;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
