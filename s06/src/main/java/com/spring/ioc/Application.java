package com.spring.ioc;

import com.spring.ioc.context.ApplicationContext;
import com.spring.ioc.context.ClassPathXmlApplicationContext;
import com.spring.ioc.entity.Apple;

/**
 * @author: lijinhao
 * @date: 2022/02/16 22:15
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Apple apple = (Apple) context.getBean("sweetApple");
        System.out.println(apple);
    }
}
