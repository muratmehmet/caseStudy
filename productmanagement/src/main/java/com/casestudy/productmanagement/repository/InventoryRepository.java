package com.casestudy.productmanagement.repository;

import com.casestudy.productmanagement.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {



}
