package com.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: lijinhao
 * @date: 2022/02/22 10:37
 */
//切面类
public class MethodAspect {
    //切面方法，用于拓展额外的功能
    //JoinPoint连接点，通过连接点可以获取目标类/方法的信息
    public void printExecutionTime(JoinPoint joinPoint){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String now = sdf.format(new Date());
        // getTarget()获取目标类
        String className = joinPoint.getTarget().getClass().getName(); //获取目标类的名称
        // getSignature()获取目标方法
        String methodName = joinPoint.getSignature().getName(); //获取目标方法名称
        System.out.println("------>" + now + ":" + className + '.' + methodName);
    }
}
