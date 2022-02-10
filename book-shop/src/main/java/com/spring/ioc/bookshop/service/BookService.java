package com.spring.ioc.bookshop.service;

import com.spring.ioc.bookshop.dao.BookDao;

/**
 * @author: lijinhao
 * @date: 2022/02/10 11:14
 */
public class BookService {
    private BookDao bookDao;
    public void purchase(){
        System.out.println("正在执行图书采购业务方法");
        bookDao.insert();
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
