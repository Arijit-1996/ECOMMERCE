package com.customer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerCart {
	@Id
	private int custid;
	private int cartid;
	
	
	
	public CustomerCart() {
		super();
	}
	
	
	public CustomerCart(int custid, int cartid) {
		super();
		this.custid = custid;
		this.cartid = cartid;
	}


	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	

}
