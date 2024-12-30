package com.jsviat.cs.chapter01.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

//@Component
public class BeanPostProcessorExample implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor调用" + "postProcessBeforeInitialization(), 参数【"
                + bean.getClass().getSimpleName() +"】【" + beanName + "】");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor调用postProcessAfterInitialization(), 参数【"
                + bean.getClass().getSimpleName() + "】【" + beanName + "】");
        return bean;
    }


}
