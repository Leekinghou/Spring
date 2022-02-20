package ioc;

import ioc.controlloer.UserController;
import ioc.dao.EmployeeDao;
import ioc.dao.UserDao;
import ioc.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lijinhao
 * @date: 2022/02/20 20:23
 */

@Configuration //当前类是一个配置类，用于替代applicationContext.xml
@ComponentScan(basePackages = "ioc")
public class Config {
    @Bean //Java Config 利用方法创建对象，将方法返回放入容器，beanId=对象名
    public UserDao userDao(){
        // 使用Java代码替代XML完成IoC容器配置
        UserDao userDao = new UserDao();
        System.out.println("已创建" + userDao);
        return userDao;
    }

    @Bean // <bean id="XXX" class="XXX">
    public UserService userService(UserDao userDao, EmployeeDao employeeDao){
        UserService userService = new UserService();
        System.out.println("已创建" + userService);
        // 调用set方法完成属性设置
        userService.setUserDao(userDao);

        userService.setEmployeeDao(employeeDao);
        System.out.println("调用setUserDao" + userDao);
        return userService;
    }

    @Bean
    public UserController userController(UserService userService){
        UserController userController = new UserController();
        System.out.println("已创建" + userController);
        userController.setUserService(userService);
        System.out.println("调用setUserService" + userService);
        return userController;
    }
}
