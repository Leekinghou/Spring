package ioc.service;

import ioc.dao.EmployeeDao;
import ioc.dao.UserDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author: lijinhao
 * @date: 2022/02/18 13:39
 */

public class UserService {
    private UserDao userDao;
    private EmployeeDao employeeDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
