package com.jcohy.scis.service;

import com.jcohy.scis.exception.ServiceException;
import com.jcohy.scis.model.Expert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 18:52 2018/4/6
 * Email: jia_chao23@126.com
 * ClassName: ExpertService
 * Description:
 **/
public interface ExpertService {

    /**
     * 用户登录
     * @param num  管理员编号
     * @param password
     * @return
     * @throws Exception
     */
    Expert login(Long num, String password) throws Exception;


    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<Expert> findAll(Pageable pageable);


    /**
     *  查询
     * @return
     */
    List<Expert> findAll();

    /**
     * 帐号
     * @param num
     * @return
     */
    Expert findByNum(Long num);
    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Expert findById(Integer id);

    /**
     * 根据name查询
     * @param name
     * @return
     */
    Expert findByName(String name);

    /**
     * 新增或者更新用户
     * @param user
     */
    void saveOrUpdate(Expert user) throws ServiceException;

    /**
     * 检查用户是否存在
     * @param num
     * @return
     */
    boolean checkUser(Long num);

    /**
     * 删除用户
     * @param id
     */
    void delete(Integer id);

    /**
     * 修改用户密码
     * @param user
     */
    void updatePassword(Expert user);
}
