package com.spring.ioc;

import com.spring.ioc.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: lijinhao
 * @date: 2022/02/18 13:36
 */
public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        System.out.println("=================");
        UserService userService = context.getBean("userService", UserService.class);
        userService.init();
//        System.out.println(userService.getUdao());
    }
}
