package com.jcohy.scis.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Description  :院系表
 */
@Entity
@Table(name = "dept")
public class Dept implements Serializable{

    private static final long serialVersionUID = 3L;
    //Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //院系编号
    @Column(name = "num")
    private Long num;
    //名字
    @Column(name = "name")
    private String name;
    //院系主任
    @Column(name = "chairman")
    private String chairman;
    //电话
    @Column(name = "tel")
    private String tel;
    //简介
    @Column(name = "description")
    private String desc;

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

    public String getChairman() {
        return chairman;
    }

    public void setChairman(String chairman) {
        this.chairman = chairman;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", num=" + num +
                ", name='" + name + '\'' +
                ", chairman='" + chairman + '\'' +
                ", tel='" + tel + '\'' +
                ", desc='" + desc + '\'' +
                ", createDate='" + createDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                '}';
    }
}
