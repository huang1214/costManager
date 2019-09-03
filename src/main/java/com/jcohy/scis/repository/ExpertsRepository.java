package com.jcohy.scis.repository;

import com.jcohy.scis.model.Expert;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 18:50 2018/4/6
 * Email: jia_chao23@126.com
 * ClassName: ExpertsRepository
 * Description:
 **/
public interface ExpertsRepository extends JpaRepository<Expert,Integer> {

    Expert findByNum(Long num);

    Expert findByName(String name);
}
