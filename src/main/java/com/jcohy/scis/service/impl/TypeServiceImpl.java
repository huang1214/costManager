package com.jcohy.scis.service.impl;

import com.jcohy.date.DateUtils;
import com.jcohy.scis.model.Dept;
import com.jcohy.scis.model.Type;
import com.jcohy.scis.repository.TypeRepository;
import com.jcohy.scis.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:49 2018/2/6
 * Email: jia_chao23@126.com
 * ClassName: TypeServiceImpl
 * Description:
 **/
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;
    @Override
    public List<Type> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public Page<Type> findAll(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public Type findById(Integer id) {
        return typeRepository.findById(id).get();
    }

    @Override
    public Type saveOrUpdate(Type type) throws Exception {
        Type dbType = null;
        if(type.getId() != null){
            dbType = typeRepository.findById(type.getId()).get();
            if(type.getNum() != null) dbType.setNum(type.getNum());
            if(type.getName() != null) dbType.setName(type.getName());
            dbType.setUpdateDate(DateUtils.getCurrentDateStr());
        }else{
            dbType = type;
            dbType.setNumber(0);
            dbType.setCreateDate(DateUtils.getCurrentDateStr());
        }
        return typeRepository.save(dbType);
    }

    @Override
    public void addCount(Long num) {
        List<Type> types = typeRepository.findByNum(num);
        for(Type type:types){
            type.setNumber(type.getNumber()+1);
            typeRepository.save(type);
        }
    }

    @Override
    public void reduceCount(Long num) {
        List<Type> types = typeRepository.findByNum(num);
        for(Type type:types){
            if(type.getNumber()>0){
                type.setNumber(type.getNumber()-1);
                typeRepository.save(type);
            }
        }
    }

    @Override
    public void delete(Integer id) {
        typeRepository.deleteById(id);
    }

    @Override
    public List<Type> findByNum(Long num) {
        return typeRepository.findByNum(num);
    }
}
