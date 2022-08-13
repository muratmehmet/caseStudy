package com.casestudy.ordermanagement.dto;

import com.casestudy.ordermanagement.dto.base.BaseDto;
import lombok.Data;

@Data
public class CustomerDto extends BaseDto {

    private String loginName;
    private String name;

}
