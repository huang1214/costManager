package com.jcohy.scis.service;

import com.jcohy.scis.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:47 2018/2/6
 * Email: jia_chao23@126.com
 * ClassName: TypeService
 * Description:
 **/
public interface TypeService {


    /**
     * 查询所有标签
     * @return
     */
    List<Type> findAll();

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<Type> findAll(Pageable pageable);

    /**
     * 通过Id查找
     * @param id
     * @return
     */
    Type findById(Integer id);

    /**
     * 增加，修改
     * @param type
     */
    Type saveOrUpdate(Type type) throws Exception;

    /**
     * 修改数量
     * @param num
     */
    void addCount(Long num);

    /**
     * 修改数量
     * @param num
     */
    void reduceCount(Long num);

    /**
     *
     * 根据id删除
     * @param id
     */
    void delete(Integer id);

    List<Type> findByNum(Long num);
}
