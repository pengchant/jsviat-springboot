package com.jsviat.cs.chapter01.intercept;

import com.jsviat.cs.chapter01.invoke.Invocation;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyBean implements MethodInterceptor {

    private Interceptor interceptor = null;

    private Object target = null;

    public static Object getProxy(Object target, Interceptor interceptor) {
        var proxyBean = new ProxyBean();
        proxyBean.target = target;
        proxyBean.interceptor = interceptor;

        var enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setInterfaces(target.getClass().getInterfaces());
        enhancer.setCallback(proxyBean);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Invocation invocation = new Invocation(args, method, this.target, this.interceptor);
        Object result = null;
        if (this.interceptor.useAround()) {
            result = this.interceptor.around(invocation);
        } else {
            result = invocation.proceed();
        }
        return result;
    }
}
