package com.jsviat.cs.chapter01.pojo;

import com.jsviat.cs.chapter01.pojo.def.Animal;
import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal {

    @Override
    public void use() {
        System.out.println("猫【" + Cat.class.getSimpleName() + "】抓老鼠");
    }

}
