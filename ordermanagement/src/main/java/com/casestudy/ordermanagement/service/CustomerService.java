package com.casestudy.ordermanagement.service;

import com.casestudy.ordermanagement.converter.CustomerConverter;
import com.casestudy.ordermanagement.domain.Customer;
import com.casestudy.ordermanagement.dto.CustomerDto;
import com.casestudy.ordermanagement.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;
    private CustomerConverter customerConverter;


    public boolean checkCustomer(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        return customer.isPresent();
    }

    public void save(CustomerDto customerDto) {
        customerRepository.save(customerConverter.toEntity(customerDto));
    }

}
