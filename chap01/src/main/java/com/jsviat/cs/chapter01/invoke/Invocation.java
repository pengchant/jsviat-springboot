package com.jsviat.cs.chapter01.invoke;

import com.jsviat.cs.chapter01.intercept.Interceptor;

import java.lang.reflect.Method;

public class Invocation {

    private Object[] params;

    private Method method;

    private Object target;

    private Interceptor interceptor;

    public Invocation(Object[] params, Method method, Object target, Interceptor interceptor) {
        this.params = params;
        this.method = method;
        this.target = target;
        this.interceptor = interceptor;
    }

    public Object proceed() {
        Object result = null;
        boolean exceptionFlag = false; // 异常标志位
        this.interceptor.before(); // 拦截器的before()方法

        try {
            result = method.invoke(target, params);
        } catch (Exception e) {
            exceptionFlag = true;
        }
        if (exceptionFlag) {
            this.interceptor.afterThrowing(); // 发生异常运行拦截器的afterThrowing方法
        } else {
            this.interceptor.afterRunning(); // 无异常则运行拦截器的afterReturning方法
        }
        this.interceptor.after(); // 无论是否发生异常都需要运行after方法
        return result;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Interceptor getInterceptor() {
        return interceptor;
    }

    public void setInterceptor(Interceptor interceptor) {
        this.interceptor = interceptor;
    }
}
