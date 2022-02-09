package com.spring.ioc;

import com.spring.ioc.entity.Apple;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: lijinhao
 * @date: 2022/02/08 14:16
 */
public class SpringApplication {
    public static void main(String[] args) {
        // ApplicationContext接口的唯一职责就是初始化ioc容器并且实例化对象
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

//        Apple apple1 = context.getBean("apple1", Apple.class);
//        System.out.println(apple1.getTitle());
    }
}
