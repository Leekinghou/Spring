package com.spring.jdbc.service;

import com.spring.jdbc.dao.EmployeeDao;
import com.spring.jdbc.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class BatchService {
    @Resource
    private EmployeeDao employeeDao;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void importJob1(){
        for (int i = 1; i <= 10; i++) {
            Employee employee = new Employee();
            employee.setEno(8000 + i);
            employee.setEname("研发部员工" + i);
            employee.setSalary(4000f);
            employee.setDname("研发部");
            employee.setHiredate(new Date());
            employeeDao.insert(employee);
        }
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void importJob2(){
        for (int i = 1; i <= 10; i++) {
            Employee employee = new Employee();
            employee.setEno(9000 + i);
            employee.setEname("市场部员工" + i);
            employee.setSalary(4500f);
            employee.setDname("市场部");
            employee.setHiredate(new Date());
            employeeDao.insert(employee);
        }
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
