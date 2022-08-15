package com.casestudy.productmanagement.dto;

import com.casestudy.productmanagement.dto.base.BaseDto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto extends BaseDto {

    private Long productId;
    private Long quantity;
    private String name;
    private String description;
    private String type;
    private BigDecimal price;
    private InventoryDto inventory;
}
