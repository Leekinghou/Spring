import com.spring.jdbc.dao.EmployeeDao;
import com.spring.jdbc.entity.Employee;
import com.spring.jdbc.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author: lijinhao
 * @date: 2022/02/24 23:04
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class JdbcTemplateTestor {
    @Resource
    private EmployeeDao employeeDao;

    @Resource
    private EmployeeService employeeService;

    @Test
    public void testFindById(){
        Employee employee = employeeDao.findById(3308);
        System.out.println(employee);
    }

    @Test
    public void testFindMapByDname(){
        System.out.println(employeeDao.findMapByDname("研发部"));
    }

    @Test
    public void testInsert(){
        Employee employee = new Employee();
        employee.setEno(8888);
        employee.setEname("jack");
        employee.setDname("研发部");
        employee.setSalary(12000.0F);
        employee.setHiredate(new Date());
        employeeDao.insert(employee);
    }

    @Test
    public void testUpdate(){
        Employee employee = employeeDao.findById(8888);
        employee.setSalary(employee.getSalary() + 1000);
        int count = employeeDao.update(employee);
        System.out.println("本次更新" + count + "条数据");
    }

    @Test
    public void testDelete(){
        int count = employeeDao.delete(8888);
        System.out.println("本次删除" + count + "条数据");
    }

    @Test
    public void testBatchImport(){
        employeeService.batchImport();
        System.out.println("批量导入成功");
    }
}
