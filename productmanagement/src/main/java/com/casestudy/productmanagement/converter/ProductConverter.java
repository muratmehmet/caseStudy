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
        entity.setStatus(var1.getStatus());
        entity.setProductId(var1.getProductId());
        entity.setDescription(var1.getDescription());
        entity.setPrice(var1.getPrice());
        entity.setInventory(inventoryToEntity(var1.getInventory()));


        return entity;
    }

    @Override
    public ProductDto toDto(Product var1) {

        ProductDto productDto = new ProductDto();

        productDto.setId(var1.getId());
        productDto.setName(var1.getName());
        productDto.setQuantity(var1.getQuantity());
        productDto.setType(var1.getType());
        productDto.setStatus(var1.getStatus());
        productDto.setDescription(var1.getDescription());
        productDto.setPrice(var1.getPrice());
        productDto.setInventory(inventoryEntityToInventoryDto(var1.getInventory()));

        return productDto;
    }

    private InventoryDto inventoryEntityToInventoryDto(Inventory inventory) {

        InventoryDto inventoryDto = new InventoryDto();

        inventoryDto.setId(inventory.getId());
        inventoryDto.setCity(inventory.getCity());
        inventoryDto.setState(inventory.getState());
        inventoryDto.setName(inventory.getName());
        inventoryDto.setStatus(inventory.getStatus());

        return inventoryDto;
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
