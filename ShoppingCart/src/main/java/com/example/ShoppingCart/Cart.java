package com.example.ShoppingCart;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonRawValue;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartId;
	@OneToMany(orphanRemoval= true,cascade=CascadeType.ALL)
	@JoinColumn(name="cartId")
	@JsonRawValue
	private List<lineItem> items;
		
	
	public Cart() {
		super();
	}
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public List<lineItem> getItems() {
		return items;
	}
	public void setItems(List<lineItem> items) {
		this.items = items;
	}

}
