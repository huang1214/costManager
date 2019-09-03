package com.jcohy.scis.service;

import com.jcohy.scis.model.Allot;
import com.jcohy.scis.model.Dept;
import com.jcohy.scis.model.Major;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 22:10 2018/4/6
 * Email: jia_chao23@126.com
 * ClassName: MajorService
 * Description:
 **/
public interface MajorService {

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<Major> findAll(Pageable pageable);

    List<Major> findAll();

    Major findById(Integer id);

    List<Major> findByDept(Dept dept);

    Major save(Major dept) throws Exception;

    void delete(Integer id);

    List<Major> findByName(String name);

    List<Major> findByNum(Long num);
}
