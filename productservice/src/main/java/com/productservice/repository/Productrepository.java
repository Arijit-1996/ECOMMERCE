package com.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productservice.domain.Product;

@Repository
public interface Productrepository extends JpaRepository<Product,Integer> {

}
