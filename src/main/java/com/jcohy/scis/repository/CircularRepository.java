package com.jcohy.scis.repository;

import com.jcohy.scis.model.Circular;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jiac on 2018/1/31 09:23.
 * ClassName  : NoticeRepository
 * Description  :
 */
public interface CircularRepository extends JpaRepository<Circular,Integer> {


    /**
     * 查询所有可见
     * @param visible
     * @return
     */
    List<Circular> findAllByVisible(int visible);
}
