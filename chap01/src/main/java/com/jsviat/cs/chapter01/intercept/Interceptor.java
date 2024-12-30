package com.jsviat.cs.chapter01.intercept;


import com.jsviat.cs.chapter01.invoke.Invocation;

public interface Interceptor {

    void before();

    void after();

    Object around(Invocation invocation) throws Throwable;

    void afterRunning();

    void afterThrowing();

    default boolean useAround() {
        return false;
    }
}
