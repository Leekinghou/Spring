package com.spring.ioc.bookshop.dao;

/**
 * @author: lijinhao
 * @date: 2022/02/10 11:22
 */
public class BookDaoOracleImpl implements BookDao{

    @Override
    public void insert() {
        System.out.println("向Oracle Book表插入一条数据");    }
}
