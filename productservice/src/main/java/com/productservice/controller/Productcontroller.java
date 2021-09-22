package com.productservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.productservice.domain.Product;
import com.productservice.service.Productservice;

@RestController
public class Productcontroller {
	
		
		@Autowired
		Productservice service;
		@Autowired
		RestTemplate rest;
		
		
		
		@PostMapping("/shoppingservice/products")
		@ResponseBody
		public Product addProduct(@RequestBody Map<String,Object> prod){
			Product product=new Product((String) prod.get("productName"),(String) prod.get("productDescription"),
				      (Integer) prod.get("productPrice"));
			Product pr= service.saveProduct(product);
			
			String JsonString="{\"productId\":"+pr.getProductId()+",\"quantity\":"+(Integer) prod.get("quantity")+"}";
			System.out.println(JsonString);
			RequestEntity<String> res2= RequestEntity.put("http://INVENTORYSERVICE/inventory/update/add").contentType(MediaType.APPLICATION_JSON).body(JsonString);
			rest.exchange(res2, String.class);
			return pr;
			
		}
		
		@DeleteMapping("/api/products/{productId}")
		@ResponseBody
		public void deleteteProduct(@PathVariable int productId){
			service.removeProduct(productId);
			
		}
		
		@PutMapping("/api/products/{productId}")
		@ResponseBody
		public Product updateProduct(@PathVariable int productId,@RequestBody Product prod){
			return service.editProduct(productId, prod);
			
		}
		
		@GetMapping("/api/products/{productId}")
		@ResponseBody
		public Product searchProduct(@PathVariable int productId){
			return service.findProduct(productId);
			
		}
		



}
