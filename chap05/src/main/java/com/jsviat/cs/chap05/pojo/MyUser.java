package com.jsviat.cs.chap05.pojo;

import com.jsviat.cs.chap05.dic.GenderEnum;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Alias(value = "myuser")
public class MyUser {
    private Long id = null;
    private String userName = null;
    private GenderEnum gender = null;
    private String note = null;
}
