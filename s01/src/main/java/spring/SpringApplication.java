package spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.Apple;
import spring.ioc.Child;

/**
 * @author: lijinhao
 * @date: 2022/02/07 21:31
 */
public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        Child lily = context.getBean("lily", Child.class);
        lily.eat();

        Child andy = context.getBean("andy", Child.class);
        andy.eat();

        Child xiaomi = context.getBean("xiaomi", Child.class);
        xiaomi.eat();
    }
}
