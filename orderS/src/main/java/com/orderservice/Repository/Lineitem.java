package com.orderservice.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//@Table(name="lineitem")
public class Lineitem {
		@Id
	//	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int itemId;
		private int productId;
		private String productName;
		private int quantity;
		private double price;
		
		public Lineitem() {
			super();
		}
		
		
		
		public Lineitem(int itemId, int productId, String productName,
				int quantity, double price) {
			super();
			this.itemId = itemId;
			this.productId = productId;
			this.productName = productName;
			this.quantity = quantity;
			this.price = price;
		}



		public int getItemId() {
			return itemId;
		}
		public void setItemId(int itemId) {
			this.itemId = itemId;
		}
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
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}



}
