package com.casestudy.productmanagement.controller;


import com.casestudy.productmanagement.dto.InventoryDto;
import com.casestudy.productmanagement.service.InventoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/inventories")
public class InventoryController {
    private final InventoryService inventoryService;

    @PostMapping
    public void save(@RequestBody InventoryDto inventoryDto){
        log.info("product saving process begin {}", inventoryDto);
        inventoryService.save(inventoryDto);
    }
}
