package com.jsviat.cs.chapter01.aspect;

import com.jsviat.cs.chapter01.pojo.User;

public class UserValidatorImpl implements UserValidator {

    @Override
    public boolean validate(User user) {
        System.out.println("引入新接口:" + UserValidator.class.getSimpleName());
        return user != null;
    }
}
