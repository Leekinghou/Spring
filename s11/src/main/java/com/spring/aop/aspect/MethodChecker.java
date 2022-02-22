package com.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Date;

/**
 * @author: lijinhao
 * @date: 2022/02/22 19:43
 */

public class MethodChecker {
    //ProceedingJoinPoint是JoinPoint的升级版,在原有功能外,还可以控制目标方法是否执行
    public Object check(ProceedingJoinPoint pjp) throws Throwable {
        try{
            long startTime = new Date().getTime();
            //执行目标方法,返回值是目标方法的返回值
            Object ret = pjp.proceed();
            long endTime = new Date().getTime();
            long duration = endTime - startTime;
            if(duration >= 1000){
                System.out.println(duration);
            }
            return ret;
        }catch (Throwable throwable){
            System.out.println("Exception message:" + throwable.getMessage());
            throw throwable;
        }
    }
}
