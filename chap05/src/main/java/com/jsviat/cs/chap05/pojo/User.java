package com.jsviat.cs.chap05.pojo;

import com.jsviat.cs.chap05.dic.GenderEnum;
import lombok.Data;

@Data
public class User {
    private Long id = null;
    private String username = null;
    private GenderEnum gender = null; // 枚举
    private String note = null;
}
