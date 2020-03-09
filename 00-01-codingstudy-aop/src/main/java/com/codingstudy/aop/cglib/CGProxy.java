package com.codingstudy.aop.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


import java.lang.reflect.Method;

/**
 * cglib动态代理
 * 1、实现 MethodInterceptor方法拦截器
 * 2、getProxy() Enhancer.create
 * 4、重写intercept methodProxy.invokeSuper(o,objects);
 */
public class CGProxy<T> implements MethodInterceptor {

    private  Object target;

    public CGProxy(Object target) {
        this.target = target;
    }

    //    private  static CGProxy cgProxy = null;
//
//    private CGProxy() {
//
//    }
//
//    //单例模式
//    public static CGProxy getInstance(){
//        if(cgProxy == null) {
//            cgProxy = new CGProxy();
//        }
//        return  cgProxy;
//    }


    public T getProxy(){

        return  (T) Enhancer.create(this.target.getClass(), this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("here .....before..............................");
        Object rs =  methodProxy.invokeSuper(o,objects);
        System.out.println("here ......after...............................");
        return rs;
    }
}
