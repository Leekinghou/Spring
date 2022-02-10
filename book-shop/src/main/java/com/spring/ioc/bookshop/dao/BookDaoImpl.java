package com.spring.ioc.bookshop.dao;

/**
 * @author: lijinhao
 * @date: 2022/02/10 11:13
 */
public class BookDaoImpl implements BookDao{

    @Override
    public void insert() {
        System.out.println("向Mysql Book表插入一条数据");
    }
}
