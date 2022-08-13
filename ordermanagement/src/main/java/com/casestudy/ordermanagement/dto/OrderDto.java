package com.casestudy.ordermanagement.dto;

import com.casestudy.ordermanagement.dto.base.BaseDto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDto extends BaseDto {
    private Long productId;
    private Long customerId;
    private Long quantity;
    private BigDecimal totalPrice;
}
