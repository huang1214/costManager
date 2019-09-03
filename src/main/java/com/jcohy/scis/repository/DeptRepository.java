package com.jcohy.scis.repository;

import com.jcohy.scis.model.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jiac on 2018/4/2.
 * Description  :
 */
public interface DeptRepository  extends JpaRepository<Dept,Integer> {

    List<Dept> findByName(String name);

    List<Dept> findByNum(Long num);
}
