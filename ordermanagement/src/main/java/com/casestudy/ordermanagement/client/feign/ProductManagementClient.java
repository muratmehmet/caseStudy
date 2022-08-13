package com.casestudy.ordermanagement.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@FeignClient(name="product-management")
public interface ProductManagementClient {

    @GetMapping("/api/v1/products")
    List<String> getAllProduct();

    @GetMapping("/api/v1/products/calculate-price")
    BigDecimal calculatePrice(@RequestParam(value = "productId") Long productId,
                              @RequestParam(value = "quantity") Long quantity);

}
