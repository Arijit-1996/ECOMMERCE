package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.entity.CustomerCart;

public interface CustCartRepo extends JpaRepository<CustomerCart, Integer> {

}
