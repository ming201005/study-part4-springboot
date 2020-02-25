package com.codingstudy.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;

/**
 * Java动态代理
 * 1、实现InvocationHandler
 * 2、getProxy Proxy.newProxyInstance
 * 3. 重写invoke method.invoke(target,args);
 */
public class DyProxy implements InvocationHandler {
    private  Object target;

    public DyProxy(Object obj) {
        this.target = obj;
    }

    public Object getProxy(){
        return   Proxy.newProxyInstance(
                    this.target.getClass().getClassLoader(),
                    this.target.getClass().getInterfaces(),
                    this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        System.out.println("类名称 = " + target.getClass().getName());
        System.out.println("方法名称 = " +method.getName());
        System.out.println("参数================》》 ");
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            System.out.println(parameters[i]+" = "+args[i]);
        }

        Object result = method.invoke(target,args);
        after();
        return result;
    }

    void  before()
    {
        System.out.println("before ...................");
    }

    void after() {
        System.out.println("after .....................");
    }
}
