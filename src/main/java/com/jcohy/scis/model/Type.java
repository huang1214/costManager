package com.jcohy.scis.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jiac on 2018/5/25.
 * ClassName  : com.jcohy.scis.model
 * Description  :
 */
@Entity
@Table(name = "type")
public class Type implements Serializable {

    private static final long serialVersionUID = 53L;
    //Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //编号
    @Column(name = "num")
    private Long num;
    //名字
    @Column(name = "name")
    private String name;
    //院系主任
    @Column(name = "number")
    private Integer number;

    @Column(name = "create_date")
    private String createDate;

    @Column(name = "update_date")
    private String updateDate;


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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

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
}
