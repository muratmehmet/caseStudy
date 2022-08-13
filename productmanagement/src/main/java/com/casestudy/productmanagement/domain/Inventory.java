package com.casestudy.productmanagement.domain;


import com.casestudy.productmanagement.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="inventory")
public class Inventory extends BaseEntity {

    private String name;
    private String city;
    private String state;
    private String status; //TODO:Enum'a çevrilebilir
}
