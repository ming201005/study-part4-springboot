package com.codingstudy.aop.aspects;

import com.codingstudy.aop.entity.User;
import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

import org.springframework.stereotype.Component;


@Component  //让IOC容器管理
@Aspect     //定义   切面类
public class LogAspect {

    @Pointcut("execution(* com.codingstudy.aop.service.*.*(..))")
    //@Pointcut("@annotation(LogAnnotation)")
    public void logPointCut() {

    }

    @Before("logPointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("1- here   before...............");
        System.out.println(joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getTarget().getClass());
        System.out.println(joinPoint.getSignature().getName());


        //方法名
        MethodSignature methodSignature = (MethodSignature)  joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        //参数名称
        String[] params =  methodSignature.getParameterNames();
        //参数值
        Object[] args = joinPoint.getArgs();

        //获得注解信息
        LogAnnotation logAnnotation = methodSignature.getMethod().getDeclaredAnnotation(LogAnnotation.class);

        System.out.println("logAnnotation value = " + logAnnotation.value());
        System.out.println("logAnnotation description = " + logAnnotation.description());

        System.out.println("参数..............................start");
        for (int i = 0 ; i <params.length; i++) {
            System.out.println(params[i]+ " = "+ args[i]);
        }
        System.out.println("参数..............................end");

    }

    @After("logPointCut()")
    public void  after (JoinPoint joinPoint) {

        System.out.println("2----here after.............");
    }

    @AfterReturning(pointcut = "logPointCut()",returning = "returning")
    public Object   afterReturn(JoinPoint joinPoint, Object returning) {
        System.out.println("3------- here after returning...........");
        System.out.println("返回的结果是====》"+returning);
        User user = (User) returning;
        user.setName("张三丰在此");
        return user;
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("around ...................... start");

        String classPath = joinPoint.getTarget().getClass().getName();
        System.out.println("classPath = " + classPath);
        String methodName =  joinPoint.getSignature().getName();
        System.out.println("methodName = " + methodName);
        //获取参数名称、参数值
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //取得参数
        String[] params = methodSignature.getParameterNames();
        //参数值
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < params.length; i++) {
            System.out.println(params[i]+" = "+args[i]);
        }
        //取注解
        LogAnnotation logAnnotation = methodSignature.getMethod().getDeclaredAnnotation(LogAnnotation.class);
        System.out.println("value= "+logAnnotation.value()+",des ="+logAnnotation.description());

        Object result = result =joinPoint.proceed(args);

        System.out.println("around ...................... end...");
        return  result;
    }

    @AfterThrowing(pointcut = "logPointCut()",throwing = "err")
    public void throwing(Throwable err) {
        System.out.println("---------------err:-----------------");
        System.out.println(err.getMessage());
    }


}
