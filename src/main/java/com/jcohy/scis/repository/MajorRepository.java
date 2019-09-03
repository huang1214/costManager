package com.jcohy.scis.repository;

import com.jcohy.scis.model.Dept;
import com.jcohy.scis.model.Major;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jiac on 2018/4/2.
 * Description  :
 */
public interface MajorRepository  extends JpaRepository<Major,Integer> {

    List<Major>  findAllByDept(Dept dept);

    List<Major> findByName(String name);

    List<Major> findByNum(Long num);
}
