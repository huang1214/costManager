package com.jcohy.scis.service.impl;

import com.jcohy.lang.StringUtils;
import com.jcohy.scis.exception.ServiceException;
import com.jcohy.scis.model.Expert;
import com.jcohy.scis.repository.ExpertsRepository;
import com.jcohy.scis.service.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:14 2018/4/6
 * Email: jia_chao23@126.com
 * ClassName: ExpertServiceImpl
 * Description:
 **/
@Service
public class ExpertServiceImpl implements ExpertService {

    @Autowired
    private ExpertsRepository expertsRepository;

    @Override
    public Expert login(Long num, String password) throws Exception {
        return expertsRepository.findByNum(num);
    }

    @Override
    public Page<Expert> findAll(Pageable pageable) {
        return expertsRepository.findAll(pageable);
    }

    @Override
    public List<Expert> findAll() {
        return expertsRepository.findAll();
    }

    @Override
    public Expert findByNum(Long num) {
        return expertsRepository.findByNum(num);
    }

    @Override
    public Expert findById(Integer id) {
        return expertsRepository.findById(id).get();
    }

    @Override
    public Expert findByName(String name) {
        return expertsRepository.findByName(name);
    }

    @Override
    public void saveOrUpdate(Expert user) throws ServiceException {
        expertsRepository.save(user);
    }

    @Override
    public boolean checkUser(Long num) {
        Expert dbUser = expertsRepository.findByNum(num);
        return dbUser != null;

    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            throw new ServiceException("主键不能为空");
        }
        expertsRepository.deleteById(id);
    }

    @Override
    public void updatePassword(Expert user) {
        expertsRepository.saveAndFlush(user);
    }
}
