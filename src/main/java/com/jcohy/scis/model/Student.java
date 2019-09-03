package com.jcohy.scis.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Description  :学生表
 */
@Entity()
@Table(name = "student")
public class Student  implements Serializable {

    private static final long serialVersionUID = 7L;
    //Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //学号
    @Column(name = "num")
    private Long num;
    //密码
    @Column(name = "password")
    private String password;
    //电话
    @Column(name = "phone")
    private String phone;
    //名字
    @Column(name = "name")
    private String name;
    //性别
    @Column(name = "sex")
    private String sex;
    //生日
    @Column(name = "birth")
    private String birth;
    //班级
    @Column(name = "sclass")
    private String sclass;
    //专业
    @ManyToOne(optional = true)
    @JoinColumn(name = "major_id")
    private Major major;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id=").append(id);
        sb.append(", num=").append(num);
        sb.append(", password='").append(password).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", sex='").append(sex).append('\'');
        sb.append(", birth='").append(birth).append('\'');
        sb.append(", sclass='").append(sclass).append('\'');
        sb.append(", major=").append(major);
        sb.append('}');
        return sb.toString();
    }
}
