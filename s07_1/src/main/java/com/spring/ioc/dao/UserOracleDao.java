package com.spring.ioc.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @author: lijinhao
 * @date: 2022/02/19 23:10
 */

@Repository
@Primary
public class UserOracleDao implements IUserDao{
    public UserOracleDao() {
        System.out.println("正在创建UserOracleDao:" + this);
    }
}
