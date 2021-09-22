package com.productservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product")
@Data

public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private
	int productId;
	
	@Column(name="productName")
	private
	String productName;
	
	@Column(name="productDescription")
	private
	String productDescription;
	
	@Column(name="productPrice")
	private
	int productPrice;
	
	
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public Product(String productName, String productDescription, int productPrice) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
	}

	public Product() {
		super();
	}
	

}
