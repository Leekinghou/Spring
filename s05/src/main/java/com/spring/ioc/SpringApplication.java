package com.spring.ioc;

import com.spring.ioc.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: lijinhao
 * @date: 2022/02/15 18:27
 */
public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        context.getBean("userDao", UserDao.class);
    }
}
