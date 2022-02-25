package com.spring.jdbc.dao;

import com.spring.jdbc.entity.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: lijinhao
 * @date: 2022/02/24 20:29
 */
public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Employee findById(Integer eno){
        String sql = "Select * from employee where eno = ?";
        Employee employee = jdbcTemplate.queryForObject(sql, new Object[]{eno}, new BeanPropertyRowMapper<Employee>(Employee.class));
        return employee;
    }

    public List<Map<String, Object>> findMapByDname(String dname){
        String sql = "Select eno as empNo, salary as empSa from employee where dname = ? ";
        // 将结果封装为Maps输出
//        return jdbcTemplate.queryForList(sql, new Object[]{dname});
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, new Object[]{dname});
        return maps;
    }

    public void insert(Employee employee){
        String sql = "insert into employee(eno, ename, salary, dname, hiredate) values(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{
                employee.getEno(),
                employee.getEname(),
                employee.getSalary(),
                employee.getDname(),
                employee.getHiredate()
        });
    }

    public int update(Employee employee){
        String sql = "UPDATE employee SET ename = ?, salary = ?, dname = ?, hiredate = ? WHERE eno = ?";
        // 必须严格按照？顺序
        int count = jdbcTemplate.update(sql, employee.getEname(),
                employee.getSalary(),
                employee.getDname(),
                employee.getHiredate(),
                employee.getEno());

        return count;
    }

    public int delete(Integer eno){
        String sql = "DELETE from employee WHERE eno = ?";
        return jdbcTemplate.update(sql, eno);
    }
}
