package com.jsviat.cs.chapter01.service;

import com.jsviat.cs.chapter01.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void printUser(User user) {
        System.out.println("编号:" + user.getId());
        System.out.println("用户名:" + user.getUserName());
        System.out.println("备注:" + user.getNote());
    }

}
