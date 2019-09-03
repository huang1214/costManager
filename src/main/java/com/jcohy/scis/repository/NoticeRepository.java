package com.jcohy.scis.repository;

import com.jcohy.scis.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by jiac on 2018/4/2.
 * Description  :
 */
public interface NoticeRepository extends JpaRepository<Notice,Integer> {

    List<Notice> findByStudentNum(Long num);
    @Query("select n from Notice n  where n.level between ?1 and  ?2")
    List<Notice> findByLevelBetween(Integer min,Integer max);
}
