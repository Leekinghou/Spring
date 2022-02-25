package com.spring.jdbc.entity;


import java.util.Date;

/**
 * @author: lijinhao
 * @date: 2022/02/24 20:24
 */
public class Employee {
    /**
     * 要保证顺序与数据库中的顺序已知，才可以使用BeanPropertyRowMapper函数
     */
    private Integer eno;
    private String ename;
    private Float salary;
    private String dname;
    private Date hiredate;

    public Integer getEno() {
        return eno;
    }

    public void setEno(Integer eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eno='" + eno + '\'' +
                ", ename='" + ename + '\'' +
                ", salary='" + salary + '\'' +
                ", dname='" + dname + '\'' +
                ", hiredate='" + hiredate + '\'' +
                '}';
    }
}
