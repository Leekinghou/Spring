package com.spring.aop;

import com.spring.aop.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: lijinhao
 * @date: 2022/02/21 21:47
 */


public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        UserService userService = context.getBean("userService", UserService.class);
        userService.createUser();
        userService.generateRandomPassword("MD5", 16);
    }
}
