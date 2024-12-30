package com.jsviat.cs.chap05.converter;

import com.jsviat.cs.chap05.dic.GenderEnum;
import jakarta.persistence.AttributeConverter;

public class GenderConverter implements AttributeConverter<GenderEnum, Integer> {


    @Override
    public Integer convertToDatabaseColumn(GenderEnum genderEnum) {
        return genderEnum.getId();
    }

    @Override
    public GenderEnum convertToEntityAttribute(Integer id) {
        return GenderEnum.getGenderById(id);
    }

}
