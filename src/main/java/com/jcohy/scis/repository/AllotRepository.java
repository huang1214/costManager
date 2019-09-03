package com.jcohy.scis.repository;

import com.jcohy.scis.model.Allot;
import com.jcohy.scis.model.Expert;
import com.jcohy.scis.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 20:41 2018/4/7
 * Email: jia_chao23@126.com
 * ClassName: AllotRepository
 * Description:
 **/
public interface AllotRepository extends JpaRepository<Allot,Integer>{

    List<Allot> findByExpert(Expert expert);

    List<Allot> findByProject(Project project);
}
