package com.spring.ioc.service;

import com.spring.ioc.dao.UserDao;

/**
 * @author: lijinhao
 * @date: 2022/02/16 17:15
 */
public class UserService {
    private UserDao userDao;

    public UserService() {
        System.out.println("UserService已创建：" + this);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        System.out.println("调用UserService：" + this);
        this.userDao = userDao;
    }
}
