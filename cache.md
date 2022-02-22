# 初识AOP

- Aspect oriented Programming面向切面编程
- AOP的做法是将通用的、与业务无关的功能抽象封装为切面类
- 切面可以配置在目标方法执行前、后运行，即插即用
![](https://gitee.com/leekinghou/image/raw/master/img/20220221212135.png)
  
可以在不修改源码的情况下对程序行为进行扩展

AOP特有的Scanner
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:p="http://www.springframework.org/schema/p" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
     http://www.springframework.org/schema/beans/spring-beans-4.1.xsd
     http://www.springframework.org/schema/context
     http://www.springframework.org/schema/context/spring-context-4.1.xsd
     http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.1.xsd">
</beans>
```
补充:  
如果是要引用别的bean，那么要加上`<property ref="……">`
```xml
    <bean id="userDao" class="com.spring.aop.dao.UserDao"/>

    <bean id="userService" class="com.spring.aop.service.UserService">
        <property name="userDao" ref="userDao"/>
    </bean>
```

