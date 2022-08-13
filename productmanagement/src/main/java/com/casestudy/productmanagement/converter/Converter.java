package com.casestudy.productmanagement.converter;


import com.casestudy.productmanagement.domain.base.BaseEntity;
import com.casestudy.productmanagement.dto.base.BaseDto;

public interface Converter<DTO extends BaseDto, Entity extends BaseEntity> {
    Entity toEntity(DTO var1);

    DTO toDto(Entity var1);
}
