package com.jcohy.scis.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Description  :专业表
 */
@Entity
@Table(name = "major")
public class Major implements Serializable{
    private static final long serialVersionUID = 5L;
    //Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //专业编号
    @Column(name = "num")
    private Long num;
    //专业名
    @Column(name = "name")
    private String name;
    //专业办公室电话
    @Column(name = "tel")
    private String tel;
    //辅导员
    @Column(name = "assistant")
    private String assistant;
    //所属院系
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Dept dept;

    @Column(name = "create_date")
    private String createDate;

    @Column(name = "update_date")
    private String updateDate;

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAssistant() {
        return assistant;
    }

    public void setAssistant(String assistant) {
        this.assistant = assistant;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Major{");
        sb.append("id=").append(id);
        sb.append(", num=").append(num);
        sb.append(", name='").append(name).append('\'');
        sb.append(", tel='").append(tel).append('\'');
        sb.append(", assistant='").append(assistant).append('\'');
        sb.append(", dept=").append(dept);
        sb.append('}');
        return sb.toString();
    }
}
