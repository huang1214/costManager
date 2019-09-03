package com.jcohy.scis.service.impl;

import com.jcohy.date.DateUtils;
import com.jcohy.scis.model.Dept;
import com.jcohy.scis.model.Major;
import com.jcohy.scis.repository.MajorRepository;
import com.jcohy.scis.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 22:11 2018/4/6
 * Email: jia_chao23@126.com
 * ClassName: MajorServiceImpl
 * Description:
 **/
@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorRepository majorRepository;


    @Override
    public Page<Major> findAll(Pageable pageable) {
        return majorRepository.findAll(pageable);
    }

    @Override
    public List<Major> findAll() {
        return majorRepository.findAll();
    }

    @Override
    public Major findById(Integer id) {
        return majorRepository.findById(id).get();
    }

    @Override
    public List<Major> findByDept(Dept dept) {
        return majorRepository.findAllByDept(dept);
    }

    @Override
    public Major save(Major major) throws Exception {
        Major dbMajor = null;
        if(major.getId() != null){
            dbMajor = majorRepository.findById(major.getId()).get();
            if(major.getNum() != null) dbMajor.setNum(major.getNum());
            if(major.getName() != null) dbMajor.setName(major.getName());
            if(major.getAssistant() != null) dbMajor.setAssistant(major.getAssistant());
            if(major.getDept() != null) dbMajor.setDept(major.getDept());
            if(major.getTel() != null) dbMajor.setTel(major.getTel());
            dbMajor.setUpdateDate(DateUtils.getCurrentDateStr());
        }else{
            dbMajor = major;
            dbMajor.setCreateDate(DateUtils.getCurrentDateStr());
        }
        return majorRepository.save(dbMajor);
    }

    @Override
    public void delete(Integer id) {
        majorRepository.deleteById(id);
    }

    @Override
    public  List<Major> findByName(String name) {
        return majorRepository.findByName(name);
    }

    @Override
    public  List<Major> findByNum(Long num) {
        return majorRepository.findByNum(num);
    }
}
