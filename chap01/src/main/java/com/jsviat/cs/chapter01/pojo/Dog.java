package com.jsviat.cs.chapter01.pojo;

import com.jsviat.cs.chapter01.pojo.def.Animal;
import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {

    @Override
    public void use() {
        System.out.println("狗【" + Dog.class.getSimpleName() + "】用来看门");
    }
}
