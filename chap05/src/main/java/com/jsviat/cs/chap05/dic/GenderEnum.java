package com.jsviat.cs.chap05.dic;

import lombok.Getter;

public enum GenderEnum {

    MALE(1, "男"),
    FEMALE(2, "女");

    private int id;
    private String gender;

    GenderEnum(int id, String gender) {
        this.id = id;
        this.gender = gender;
    }

    public static GenderEnum getGenderById(int id) {
        for (GenderEnum genderEnum : GenderEnum.values()) {
            if (genderEnum.id == id) {
                return genderEnum;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
