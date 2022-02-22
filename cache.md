# 初识AOP

- Aspect oriented Programming面向切面编程
- AOP的做法是将通用的、与业务无关的功能抽象封装为切面类
- 切面可以配置在目标方法执行前、后运行，即插即用
![](https://gitee.com/leekinghou/image/raw/master/img/20220221212135.png)
  
可以在不修改源码的情况下对程序行为进行扩展
AOP底层依赖
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.2.19.RELEASE</version>
    </dependency>

    <dependency>
        <groupId>org.aspectj</groupId>
        <artifactId>aspectjweaver</artifactId>
        <version>1.9.8</version>
    </dependency>
</dependencies>
```

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

切面类：
需要增加连接点
```java
//切面类
public class MethodAspect {
    //切面方法，用于拓展额外的功能
    //JoinPoint连接点，通过连接点可以获取目标类/方法的信息
    public void printExecutionTime(JoinPoint joinPoint){
    
    }
}
```

AoP配置:
```xml
<!--  AOP配置  -->
<bean id="methodAspect" class="com.spring.aop.aspect.MethodAspect"/>
<aop:config>
    <!--    PointCut 切点，使用execution表达式描述切面的作用范围    -->
    <!--    public * com.spring..*.*(..)表示切面作用于com.spring包下所有类的所有方法上    -->
    <aop:pointcut id="pointcut" expression="execution(public * com.spring..*.*(..))"></aop:pointcut>
    <!--    定义切面类    -->
    <aop:aspect ref="methodAspect">
        <!--      before通知，代表在目标方法运行前先执行methodAspect.printExecutionTime()      -->
        <aop:before method="printExecutionTime" pointcut-ref="pointcut"/>
    </aop:aspect>
</aop:config>
```





