package com.jcohy.scis.repository;

import com.jcohy.scis.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jiac on 2018/4/2.
 * Description  :
 */
public interface StudentRepository  extends JpaRepository<Student,Integer> {

    Student findStudentByNum(Long num);

    Student findStudentByName(String name);


}
