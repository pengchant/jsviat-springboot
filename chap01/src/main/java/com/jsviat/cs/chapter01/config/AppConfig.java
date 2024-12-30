package com.jsviat.cs.chapter01.config;

import com.jsviat.cs.chapter01.conditional.DatabaseConditional;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.jsviat.cs.chapter01.*") // 配置扫描策略
@PropertySource(value = {"classpath:jdbc.properties"}, ignoreResourceNotFound = true)
@EnableAspectJAutoProxy // 表示启用注解@AspectJ方式的AOP
public class AppConfig {

    @Bean(name = "dataSource")
    @Conditional(DatabaseConditional.class)
    public DataSource getDataSource(
            @Value("${database.url}") String url,
            @Value("${database.username}") String username,
            @Value("${database.password}") String password) {
        System.out.println("初始化数据源");
        var dataSource = new MysqlDataSource();
        dataSource.setUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
