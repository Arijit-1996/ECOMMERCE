package com.example.ShoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ShoppingCart.CustomerOrder;

public interface CustOrderRepo extends JpaRepository<CustomerOrder, Integer> {
	

}
