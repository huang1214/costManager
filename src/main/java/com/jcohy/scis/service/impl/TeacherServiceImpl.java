package com.jcohy.scis.service.impl;

import com.jcohy.lang.StringUtils;
import com.jcohy.scis.exception.ServiceException;
import com.jcohy.scis.model.Teacher;
import com.jcohy.scis.repository.TeacherRepository;
import com.jcohy.scis.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jiac on 2018/4/2.
 * Description  :
 */
@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepository teacherRepository;


    @Override
    public Teacher login(Long num, String password) throws Exception {
        return teacherRepository.findTeacherByNum(num);
    }

    @Override
    public Page<Teacher> findAll(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findByNum(Long num) {
        return teacherRepository.findTeacherByNum(num);
    }


    @Override
    public Teacher findById(Integer id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public Teacher findByName(String name) {
        return teacherRepository.findTeacherByName(name);
    }

    @Override
    public void saveOrUpdate(Teacher user) throws ServiceException {
        teacherRepository.save(user);
    }

    @Override
    public boolean checkUser(Long num) {
        Teacher dbUser = teacherRepository.findTeacherByNum(num);
        return dbUser != null;
    }


    @Override
    public void delete(Integer id) {
        if(id == null){
            throw new ServiceException("主键不能为空");
        }
        teacherRepository.deleteById(id);
    }

    @Override
    public void updatePassword(Teacher user) {

        teacherRepository.saveAndFlush(user);
    }
}
