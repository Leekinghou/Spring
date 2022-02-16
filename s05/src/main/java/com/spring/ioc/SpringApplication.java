package com.spring.ioc;

import com.spring.ioc.dao.UserDao;
import com.spring.ioc.entity.Order;
import com.sun.tools.corba.se.idl.constExpr.Or;
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

        System.out.println("======IoC容器已经完成初始化======");
        Order order1 = context.getBean("order1", Order.class);
        order1.pay();

        // 销毁容器
        ((ClassPathXmlApplicationContext) context).registerShutdownHook();
    }
}
