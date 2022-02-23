package aop.service;

/**
 * @author: lijinhao
 * @date: 2022/02/23 17:26
 */
public class EmployeeServiceImpl implements EmployeeService{
    @Override
    public void createEmployee() {
        System.out.println("执行创建员工业务逻辑");
    }
}
