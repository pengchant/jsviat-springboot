package com.jsviat.cs.chap05.service;

import com.jsviat.cs.chap05.dao.MyBatisUserDao;
import com.jsviat.cs.chap05.pojo.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MybatisUserServiceImpl implements MybatisUserService {

    @Autowired
    private MyBatisUserDao myBatisUserDao = null;

    @Override
    public MyUser getUser(Long id) {
        return myBatisUserDao.getUser(id);
    }
}
