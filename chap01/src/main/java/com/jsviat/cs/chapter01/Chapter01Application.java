package com.jsviat.cs.chapter01;

import com.jsviat.cs.chapter01.aspect.UserValidator;
import com.jsviat.cs.chapter01.config.AppConfig;
import com.jsviat.cs.chapter01.intercept.MyInterceptor;
import com.jsviat.cs.chapter01.intercept.ProxyBean;
import com.jsviat.cs.chapter01.pojo.BussinessPersion;
import com.jsviat.cs.chapter01.pojo.DatabaseProperties;
import com.jsviat.cs.chapter01.pojo.ScopeBean;
import com.jsviat.cs.chapter01.pojo.User;
import com.jsviat.cs.chapter01.service.AUserService;
import com.jsviat.cs.chapter01.service.HelloService;
import com.jsviat.cs.chapter01.service.HelloServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/// / 声明为控制器
@Controller
@SpringBootApplication // 这是一个spring boot入口文件
public class Chapter01Application {

    @GetMapping("/test")
    public String test(HttpServletRequest request) {
        // 设置请求属性
        request.setAttribute("name", "江苏建筑职业技术学院");
        return "test";
    }

//    public static void main(String[] args) {
//        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//        try {
//            var person = ctx.getBean(BussinessPersion.class);
//            person.service();
//            var database = ctx.getBean(DatabaseProperties.class);
//            System.out.println(database.getDriverName());
//            System.out.println(database.getUrl());
//            System.out.println(database.getUsername());
//            System.out.println(database.getPassword());
//        } finally {
//            ctx.close();
//        }
//    }


//    public static void main(String[] args) {
//        SpringApplication.run(Chapter01Application.class, args);
//    }

//    public static void main(String[] args) {
//        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//        try {
//            var bean1 = ctx.getBean(ScopeBean.class);
//            var bean2 = ctx.getBean(ScopeBean.class);
//            System.out.println(bean1 == bean2);
//        } finally {
//            ctx.close();
//        }
//    }

//    public static void main(String[] args) {
//        var helloService = new HelloServiceImpl();
//        var proxy = (HelloService) ProxyBean.getProxy(helloService, new MyInterceptor());
//        proxy.sayHello("张三");
//        System.out.println("#################测试异常################");
//        proxy.sayHello(null);
//    }

//    public static void main(String[] args) {
//        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        try {
//            var userService = ctx.getBean(AUserService.class);
//            User user = new User();
//            user.setId(1L);
//            user.setUserName("用户名1");
//            user.setNote("备注1");
//            var userValidator = (UserValidator) userService;
//            if (userValidator.validate(user)) {
//                userService.printUser(user);
//            }
//        } finally {
//            ctx.close();
//        }
//    }

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        try {
            var userServices = ctx.getBean(AUserService.class);
            userServices.multiAspects();
        } finally {
            ctx.close();
        }
    }

}
