package com.orderservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.orderservice.domain.Order;

public interface OrderRepository extends JpaRepository<OrderDb, Integer>{

}
