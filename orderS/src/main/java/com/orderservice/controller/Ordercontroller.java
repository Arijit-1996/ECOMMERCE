package com.orderservice.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.Repository.OrderDb;
import com.orderservice.service.Orderservice;





@RestController
public class Ordercontroller {
	
	@Autowired
	Orderservice service;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/order/add")
	public ResponseEntity addOrder(@RequestBody OrderDb order) {
		
	//	System.out.println(order.getItems().get(0).getProductName());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addOrder(order));
		
	}
	
	@DeleteMapping("/order/delete/{id}")
	public void deleteOrder(@PathVariable int id) {
		
		service.deleteOrder(id);
		
	}
	
	@PutMapping("/order/update")
	public String updateOrder(@RequestBody OrderDb order) {
		
		 service.updateOrder(order);
		 return "Success";
	}
	
	@GetMapping("/api/order/{id}")
	public OrderDb searchOrder(@PathVariable int id) {
		
		return service.searchOrder(id);
	}

}
