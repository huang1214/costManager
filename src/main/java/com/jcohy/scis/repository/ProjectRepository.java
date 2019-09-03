package com.jcohy.scis.repository;

import com.jcohy.scis.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 18:51 2018/4/6
 * Email: jia_chao23@126.com
 * ClassName: ProjectRepository
 * Description:
 **/
public interface ProjectRepository extends JpaRepository<Project,Integer>{

    Project findAllByName(String name);

    List<Project> findByStudent(Student student);

    List<Project> findByTeacher(Teacher teacher);

    List<Project> findByType(Type type);

    @Transactional
    @Modifying
    @Query("update Project p set p.EStatus = ?1,p.EReason = ?2 where p.id = ?3")
    int changeExpertStatus(Integer status,String advise,Integer id);

    @Transactional
    @Modifying
    @Query("update Project p set p.TStatus = ?1,p.TReason = ?2 where p.id = ?3")
    int changeTeacherStatus(Integer status,String advise,Integer id);

    @Query(value = "select * from Project p where p.name like %?1%", nativeQuery = true)
    List<Project> findByName(String name);
}
