package com.spring.jdbc;

import com.spring.jdbc.dao.EmployeeDao;
import com.spring.jdbc.entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * @author: lijinhao
 * @date: 2022/02/24 20:43
 */

public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        EmployeeDao employeeDao = context.getBean("employeeDao", EmployeeDao.class);
        Employee emp = employeeDao.findById(3308);
        System.out.println(emp);

        System.out.println("===========");

        List<Map<String, Object>> maps = employeeDao.findMapByDname("研发部");
        System.out.println(maps);
    }
}
