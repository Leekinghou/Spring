package ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: lijinhao
 * @date: 2022/02/18 13:36
 */
public class SpringApplication {
    public static void main(String[] args) {
        //传入参数是Config这个类
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("===============");
        String[] ids = context.getBeanDefinitionNames();
        for(String id: ids){
            System.out.println(id + ":" + context.getBean(id));
        }

    }
}
