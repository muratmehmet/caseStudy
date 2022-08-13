package com.casestudy.productmanagement.controller;


import com.casestudy.productmanagement.converter.ProductConverter;
import com.casestudy.productmanagement.domain.Product;
import com.casestudy.productmanagement.dto.ProductDto;
import com.casestudy.productmanagement.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;
    private final ProductConverter productConverter;

    @PostMapping
    public void save(@RequestBody ProductDto productDto){
        log.info("new product saving process started {}", productDto);
        productService.save(productDto);
    }

    @GetMapping()
    public ProductDto getById(@RequestParam(value = "id") Long id){
        return productConverter.toDto(productService.getById(id));
    }

    @GetMapping("/calculate-price")
    public BigDecimal calculatePrice(@RequestParam(value = "productId") Long productId,
                                     @RequestParam(value = "quantity") Long quantity){
        return productService.calculatePrice(productId, quantity);
    }


    @GetMapping
    public List<ProductDto> getAll(){
        return productService.findAll().stream().map(productConverter::toDto).collect(Collectors.toList());
    }

    @PutMapping()
    public void update(@RequestBody ProductDto productDto){
        productService.save(productDto);
    }
}
