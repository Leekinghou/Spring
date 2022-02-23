package aop.service;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: lijinhao
 * @date: 2022/02/23 16:16
 * InvocationHandler是JDK提供的反射类，用于在JDK动态代理中对目标方法进行增强
 * InvocationHandler实现类与切面类的环绕通知类相似
 */
public class ProxyInvocationHandler implements InvocationHandler {
    // 因为是对所有的类生效的，所以不指定Object类型
    private Object target; // 目标对象

    public ProxyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 在invoke()方法对目标方法进行增强
     * @param proxy 代理类对象
     * @param method 目标方法对象
     * @param args 目标方法实参
     * @return 目标方法运行后返回值
     * @throws Throwable 目标方法抛出的异常
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println("=======" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()) +
                "=======");
        // 调用目标方法， ProceedingJoinPoint.proceed();
        Object ret = method.invoke(target, args);
        return ret;
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ProxyInvocationHandler invocationHandler = new ProxyInvocationHandler(userService);

        // 动态创建代理类,必须实现接口
        UserService userServiceProxy = (UserService)Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(), invocationHandler);
        userServiceProxy.createrUser();

        EmployeeService employeeService = new EmployeeServiceImpl();
        // 传入类加载器
        // 传入EmployeeService实现的接口
        // 传入EmployeeService的具体实现类
        EmployeeService employeeServiceProxy = (EmployeeService) Proxy.newProxyInstance(employeeService.getClass().getClassLoader(),
                employeeService.getClass().getInterfaces(),
                new ProxyInvocationHandler(employeeService));

        employeeServiceProxy.createEmployee();
    }
}
