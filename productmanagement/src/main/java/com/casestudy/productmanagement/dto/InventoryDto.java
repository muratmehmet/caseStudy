package com.casestudy.productmanagement.dto;


import com.casestudy.productmanagement.dto.base.BaseDto;
import lombok.Data;



@Data
public class InventoryDto extends BaseDto {
    private String name;
    private String city;
    private String state;
    private String status;
}
