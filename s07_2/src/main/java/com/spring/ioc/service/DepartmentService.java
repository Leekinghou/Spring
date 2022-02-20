package com.spring.ioc.service;

import com.spring.ioc.dao.IUserDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author: lijinhao
 * @date: 2022/02/19 23:45
 */

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
