package com.jcohy.scis.repository;

import com.jcohy.scis.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jiac on 2018/4/2.
 * Description  :
 */
public interface AdminRepository extends JpaRepository<Admin,Integer> {

    Admin findAdminByNum(Long num);

    Admin findAdminByName(String name);

}
