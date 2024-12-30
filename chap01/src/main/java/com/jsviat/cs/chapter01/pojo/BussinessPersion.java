package com.jsviat.cs.chapter01.pojo;

import com.jsviat.cs.chapter01.pojo.def.Animal;
import com.jsviat.cs.chapter01.pojo.def.Person;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


//@Component
public class BussinessPersion implements Person, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private Animal animal;

    @Override
    public void service() {
        this.animal.use();
    }

    @Override
    @Autowired
    @Qualifier("dog")
    public void setAnimal(Animal animal) {
        System.out.println("依赖注入");
        this.animal = animal;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("【" + this.getClass().getSimpleName()
                + "】调用BeanNameAware.setBeanName()");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【" + this.getClass().getSimpleName()
                + "】调用BeanFactoryAware.setBeanFactory()");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【" + this.getClass().getSimpleName()
                + "】调用ApplicationContextAware.setApplicationContext()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName()
                + "】调用InitializingBean.afterPropertiesSet()");
    }

    @PostConstruct
    public void init() {
        System.out.println("【" + this.getClass().getSimpleName()
                + "】注解@PostConstruct自定义初始化方法");
    }

    @PreDestroy
    public void destroy1() {
        System.out.println("【" + this.getClass().getSimpleName()
                + "】注解@PreDestroy自定义销毁方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName()
                + "】DisposableBean()方法");
    }

}
