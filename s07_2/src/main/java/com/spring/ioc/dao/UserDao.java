package com.spring.ioc.dao;

import org.springframework.stereotype.Repository;

/**
 * @author: lijinhao
 * @date: 2022/02/18 13:33
 */
// 组件类型注解(例如此处的@Repository)默认beanId为类首字母小写
// beanid = userDao，也可以自己更改，如使用@Repository("uDao")

@Repository
public class UserDao implements IUserDao{
    // 用户持久类，用于增删改查
    // @Repository会让IoC容器自动创建UserDao的对象，并且管理起来
}
