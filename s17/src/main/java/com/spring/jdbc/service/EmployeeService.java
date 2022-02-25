package com.spring.jdbc.service;

import com.spring.jdbc.dao.EmployeeDao;
import com.spring.jdbc.entity.Employee;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Date;

/**
 * @author: lijinhao
 * @date: 2022/02/25 15:02
 */

public class EmployeeService {
    private EmployeeDao employeeDao;
    private DataSourceTransactionManager transactionManager;

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public DataSourceTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(DataSourceTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void batchImport(){
        // 定义了事务默认的标准配置
        TransactionDefinition definition = new DefaultTransactionDefinition();
        // 开始一个事务，当前事务状态
        TransactionStatus status = transactionManager.getTransaction(definition);
        try {
            for (int i = 1; i < 10; i++) {
//                if (i == 3){
//                    throw new RuntimeException("意料之外的异常");
//                }
                Employee employee = new Employee();
                employee.setEno(8000 + i);
                employee.setEname("员工" + i);
                employee.setDname("市场部");
                employee.setSalary(5000f);
                employee.setHiredate(new Date());
                employeeDao.insert(employee);
            }
            // 提交事务
            transactionManager.commit(status);
        }catch (Exception e){
            // 回滚事务
            transactionManager.rollback(status);
            // 内部消化，异常不会被抛出
            e.printStackTrace();
            // 在调用方抛出异常
            throw e;
        }
    }
}
