package com.jsviat.cs.chapter01.service;


import com.jsviat.cs.chapter01.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class AUserServiceImpl implements AUserService {

    @Override
    public void printUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        System.out.println("id=" + user.getId());
        System.out.println("\tusername=" + user.getUserName());
        System.out.println("\tnote=" + user.getNote());
    }

    @Override
    public void multiAspects() {
        System.out.println("测试多个切面顺序");
    }

}
