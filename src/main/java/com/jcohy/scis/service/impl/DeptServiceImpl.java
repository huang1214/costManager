package com.jcohy.scis.service.impl;

import com.jcohy.date.DateUtils;
import com.jcohy.scis.model.Dept;
import com.jcohy.scis.repository.DeptRepository;
import com.jcohy.scis.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 22:08 2018/4/6
 * Email: jia_chao23@126.com
 * ClassName: DeptServiceImpl
 * Description:
 **/
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptRepository deptRepository;


    @Override
    public Page<Dept> findAll(Pageable pageable) {
        return deptRepository.findAll(pageable);
    }

    @Override
    public List<Dept> findAll() {
        return deptRepository.findAll();
    }

    @Override
    public Dept findById(Integer id) {
        return deptRepository.findById(id).get();
    }

    @Override
    public Dept save(Dept dept) throws Exception {
        Dept dbDept = null;
        if(dept.getId() != null){
            dbDept = deptRepository.findById(dept.getId()).get();
            if(dept.getNum() != null) dbDept.setNum(dept.getNum());
            if(dept.getName() != null) dbDept.setName(dept.getName());
            if(dept.getChairman() != null) dbDept.setChairman(dept.getChairman());
            if(dept.getDesc() != null) dbDept.setDesc(dept.getDesc());
            if(dept.getTel() != null) dbDept.setTel(dept.getTel());
            dbDept.setUpdateDate(DateUtils.getCurrentDateStr());
        }else{
            dbDept = dept;
            dbDept.setCreateDate(DateUtils.getCurrentDateStr());
        }
        return deptRepository.save(dbDept);
    }

    @Override
    public void delete(Integer id) {
            deptRepository.deleteById(id);
    }

    @Override
    public List<Dept> findByName(String name) {
        return deptRepository.findByName(name);
    }

    @Override
    public List<Dept> findByNum(Long num) {
        return deptRepository.findByNum(num);
    }
}
