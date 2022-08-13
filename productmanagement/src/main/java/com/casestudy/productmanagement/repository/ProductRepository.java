package com.casestudy.productmanagement.repository;

import com.casestudy.productmanagement.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByProductIdAndQuantityGreaterThanOrderByQuantity(Long productId, Long zero);
}
