package com.jsviat.cs.chap05.db;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.sql.DataSource;

public class DataSourceShow implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        var dataSource = applicationContext.getBean(DataSource.class);
        System.out.println("-----------------------------");
        System.out.println(dataSource.getClass().getName());
        System.out.println("-----------------------------");
    }
}
