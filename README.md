# Spring
Spring notebook
  
- ioc
  将对象交由ioc容器统一管理，对象和对象之间实现解耦
  通过修改配置文件修改对象关系
- DI 依赖注入
  由java反转实现
  
# 目录
- [reflection](#反射) 反射 reflection
- [i18n](#工厂模式) 工厂模式实例 i18n
- [S01](#使用Spring) 使用Spring
- [S02](#配置Bean) 配置Bean

# 前置知识

## 工厂模式
- 工厂模式用于隐藏创建对象的细节 
- 核心是工厂类（Factory）

## 反射

### 学习要点
- 反射及其作用
- 反射的四个核心类
- 反射在项目中的作用

### 什么是反射
**反射（reflection.reflect）是代码`在运行时`动态访问类与对象的技术**
- 来自于`java.lang.reflection.reflect`  
  初学java时，要实例化一个对象，需要：
```java
//Object obj = new Object<>();

MathOperation mathOperation = null;
// 因为newInstance()返回的是一个object对象，因此可以强转为MathOperation对象
mathOperation = (MathOperation) Class.forName("reflection.reflect." + op).newInstance();
int result = mathOperation.operate(a, b);
```
这个步骤在程序编译时运行。

### 反射的作用
大多数java框架都基于反射实现参数配置、动态注入等特性

### 反射核心类
|  方法   | 用途  |
|  ----  | ----  |
| Class.forName()  | 静态方法，用于获取指定Class对象 | 
| ClassObj.newInstance()  | 通过默认构造方法创建新的对象 |
| ClassObj.getConstructor()  | 获得指定的public修饰构造方法Constructor对象 |
| ClassObj.getMethod()  | 获得指定的public修饰Method对象 |
| ClassObj.getField()  | 获得指定的public修饰成员变量Field对象 |

# 使用Spring

## pom.xml文件
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>s01</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.2.19.RELEASE</version>
        </dependency>
    </dependencies>
</project>
```

## applicationContext.xml文件
- 添加bean
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--  在IOC容器启动时，自动由Spring实例化Apple对象，取名sweetApple放入到容器中  -->
    <bean id="sweetApple" class="spring.ioc.Apple">
        <property name="title" value="红富士"></property>
        <property name="origin" value="European"></property>
        <property name="color" value="red"></property>
    </bean>
</beans>
```
## 使用
```java
public class SpringApplication {
    public static void main(String[] args) {
        // ApplicationContext接口唯一职责是初始化ioc容器并且实例化对象
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        Child lily = context.getBean("lily", Child.class);
        lily.eat();

        Child andy = context.getBean("andy", Child.class);
        andy.eat();

        Child xiaomi = context.getBean("xiaomi", Child.class);
        xiaomi.eat();
    }
}
```

# 配置Bean
## 不同的配置方法
- 基于XML文件配置Bean
- 基于注解配置Bean

## 三种XML实例化Bean的配置方法
- 基于构造方法实例化对象
- 基于静态工厂实例化对象
- 基于工厂实例方法实例化对象

### 基于默认构造方法实例化对象
1. 修改配置文件
```xml
<!--  bean标签默认通过默认构造方法来创建对象  -->
<bean id="apple1" class="com.spring.ioc.entity.Apple">

</bean>
```

2. 新建启动入口
```java
public class SpringApplication {
    public static void main(String[] args) {
        // ApplicationContext接口的唯一职责就是初始化ioc容器并且实例化对象
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }
}

```
3. 在Apple类的默认构造方法中输出
```java
public class Apple {
  public Apple() {
    System.out.println("Apple对象已创建" + this);
  }
}
```

4. 输出
```shell
Apple对象已创建com.spring.ioc.entity.Apple@35fb3008
```
5. 总结
- 可见bean标签默认通过默认构造方法来创建对象
- 但是这样构造的对象没有参数传入，功能简陋
- 需要一个更好的创建对象方法

### 基于带参构造方法实例化对象
1. 新增bean, 主要是`constructor-arg`参数
```xml
<!--  bean标签通过带参构造方法来创建对象  -->
<bean id="apple2" class="com.spring.ioc.entity.Apple">
    <constructor-arg name="title" value="红富士"/>
    <constructor-arg name="color" value="red"/>
    <constructor-arg name="origin" value="European"/>
</bean>
```
2. 其余同默认构造方法

3. 输出
```shell
Apple对象通过带参构造方法已创建com.spring.ioc.entity.Apple@7cd62f43
```




