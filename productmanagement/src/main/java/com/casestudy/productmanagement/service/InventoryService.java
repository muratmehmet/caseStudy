package com.casestudy.productmanagement.service;

import com.casestudy.productmanagement.converter.InventoryConverter;
import com.casestudy.productmanagement.dto.InventoryDto;
import com.casestudy.productmanagement.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final InventoryConverter inventoryConverter;
    public void save(InventoryDto inventoryDto) {
        inventoryRepository.save(inventoryConverter.toEntity(inventoryDto));
    }
}
