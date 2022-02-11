package com.spring.ioc;

import com.spring.ioc.entity.Company;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author: lijinhao
 * @date: 2022/02/10 18:15
 */
public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Company company = context.getBean("company", Company.class);
        System.out.println(company);

        String website = company.getInfo().getProperty("website");
        System.out.println(website);

        System.out.println("================");

        String[] beanName = context.getBeanDefinitionNames();
        for(String name: beanName){
            System.out.println(name);
        }
    }
}
