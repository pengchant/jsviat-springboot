package com.jsviat.cs.chap05.test;

import com.jsviat.cs.chap05.service.MybatisUserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBatisTest {

    @Autowired
    private MybatisUserService mybatisUserService = null;

    public void setMybatisUserService(MybatisUserService mybatisUserService) {
        this.mybatisUserService = mybatisUserService;
    }

    @PostConstruct
    public void testMyBatis() {
        var user = this.mybatisUserService.getUser(1L);
        System.out.println("测试mybatis==>" + user.getUserName());
    }
}
