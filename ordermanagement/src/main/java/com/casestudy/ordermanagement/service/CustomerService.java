package com.casestudy.ordermanagement.service;

import com.casestudy.ordermanagement.domain.Customer;
import com.casestudy.ordermanagement.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;


    public boolean checkCustomer(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        return customer.isPresent();
    }
}
