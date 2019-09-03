package com.jcohy.scis.service;

import com.jcohy.scis.model.Book;

/**
 * Created by jiac on 2018/4/9.
 * ClassName  : com.jcohy.scis.service
 * Description  :
 */
public interface BookService {

    Book saveOrUpdate(Book book);
}
