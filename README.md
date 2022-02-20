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
- [利用setter方法实现对象依赖注入](#利用setter方法实现对象依赖注入) 利用setter方法实现对象依赖注入
- [book-shop](#ioc项目代码中解耦合) ioc在实际项目中的重要用途（ref应用）
- [s04](#注入集合对象) 注入集合对象list、set、properties
- [高效函数](#高效函数) ApplicationContext对象的函数
- [bean scope](#beanScope属性) bean scope属性
- [s05](#生命周期) bean单例模式和多例模式，生命周期
- [s06](#手动实现极简的IoC容器)手动实现极简的IoC容器
- [s07](#基于注解配置IoC容器)基于注解配置IoC容器
- [s07_1](#Autowired自动装配注解)@Autowired自动装配注解
- [s07-2](#Resource装配注解)@Resource按名称自动装配注解
- [s07-3](#元数据注解)@Primary、@PostConstruct、@PreDestroy、@Scope、@Value
# 前置知识

## 工厂模式
- 工厂模式用于隐藏创建对象的细节 
- 核心是工厂类（Factory）
  ![](https://gitee.com/leekinghou/image/raw/master/img/20220209123736.png)
- 多语言切换、多种设备（桌面/手机/平板）展示
## 反射

### 学习要点
- 反射及其作用
- 反射的四个核心类
- 反射在项目中的作用

### 什么是反射
**反射（reflection.reflect）是代码`在运行时`动态访问类与对象的技术**
- 来自于`java.lang.reflection.reflect`  
  初学java时，要实例化一个对象，需要：
```
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

## 利用setter方法实现对象依赖注入  
```
public void setApple(Apple apple) {
    this.apple = apple;
}
```
applicationContext.xml文件
```xml
<bean id="sweetApple" class="spring.ioc.Apple">
    <property name="title" value="红富士"></property>
    <property name="origin" value="European"></property>
    <property name="color" value="red"></property>
</bean>
```

ref代表reference
```xml
<bean id="lily" class="spring.ioc.Child">
    <property name="name" value="莉莉" />
    <property name="apple" ref="sweetApple"/>
</bean>
```


## 构造方法实现对象依赖注入
```xml
<bean id="apple2" class="com.spring.ioc.entity.Apple">
  <constructor-arg name="name" value="andy"/>
  <constructor-arg name="apple" ref="sourApple"/>

</bean>
```
# ioc项目代码中解耦合
ref应用案例： 书店后端的业务层和数据层解耦合

# 注入集合对象
基于java的list和set的特性，数据允许重复时使用list，不允许重复时使用set
1. 实现功能类，实现注入需要用到setter方法

```java
public class Company {
  private List<String> rooms;

  public Company() {
  }

  public Company(List<String> rooms, Map<String, Computer> computers, Properties info) {
    this.rooms = rooms;
    this.computers = computers;
    this.info = info;
  }

  public List<String> getRooms() {
    return rooms;
  }

  public void setRooms(List<String> rooms) {
    this.rooms = rooms;
  }
}
```

2. 修改applicationContext.xml配置文件
```xml
<bean id="company" class="com.spring.ioc.entity.Company">
    <property name="rooms">
        <list>
            <value>2001-总裁办</value>
            <value>2002-总经理办公室</value>
            <value>2003-研发部会议室</value>
        </list>
    </property>
</bean>
```
3. 修改程序入口，实现注入
```java
public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Company company = context.getBean("company", Company.class);
        System.out.println(company);
    }
}
```

4. 输出
```shell
Company{rooms=[2001-总裁办, 2002-总经理办公室, 2003-研发部会议室], computers=null, info=null}
```

5. 其他
- set方法
```xml
<bean id="company" class="com.spring.ioc.entity.Company">
    <property name="rooms">
        <set>
            <value>2001-总裁办</value>
            <value>2002-总经理办公室</value>
            <value>2003-研发部会议室</value>
        </set>
    </property>
</bean>
```

```java
public class Company {
  private Set<String> rooms;

  public Company() {
  }

  public Company(List<String> rooms, Map<String, Computer> computers, Properties info) {
    this.rooms = rooms;
    this.computers = computers;
    this.info = info;
  }

  public Set<String> getRooms() {
    return rooms;
  }

  public void setRooms(Set<String> rooms) {
    this.rooms = rooms;
  }
}
```
- map

```xml
<property name="computers">
    <map>
        <!-- 但是这样要分开写c1这个bean，不方便管理，可以使用内置bean，有ref的地方都可以使用内置bean -->
        <entry key="dev-88121" value-ref="c1"/>
        
        <entry key="dev-88122">
            <bean class="com.spring.ioc.entity.Computer">
                <constructor-arg name="brand" value="华为"/>
                <constructor-arg name="type" value="台式机"/>
                <constructor-arg name="sn" value="SD10083992"/>
                <constructor-arg name="price" value="7000"/>
            </bean>
        </entry>
    </map>
</property>
```

# 高效函数
1. getBeanDefinitionNames()获取bean的id名字，内部bean无法获取
```java
String[] beanName = context.getBeanDefinitionNames();
for(String name: beanName){
    System.out.println(name);
}
```

# beanScope属性
## 详解
1. bean scope属性用来决定对象何时被创建和作用范围
2. bean scope配置将影响容器内对象的数量
3. 默认情况下bean会在IoC容器创建后自动实例化，全局唯一

## 属性详解
### 单例模式 singleton
IOC容器初始化时，就会将对象创建    
如果不写scope属性就代表每一个容器有且只有唯一实例，可以被全局共享，也就是在全局只要是同一个bean id都指向同一个  
存在线程安全问题，setNumber、getNumber  
### 多例模式 prototype
在获取bean(getBean函数调用)时创建对象  
prototype代表允许存在多个实例，每次使用对象，IOC容器会自动创建一个新的实例  
```xml
<bean id="bookDao" class="com.spring.ioc.bookshop.dao.BookDaoOracleImpl" scope="prototype"/>
```

### 应知
【笔试题】   
- 在IoC容器初始化的过程中实例化了多少个对象？    
原理：  
1. IOC容器初始化时，就会将`单例模式 singleton`对象创建  
2. 在获取bean(getBean函数调用)时创建`多例模式 prototype`对象  
3. 如果单例模式对象`ref`引用了多例模式对象，会先创建多例模式对象，再创建单例模式对象  

- 如何判断一个函数应该设置为单例还是多例？  
如果该函数对象属性恒定不变，那么就用单例，如果经常变化，就是多例
  

```xml
<bean id="userDao" class="com.spring.ioc.dao.UserDao" scope="prototype"/>
<bean id="userService" class="com.spring.ioc.service.UserService">
    <property name="userDao" ref="userDao"/>
</bean>
```

### 其他
|  属性   | 说明  |
|  ----  | ----  |
| request  | web环境下，每一次独立请求存在唯一实例 |
| session  | web环境下，每一个session存在唯一实例 |
| application | web环境下，ServletContext存在唯一实例 |
| websocket | 每一次WebSocket连接存在唯一实例(网络在线客服) |

# bean生命周期
![](https://gitee.com/leekinghou/image/raw/master/img/Untitled.drawio.png)
- 步骤：
1. 创建对象
2. 设置属性
3. 调用init方法
4. 通过调用对应的业务方法提供服务
5. 释放资源

```java
public class Order {
    private Float price;
    private Integer quantity;
    private Float total;
    // 1. 创建对象
    public Order() {
        System.out.println("创建Order对象," + this);
    }
    
    // 
    public void init(){
        total = price * quantity;
    }

    public void destroy(){
        System.out.println("释放与订单对象相关的资源");
    }
}
```
3. 调用init方法
```xml
<bean id="order1" class="com.spring.ioc.entity.Order" init-method="init" destroy-method="destroy">
    <!--  2. 设置属性-->
    <property name="price" value="19.8"/>
    <property name="quantity" value="1000"/>
</bean>
```

5. 释放资源
```java
((ClassPathXmlApplicationContext) context).registerShutdownHook();
```

output:
```xml
创建Order对象,com.spring.ioc.entity.Order@754ba872
设置price：19.8
设置quantity：19.8
======IoC容器已经完成初始化======
订单金额为：19800.0
释放与订单对象相关的资源
```

# 手动实现极简的IoC容器
可以将每一个ClassPathXmlApplicationContext理解为一个Ioc容器，用来存储对象的就是其中的Map

详情请看s06代码模块

# 基于注解配置IoC容器
- 不需要像配置XML形式的文件那么繁琐（设置beanid、在代码和配置文件中切换）
- IoC初始化过程中就会扫描所有的类
## 注解

在写代码的过程中完成配置

组件类型注解-声明当前类的功能与职责

自动装配注解-根据属性特征自动注入对象

元数据注解-更细化的辅助IoC容器管理对象的注解

| 注解 | 说明 |
|---|---|
|@Component|组件注解/通用注解，被@Component注解的类将被IoC容器管理并且实例化|
|@Controller|说明当前类是MVC应用中的控制类|
|@Service|说明当前类是Service业务服务类|
|@Repository|说明当前类用于业务持久层，通常描述Dao类|

## 开启组件扫描
```xml
<!-- 只有XML配置开启组件扫描，才能使用注解 -->
<context:component-scan base-package="com.spring">
    <!-- 使用正则表达式，排除/包含某些文件 -->
    <context:exclude-filter type="regex" expression="com.spring.exl.*"/>
</context:component-scan>
```

基于注解的IoC容器的扫描器跟基于XML的不一样，不需要用到`<bean></bean>`，只需要添加`<context:component-scan base-package="com.spring"/>`
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <!--    <context:annotation-config/>-->
    <!--  在IoC容器初始化时自动扫描四种组件类型注解并完成实例化
        @Repository
        @Service
        @Controller
        @Component
    -->
    <context:component-scan base-package="com.spring"/>
</beans>
```
组件类型注解(例如@Repository)默认beanId为类首字母小写
beanid = userDao，也可以自己更改，如使用@Repository("uDao")
```java
@Repository("uDao")
public class UserDao {
    // 用户持久类，用于增删改查
    // @Repository会让IoC容器自动创建UserDao的对象，并且管理起来
  
}
```
```java
public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        String[] ids = context.getBeanDefinitionNames();
        for(String id: ids){
            System.out.println(id + ":" + context.getBean(id));
        }
    }
}
```
output:
```shell
userController:com.spring.ioc.controlloer.UserController@73d4cc9e
uDao:com.spring.ioc.dao.UserDao@80169cf
userService:com.spring.ioc.service.UserService@5427c60c
stringUtils:com.spring.ioc.utils.StringUtils@15bfd87
org.springframework.context.annotation.internalConfigurationAnnotationProcessor:org.springframework.context.annotation.ConfigurationClassPostProcessor@543e710e
org.springframework.context.annotation.internalAutowiredAnnotationProcessor:org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor@57f23557
org.springframework.context.annotation.internalCommonAnnotationProcessor:org.springframework.context.annotation.CommonAnnotationBeanPostProcessor@3d0f8e03
org.springframework.context.event.internalEventListenerProcessor:org.springframework.context.event.EventListenerMethodProcessor@6366ebe0
org.springframework.context.event.internalEventListenerFactory:org.springframework.context.event.DefaultEventListenerFactory@44f75083
```
【问题】这几个实例时单例还是多例模式的？  
答：必然是单例模式，因为只有单例模式的实例才会在IoC容器初始化的时候将对象创建  

# 自动装配注解
<table>
   <tr>
      <td>分类</td>
      <td>注解</td>
      <td>说明</td>
   </tr>
   <tr>
      <td>按类型装配</td>
      <td>@Autowired</td>
      <td>按容器内对象类型动态注入属性</td>
   </tr>
   <tr>
      <td></td>
      <td>@Inject</td>
      <td>同@Autowired，但不支持required属性</td>
   </tr>
   <tr>
      <td>按名称装配</td>
      <td>@Named</td>
      <td>与@Inject搭配使用，按属性名自动装配属性</td>
   </tr>
   <tr>
      <td></td>
      <td>@Resource</td>
      <td>有限按名称，再按类型智能匹配</td>
   </tr>
</table>

- 什么是按类型装配/按名称装配?
```xml
<bean id="bookDao" class="com.spring.ioc.bookshop.dao.BookDaoImpl">

</bean>

<bean id="bookService" class="com.spring.ioc.bookshop.service.BookService">
    <property name="bookDao" ref="bookDao"/>
</bean>
```
如上，在一个bean中使用另一个bean的名称来注入属性被称作按名称注入

按类型注入则是不关心bean的名称，而是在为属性注入时，将属性类型相同的对象也完成注入

## Autowired自动装配注解
```java
public class UserService {
    @Autowired
    private UserDao udao;
}
```

```java
public class UserService {

    private UserDao udao;

    @Autowired
    public void setUdao(UserDao udao) {
        System.out.println("setUdao: " + udao);
        this.udao = udao;
    }
}
```
装配注解写在set方法上和写在定义属性的位置都可以完成对象注入，但是过程机制是完全不一样的。  
前者执行了set方法实现对象注入，后者不执行set方法，Spring IoC容器会自动通过反射技术将属性private修饰符改成public，直接进行赋值  

## 问题
- 当存在两个类型相同的类时，注入失败代码会报错  
![](https://gitee.com/leekinghou/image/raw/master/img/20220219231526.png)
- 出现原因  
因为IUserDao类型的对象由两个：userDao和userOracleDao，IoC容器在初始化的过程中要将属性注入，但是不知道注入哪一个的对象的属性，因此报错。
  
- 解决办法
  - 方法一：去除@Reposity，UserDao就不会被IoC容器管理
  - 方法二：其中一个加上@Primary注解（Primary主要的）
  ```java
    @Repository
    @Primary
    public class UserOracleDao implements IUserDao{
      public UserOracleDao() {
        System.out.println("正在创建UserOracleDao:" + this);
      }
    }
  ```

更好的办法，是按名称装配


## Resource按名称自动装配注解
具体测试见模块s07-2
```java
@Service
public class DepartmentService {
    /**
     * 1. @Resource设置name属性，则按name在IoC容器中将bean注入
     * 2. @Resource未设置name属性
     *      2.1 以属性名作为bean name在IoC容器中匹配bean，如有匹配则注入
     *      2.2 按属性名为匹配，则按类型惊喜匹配，同@Autowired，需加入@Primary解决类型冲突(尽量不要走到这一步)
     * tips: 在使用@Resource对象时推荐设置name或保证属性名与name名称一致（1和2.1）
     */

    // 1. 做法一, 设置name属性
    @Resource(name = "userOracleDao")
    private IUserDao udao;

    // 2.1 做法二规范属性命名
    @Resource
    private IUserDao userDao; //无name属性

    public void joinDepartment(){
        System.out.println(userDao);
    }
}
```

## 元数据注解
代码见s07-3
| 注解 | 说明 |
|---|---|
|@Primary|按类型装配时，出现多个相同类型对象，有@Primary的优先被注入|
|@PostConstruct|相当于XML里面的init-method|
|@PreDestroy|相当于XML里面的destroy-method|
|@Scope|设置对象的scope属性|
|@Value|为属性注入静态数据(配置文件常用)|

pom.xml添加:
```xml
    <context:property-placeholder location="classpath:config.properties"/>
```
config.properties:
```properties
metaData=spring.com
author=XXX
# 通过增加前缀，告知该参数的作用和范围
connection.driver=xxxx
connection.url=xxxxx
connection.username=xxxx
connection.password=xxxxxxxxxx
```

UserService.java:
```java
@Service
@Scope("prototype") // 设置单例/多例模式，与XML中的bean scope完全相同
public class UserService {
    @Value("${metaData}") //读取config.properties的metaData属性值
    private String metaData;

    @Autowired
    private IUserDao udao;

    @Value("${connection.username}")
    private String username;

    @PostConstruct // XML中bean init-method完全相同
    public void init(){
        System.out.println("初始化UserService对象，metaData：" + metaData);
    }
    public UserService() {
        System.out.println("正在创建UserService: " + this);
    }

    public UserService(UserDao udao) {
        this.udao = udao;
    }

    public IUserDao getUdao() {
        return udao;
    }
    
    public void setUdao(UserDao udao) {
        System.out.println("setUdao: " + udao);
        this.udao = udao;
    }
}
```
end
