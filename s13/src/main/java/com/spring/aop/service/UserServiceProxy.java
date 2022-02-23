package com.spring.aop.service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: lijinhao
 * @date: 2022/02/23 14:34
 */

public class UserServiceProxy implements UserService{
    // 持有委托类的对象
    private UserService userService;

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void createrUser() {
        System.out.println("=======" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()) +
                "=======");
        userService.createrUser();
    }
}
