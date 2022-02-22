package com.spring.aop.service;

import com.spring.aop.dao.UserDao;

/**
 * 用户服务
 */
public class UserService {
    private UserDao userDao;

    public void createUser(){
        System.out.println("执行员工入职业务逻辑");
        userDao.insert();
    }

    public String generateRandomPassword(String type , Integer length){
        System.out.println("按" + type + "方式生成"+ length  + "位随机密码");
        return "Zxcquei1";
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
