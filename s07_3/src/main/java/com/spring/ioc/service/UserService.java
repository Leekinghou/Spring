package com.spring.ioc.service;

import com.spring.ioc.dao.IUserDao;
import com.spring.ioc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author: lijinhao
 * @date: 2022/02/18 13:39
 */

@Service
@Scope("prototype") // 设置单例/多例模式，与XML中的bean scope完全相同
public class UserService {
    @Value("${metaData}") //读取config.properties的metaData属性值
    private String metaData;

    @Autowired
    private IUserDao udao;

    @Value("connection.username")
    private String username;

    @PostConstruct // XML中bean init-method完全相同
    public void init(){
        System.out.println("初始化UserService对象，metaData：" + metaData);
    }
    public UserService() {
        System.out.println("正在创建UserService: " + this);
    }

    public UserService(UserDao udao) {
        this.udao = udao;
    }

    public IUserDao getUdao() {
        return udao;
    }

    public void setUdao(UserDao udao) {
        System.out.println("setUdao: " + udao);
        this.udao = udao;
    }
}
