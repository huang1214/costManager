package com.jcohy.scis.service;

import com.jcohy.scis.exception.ServiceException;
import com.jcohy.scis.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by jiac on 2017/12/18 09:22.
 * ClassName  : UserService
 * Description  :
 */

public interface StudentService {
    /**
     * 用户登录
     * @param num  编号
     * @param password
     * @return
     * @throws Exception
     */
    Student login(Long num, String password) throws Exception;


    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<Student> findAll(Pageable pageable);


    /**
     *  查询
     * @return
     */
    List<Student> findAll();


    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Student findById(Integer id);

    /**
     * 学号
     * @param num
     * @return
     */
    Student findByNum(Long num);

    /**
     * 根据name查询
     * @param name
     * @return
     */
    Student findByName(String name);

    /**
     * 新增或者更新用户
     * @param user
     */
    Student saveOrUpdate(Student user) throws ServiceException;

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
    void updatePassword(Student user);
}
