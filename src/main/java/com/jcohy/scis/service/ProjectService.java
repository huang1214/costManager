package com.jcohy.scis.service;

import com.jcohy.scis.exception.ServiceException;
import com.jcohy.scis.model.Allot;
import com.jcohy.scis.model.Project;
import com.jcohy.scis.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 16:03 2018/4/7
 * Email: jia_chao23@126.com
 * ClassName: ProjectService
 * Description:
 **/
public interface ProjectService {

    /**
     *  查询
     * @return
     */
    List<Project> findAll();


    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Project findById(Integer id);

    /**
     * 根据name查询
     * @param name
     * @return
     */
    Project findByName(String name);

    /**
     * 根据用户查询
     * @param num
     * @return
     */
    List<Project> findByStudent(Long num);

    /**
     * 根据老师查询
     * @param num
     * @return
     */
    List<Project> findByTeacher(Long num);

    /**
     * 根据专家查询
     * @param num
     * @return
     */
    List<Project> findByExpert(Long num);
    /**
     * 新增或者更新
     * @param project
     */
    Project saveOrUpdate(Project project) throws Exception;

    /**
     * 删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<Project> findAll(Pageable pageable);

    void changeStatus(Integer id,String role,String advise);

    void reject(Integer id,String role,String advise);
    /**
     * 模糊查询
     *
     * @return
     */
    List<Project> findByNameLike(String name);

    List<Project> findByType(Type type);
}
