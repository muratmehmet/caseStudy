package com.casestudy.ordermanagement.converter;


import com.casestudy.ordermanagement.domain.base.BaseEntity;
import com.casestudy.ordermanagement.dto.base.BaseDto;

public interface Converter<DTO extends BaseDto, Entity extends BaseEntity> {
    Entity toEntity(DTO var1);

    DTO toDto(Entity var1);
}
