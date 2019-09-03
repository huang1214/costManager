package com.jcohy.scis.repository;

import com.jcohy.scis.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jiac on 2018/4/2.
 * Description  :
 */
public interface TeacherRepository  extends JpaRepository<Teacher,Integer> {

    Teacher findTeacherByNum(Long num);

    Teacher findTeacherByName(String name);
}
