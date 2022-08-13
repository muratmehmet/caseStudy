package com.casestudy.ordermanagement.domain;


import com.casestudy.ordermanagement.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="order")
public class Order extends BaseEntity {

    private Long productId;
    private Long customerId;
    private Long quantity;
    private BigDecimal totalPrice;
}
