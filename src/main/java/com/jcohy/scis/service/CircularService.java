package com.jcohy.scis.service;

import com.jcohy.scis.model.Circular;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by jiac on 2018/1/31 09:25.
 * ClassName  : NoticeService
 * Description  :
 */
public interface CircularService {

    /**
     * 查询所有留言
     * @return
     */
    List<Circular> findAll();

    /**
     * 查询所有可见
     *
     * @return
     */
    List<Circular> findAllVisiable();
    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<Circular> findAll(Pageable pageable);

    /**
     * 通过Id查找
     * @param id
     * @return
     */
    Circular findById(Integer id);

    /**
     * 增加，修改
     * @param circular
     */
    Circular saveOrUpdate(Circular circular) throws Exception;

    /**
     * 删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 改变状态。
     * @param id
     * @param type
     */
    void change(Integer id, String type);
}
