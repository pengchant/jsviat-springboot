package com.jsviat.cs.chapter01.aspect;

import com.jsviat.cs.chapter01.pojo.User;

public interface UserValidator {
    // 检测用户对象是否为空
    boolean validate(User user);
}
