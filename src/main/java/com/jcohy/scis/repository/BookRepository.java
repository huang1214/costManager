package com.jcohy.scis.repository;

import com.jcohy.scis.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 18:49 2018/4/6
 * Email: jia_chao23@126.com
 * ClassName: BookRepository
 * Description:
 **/
public interface BookRepository extends JpaRepository<Book,Integer> {
}
