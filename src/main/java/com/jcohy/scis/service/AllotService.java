package com.jcohy.scis.service;

import com.jcohy.scis.exception.ServiceException;
import com.jcohy.scis.model.Allot;
import com.jcohy.scis.model.Expert;
import com.jcohy.scis.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 20:41 2018/4/7
 * Email: jia_chao23@126.com
 * ClassName: AllotService
 * Description:
 **/
public interface AllotService {

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<Allot> findAll(Pageable pageable);

    List<Allot> findAll();

    Allot findById(Integer id);

    List<Project> findByExpert(Expert expert);

    Expert findByProject(Project project);

    List<Allot> findByOtherId(Integer id,String type);

    Allot saveOrUpdate(Allot allot) throws ServiceException;

    void delete(Integer id);

    boolean check(Allot allot);
}
