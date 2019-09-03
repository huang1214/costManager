package com.jcohy.scis.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Description  :教师表
 */
@Entity
@Table(name = "teacher")
public class Teacher implements Serializable{

    private static final long serialVersionUID = 8L;
    //Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //编号
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
    //职称
    @Column(name = "title")
    private String title;
    @Column(name = "address")
    private String address;
    @Column(name = "resume")
    private String resume;
    //状态
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Dept dept;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Teacher{");
        sb.append("id=").append(id);
        sb.append(", num=").append(num);
        sb.append(", password='").append(password).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", sex='").append(sex).append('\'');
        sb.append(", birth='").append(birth).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", resume='").append(resume).append('\'');
        sb.append(", dept=").append(dept);
        sb.append('}');
        return sb.toString();
    }
}
