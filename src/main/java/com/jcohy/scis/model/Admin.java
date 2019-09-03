package com.jcohy.scis.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Description  :管理员表
 */
@Entity
@Table(name = "admin_copy1")
public class Admin implements Serializable{

    private static final long serialVersionUID = 1L;
    //Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //编号，使用此信息登录
    @Column(name = "num")
    private Long num;
    //名字
    @Column(name = "name")
    private String name;
    //密码
    @Column(name = "password")
    private String password;
    //电话
    @Column(name = "phone")
    private String phone;
    //性别
    @Column(name = "sex")
    private String sex;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Admin{");
        sb.append("id=").append(id);
        sb.append(", num=").append(num);
        return sb.toString();
    }
}
