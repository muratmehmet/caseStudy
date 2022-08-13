package com.casestudy.ordermanagement.controller;


import com.casestudy.ordermanagement.dto.CustomerDto;
import com.casestudy.ordermanagement.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public void save(@RequestBody CustomerDto customerDto){
        log.info("customer saving process begin for {}", customerDto);
        customerService.save(customerDto);
    }


}
