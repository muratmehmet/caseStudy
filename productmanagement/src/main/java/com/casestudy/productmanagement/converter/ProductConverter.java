package com.casestudy.productmanagement.converter;

import com.casestudy.productmanagement.domain.Inventory;
import com.casestudy.productmanagement.domain.Product;
import com.casestudy.productmanagement.dto.InventoryDto;
import com.casestudy.productmanagement.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter implements Converter<ProductDto, Product> {
    @Override
    public Product toEntity(ProductDto var1){
        if(var1 == null){
            return null;
        }
        Product entity = new Product();

        if(var1.getId() != null){
            entity.setId(var1.getId());
        }

        entity.setName(var1.getName());
        entity.setQuantity(var1.getQuantity());
        entity.setType(var1.getType());
        entity.setDescription(var1.getDescription());
        entity.setPrice(var1.getPrice());
        entity.setInventory(inventoryToEntity(var1.getInventory()));


        return entity;
    }

    @Override
    public ProductDto toDto(Product var1) {
        return null;
    }

    public Inventory inventoryToEntity(InventoryDto inventoryDto){
        if (inventoryDto == null) {
            return null;
        }

        Inventory entity = new Inventory();
        entity.setCity(inventoryDto.getCity());
        entity.setState(inventoryDto.getState());
        entity.setName(inventoryDto.getName());
        entity.setStatus(inventoryDto.getStatus());

        return entity;
    }
}
