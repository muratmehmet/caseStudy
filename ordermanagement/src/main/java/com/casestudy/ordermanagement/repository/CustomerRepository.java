package com.casestudy.ordermanagement.repository;

import com.casestudy.ordermanagement.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
