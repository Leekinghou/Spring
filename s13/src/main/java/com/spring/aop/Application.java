package com.spring.aop;

import com.spring.aop.service.UserService;
import com.spring.aop.service.UserServiceImpl;
import com.spring.aop.service.UserServiceProxy;

/**
 * @author: lijinhao
 * @date: 2022/02/23 14:32
 */

public class Application {
    public static void main(String[] args) {
        UserService userService = new UserServiceProxy(new UserServiceImpl());
        userService.createrUser();
    }
}
