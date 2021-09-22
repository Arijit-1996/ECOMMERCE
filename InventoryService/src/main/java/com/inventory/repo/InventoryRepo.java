package com.inventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.domain.Inventory;



public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
     Inventory findByproductId(Integer productId);
}
