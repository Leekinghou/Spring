import com.spring.ioc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author: lijinhao
 * @date: 2022/02/21 12:17
 */


// 将JUnit4的执行权交给Spring Test模块，在测试用例执行之前自动初始化IoC容器
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SpringTestor {
    /**
     * 使用方法：在使用之前假设IoC容器已经初始化好，只不过是在写一个测试用的Spring Application
     */

    @Resource
    private UserService userService;

    @Test
    public void testUserService(){
        userService.createUser();
    }
}
