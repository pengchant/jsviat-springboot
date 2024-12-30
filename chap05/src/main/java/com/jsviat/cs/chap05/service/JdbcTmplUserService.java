package com.jsviat.cs.chap05.service;

import com.jsviat.cs.chap05.pojo.User;

import java.util.List;

public interface JdbcTmplUserService {

    User getUser(Long id);

    List<User> findUsers(String username, String note);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(User user);


    User getUser2(Long id);

    User getUser3(Long id);
}
