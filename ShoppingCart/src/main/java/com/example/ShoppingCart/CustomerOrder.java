package com.example.ShoppingCart;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerOrder {
	@Id
	private int cartId;
	private int orderId;
	
	
	public CustomerOrder() {
		super();
	}
	
	public CustomerOrder(int cartId, int orderId) {
		super();
		this.cartId = cartId;
		this.orderId = orderId;
	}

	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

}
