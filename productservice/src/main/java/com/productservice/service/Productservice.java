package com.productservice.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productservice.domain.Product;
import com.productservice.repository.Productrepository;

@Service
public class Productservice {
	
	@Autowired
	Productrepository repo;
	
	public Product saveProduct(Product prod){
		
		
	
		return repo.save(prod);
		
	}
	
	
	public void removeProduct(int productId){
		
		repo.deleteById(productId);
		
	}
	
	
	public Product editProduct(int productId,Product p){
		//Product dbprod=repo.getOne(prod.getProductId());
		//dbprod=prod;
		//return dbprod;
		
		//Product prod1=new Product();
		Product prod=repo.findById(productId).get();
		//prod1.productName=prod.productName;
		//prod1.productDescription=prod.productDescription;
		//prod1.productPrice=prod.productPrice;
	/*	prod.setProductName(p.productName);
		prod.setProductDescription(p.productDescription);
		prod.setProductPrice(p.productPrice);*/
		return repo.save(prod);
		
		
	}
	
	
	public Product findProduct(int productId){
		return repo.findById(productId).get();
		
	}
	





}
