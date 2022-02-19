package com.spring.ioc.service;

import com.spring.ioc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lijinhao
 * @date: 2022/02/18 13:39
 */

@Service
public class UserService {

    private UserDao udao;

    public UserService() {
        System.out.println("正在创建UserService: " + this);
    }

    public UserService(UserDao udao) {
        this.udao = udao;
    }

    public UserDao getUdao() {
        return udao;
    }

    @Autowired
    public void setUdao(UserDao udao) {
        System.out.println("setUdao: " + udao);
        this.udao = udao;
    }
}
