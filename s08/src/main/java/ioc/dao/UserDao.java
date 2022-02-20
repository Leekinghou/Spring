package ioc.dao;

import org.springframework.stereotype.Repository;

/**
 * @author: lijinhao
 * @date: 2022/02/18 13:33
 */
// 组件类型注解(例如此处的@Repository)默认beanId为类首字母小写
// beanid = userDao，也可以自己更改，如使用@Repository("uDao")

@Repository
public class UserDao {

}
