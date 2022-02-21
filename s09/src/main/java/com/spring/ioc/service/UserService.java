package com.spring.ioc.service;


import com.spring.ioc.dao.UserDao;

/**
 * @author: lijinhao
 * @date: 2022/02/21 12:13
 */

public class UserService {
    private UserDao userDao;

    public void createUser(){
        System.out.println("调用创建用户业务代码");
        userDao.insert();
    }
    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
