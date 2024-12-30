package com.jsviat.cs.chap05;

import com.jsviat.cs.chap05.repository.JpaUserRepository;
import jakarta.annotation.PostConstruct;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.jsviat.cs.chap05")
@EnableJpaRepositories(basePackages = "com.jsviat.cs.chap05.repository")
@EntityScan(basePackages = "com.jsviat.cs.chap05.pojo")
public class Chap05Application {

    // 注入jpa对象
    @Autowired
    private JpaUserRepository jpaUserRepository = null;

    public void setJpaUserRepository(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @PostConstruct
    public void testJpa() {
        var user = this.jpaUserRepository.findById(1L).get();
        System.out.println(user.getUserName());
    }

    @PostConstruct
    public void getJpaUserById() {
        var user = jpaUserRepository.getJpaUserById(1L);
        System.out.println("===>getJpaUserByID:" + user.getUserName());
    }

    @PostConstruct
    public void findByUserNameLike() {
        var userList = jpaUserRepository.findByUserNameLike("%user%");
        System.out.println("===>findByUserNameLike:" + userList);
    }

    @PostConstruct
    public void findByUserNameLikeOrNoteLike() {
        var userNameLike = "%user%";
        var noteLike = "%note%";
        // 使用jpa接口查询对象
        var userList = jpaUserRepository.findByUserNameLikeOrNoteLike(userNameLike, noteLike);
        System.out.println("===>findByUserNameLikeOrNoteLike:" + userList);
    }


    // 使用mapperScannerConfigurer扫描，装配mybatis接口实例
    @Bean
    public MapperScannerConfigurer mapperScannerConfigure() {
        var mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        // 定义扫描的包
        mapperScannerConfigurer.setBasePackage("com.jsviat.cs.chap05.*");
        // 通过继承某个接口限定扫描
        mapperScannerConfigurer.setAnnotationClass(Mapper.class);
        return mapperScannerConfigurer;
    }

    public static void main(String[] args) {
        SpringApplication.run(Chap05Application.class, args);
    }

}
