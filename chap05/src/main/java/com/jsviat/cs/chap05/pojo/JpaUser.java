package com.jsviat.cs.chap05.pojo;

import com.jsviat.cs.chap05.dic.GenderEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "user")
@Table(name = "t_user")
@Getter
@Setter
public class JpaUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键策略递增
    private Long id = null;

    @Column(name = "user_name")
    private String userName = null;

    private String note = null;

    private GenderEnum gender = null;

}
