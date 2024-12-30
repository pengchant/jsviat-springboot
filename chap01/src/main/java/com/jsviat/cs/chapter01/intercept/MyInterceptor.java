package com.jsviat.cs.chapter01.intercept;

import com.jsviat.cs.chapter01.invoke.Invocation;

public class MyInterceptor implements Interceptor{

    @Override
    public boolean useAround() {
        return true;
    }

    @Override
    public void before() {
        System.out.println("before......");
    }

    @Override
    public void after() {
        System.out.println("after.....");
    }

    @Override
    public Object around(Invocation invocation) throws Throwable {
        System.out.println("around before......");
        Object obj = invocation.proceed();
        System.out.println("around after......");
        return obj;
    }

    @Override
    public void afterRunning() {
        System.out.println("afterRunning......");
    }

    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing......");
    }
}
