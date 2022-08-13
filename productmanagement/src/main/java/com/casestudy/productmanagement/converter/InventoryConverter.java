package com.casestudy.productmanagement.converter;

import com.casestudy.productmanagement.domain.Inventory;
import com.casestudy.productmanagement.dto.InventoryDto;
import org.springframework.stereotype.Component;

@Component
public class InventoryConverter implements Converter<InventoryDto, Inventory> {

    @Override
    public Inventory toEntity(InventoryDto var1) {
        if(var1 == null){
            return null;
        }

        Inventory entity = new Inventory();

        if(var1.getId() != null){
            entity.setId(var1.getId());
        }



        entity.setName(var1.getName());
        entity.setState(var1.getState());
        entity.setCity(var1.getCity());
        entity.setState(var1.getState());

        return entity;

    }



    @Override
    public InventoryDto toDto(Inventory var1) {
        return null;
    }
}
