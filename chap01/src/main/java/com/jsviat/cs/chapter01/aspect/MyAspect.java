package com.jsviat.cs.chapter01.aspect;

import com.jsviat.cs.chapter01.pojo.User;
import com.jsviat.cs.chapter01.service.AUserService;
import com.jsviat.cs.chapter01.service.AUserServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect // 声明为切面
@Component // 将切面扫描到Ioc容器中，使切面类生效
public class MyAspect {

    @DeclareParents(
            value = "com.jsviat.cs.chapter01.service.AUserServiceImpl",
            defaultImpl = UserValidatorImpl.class
    )
    public UserValidator userValidator;

    private static final String aopExp = "execution(* com.jsviat.cs.chapter01.service.AUserServiceImpl.printUser(..))";

    // 使用@Pointcut 定义切点，后续的通知就可以使用这个方法名来描述需要拦截的方法
    @Pointcut(aopExp)
    public void pointcut() {}

    @Before("pointcut() && args(user)") // 使用切点
    public void before(JoinPoint jp, User user) {
        System.out.println(" 切面 before ......");
    }

    @After("pointcut()") // 使用切点
    public void after() {
        System.out.println(" 切面 after ......");
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("====>环绕通知 before.");
        joinPoint.proceed();
        System.out.println("====>环绕通知 after");
    }

    @AfterReturning("pointcut()")
    public void afterReturning() {
        System.out.println(" 切面 afterReturning ......");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println(" 切面 afterThrowing ......");
    }
}
