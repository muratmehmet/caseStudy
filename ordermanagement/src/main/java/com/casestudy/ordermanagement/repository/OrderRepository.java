package com.casestudy.ordermanagement.repository;
import com.casestudy.ordermanagement.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
