package com.jcohy.scis.service;

import com.jcohy.scis.model.Allot;
import com.jcohy.scis.model.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 0:15 2018/4/11
 * Email: jia_chao23@126.com
 * ClassName: NoticeService
 * Description:
 **/
public interface NoticeService {

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<Notice> findAll(Pageable pageable);

    List<Notice> findAll();

    Notice save(Notice notice);

    void delete(Integer id);

    List<Notice> findbyNum(Long num);

    List<Notice> findByLevel(Integer Level);
}
