package com.example.ShoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ShoppingCart.lineItem;

public interface ItemRepo extends JpaRepository<lineItem, Integer> {
		
}
