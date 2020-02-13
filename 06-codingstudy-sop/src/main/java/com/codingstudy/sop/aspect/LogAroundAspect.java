package com.codingstudy.sop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Aspect
@Component
public class LogAroundAspect {

//    @Pointcut("@annotation(LogAnnotation)")
//    public void pointCut() {
//        System.out.println("this is pointCut method!");
//    }

    @Around("@annotation(logAnnotation)")
    public Object aroundMethod(ProceedingJoinPoint joinPoint,
                               LogAnnotation logAnnotation) throws Throwable {
        Object rs = null;
        Object[] args = joinPoint.getArgs();
        System.out.println("1-------类名称："+joinPoint.getTarget().getClass().getName());
        //方法
        System.out.println("2-------方法名称："+logAnnotation.value());
        System.out.println("3-------参数："+Arrays.asList(args));

        try {
            rs = joinPoint.proceed(args);
            System.out.println("4------正确的执行完毕。。。。");
        }catch (Exception e)
        {
            System.out.println("5------执行有错，错误信息："+e.getMessage());
        }finally {
            System.out.println("6------程序结束。");
        }

        return rs;
    }
}
