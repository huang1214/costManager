package com.jcohy.scis.service.impl;

import com.jcohy.date.DateUtils;
import com.jcohy.scis.model.Circular;
import com.jcohy.scis.repository.CircularRepository;
import com.jcohy.scis.service.CircularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jiac on 2018/1/31 09:25.
 * ClassName  : NoticeServiceImpl
 * Description  :
 */

@Service
public class CircularServiceImpl implements CircularService {


    @Autowired
    private CircularRepository circularRepository;

    @Override
    public List<Circular> findAll() {
        return circularRepository.findAll();
    }

    @Override
    public List<Circular> findAllVisiable() {
        return circularRepository.findAllByVisible(1);
    }

    @Override
    public Page<Circular> findAll(Pageable pageable) {
        return circularRepository.findAll(pageable);
    }

    @Override
    public Circular findById(Integer id) {
        return circularRepository.findById(id).get();
    }

    @Override
    public Circular saveOrUpdate(Circular notice) throws Exception {
        notice.setTargetUrl(notice.getUrl());
        if(notice.getId() != null){
            notice.setUpdateDate(DateUtils.getCurrentDateStr());
        }else{
            notice.setCreateDate(DateUtils.getCurrentDateStr());
        }
        return circularRepository.save(notice);
    }

    @Override
    public void delete(Integer id) {
        circularRepository.deleteById(id);
    }

    @Override
    public void change(Integer id, String type) {
        Circular blog = circularRepository.findById(id).get();
        switch (type){
            case "visible":
                blog.setVisible(blog.getVisible() == 0 ? 1 : 0);
                break;
            default:
                break;
        }
        circularRepository.save(blog);
    }
}
