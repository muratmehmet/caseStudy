package com.casestudy.ordermanagement.controller;


import com.casestudy.ordermanagement.exception.CustomApiException;
import com.casestudy.ordermanagement.exception.CustomApiRequestException;
import com.casestudy.ordermanagement.request.OrderRequest;
import com.casestudy.ordermanagement.service.CustomerService;
import com.casestudy.ordermanagement.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/orders")
public class OrderController {

    private final OrderService orderService;
    private final CustomerService customerService;



    @GetMapping("/order")
    public BigDecimal order(@RequestBody OrderRequest request){
        if (customerService.checkCustomer(request.customerId())) {
            return orderService.order(request);
        } else {
            throw new CustomApiRequestException("Customer not found");
        }
    }


}
