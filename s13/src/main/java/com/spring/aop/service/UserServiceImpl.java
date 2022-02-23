package com.spring.aop.service;

/**
 * @author: lijinhao
 * @date: 2022/02/23 10:31
 */
public class UserServiceImpl implements UserService{

    @Override
    public void createrUser() {
        System.out.println("执行新增用户逻辑");

    }
}
