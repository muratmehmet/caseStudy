package com.casestudy.productmanagement.domain;


import com.casestudy.productmanagement.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product extends BaseEntity {

    private Long productId;
    private String status;
    private Long quantity;
    private String name;
    private BigDecimal price;
    @Lob
    private String description;
    private String type; //TODO: ENUM'a çevrilebilir

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn
    private Inventory inventory;

}
