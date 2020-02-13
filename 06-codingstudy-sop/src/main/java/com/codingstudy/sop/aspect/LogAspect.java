package com.codingstudy.sop.aspect;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import org.springframework.stereotype.Component;

/**
 * 让相关的方法的头尾有打印日志信息
 */
//@Aspect
@Component
public class LogAspect {

    Log log = LogFactory.getLog(LogAspect.class);

    /**
     * 任意公共方法的执行：execution(public * *(..))
     * 任何一个以“set”开始的方法的执行：execution(* set*(..))
     * AccountService 接口的任意方法的执行：execution(* com.abc.service.AccountService.*(..))
     * 定义在service包里的任意方法的执行： execution(* com.abc.service.*.*(..))
     * 定义在service包和所有子包里的任意类的任意方法的执行：execution(* com.abc.service..*.*(..))
     */
    @Pointcut("execution(* com.codingstudy.sop.service..*(..))")
    public void point() {
    }

    @Before(value = "point()")
    public void beforeAdvice(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        Object[] args = joinPoint.getArgs();
        //输出
        log.info("1-------方法前执行...");
        log.info("1.1-------当前类名：" + className);
        log.info("1.2--------方法参数：" );
        for (int i = 0; i < args.length; i++) {
            log.info("      第["+(i+1)+"]个参数=" + args[i]);
        }
    }

    @After("point()")
    public void afterAdvice(JoinPoint joinPoint) throws Throwable {

        log.info("2---------方法执行完毕...");

    }

    @AfterReturning(pointcut = "point()",returning = "object")
    public void afterReturningAdvice(Object object) {
        log.info("3---------返回值："+object);
    }

    @AfterThrowing(pointcut = "point()", throwing = "err")
    public void afterThrowingAdvice(Exception err) {
        log.info("4----------方法出现异常...");
        log.info(" 异常信息："+err.getMessage());
    }
}
