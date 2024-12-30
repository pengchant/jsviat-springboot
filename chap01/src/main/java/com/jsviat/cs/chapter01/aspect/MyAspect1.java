package com.jsviat.cs.chapter01.aspect;

import com.jsviat.cs.chapter01.pojo.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect // 声明为切面
@Component // 将切面扫描到Ioc容器中，使切面类生效
@Order(3)
public class MyAspect1 {

    private static final String exp = "execution(* com.jsviat.cs.chapter01.service.AUserServiceImpl.multiAspects(..))";

    // 使用@Pointcut 定义切点，后续的通知就可以使用这个方法名来描述需要拦截的方法
    @Pointcut(exp)
    public void multiAspects() {}

    @Before("multiAspects()") // 使用切点
    public void before() {
        System.out.println(" 切面1 before ......");
    }

    @After("multiAspects()") // 使用切点
    public void after() {
        System.out.println(" 切面1 after ......");
    }

    @AfterReturning("multiAspects()")
    public void afterReturning() {
        System.out.println(" 切面1 afterReturning ......");
    }

}