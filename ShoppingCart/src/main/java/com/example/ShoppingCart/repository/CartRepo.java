package com.example.ShoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ShoppingCart.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer> {

}
