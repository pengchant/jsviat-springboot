package com.jsviat.cs.chap05.dao;

import com.jsviat.cs.chap05.pojo.MyUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyBatisUserDao {

    MyUser getUser(long id);

}
