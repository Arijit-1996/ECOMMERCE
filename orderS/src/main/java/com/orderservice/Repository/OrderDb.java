package com.orderservice.Repository;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
//@Table(name="order")
public class OrderDb {
	
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int orderId;
	
		@OneToMany(orphanRemoval=true,cascade=CascadeType.ALL)
		@JoinColumn(name="orderId")
		private List<Lineitem> items;
			
		
		public OrderDb() {
			super();
		}
		
		
		
		public OrderDb(int orderId, List<Lineitem> items) {
			super();
			this.orderId = orderId;
			this.items = items;
		}



		public int getOrderId() {
			return orderId;
		}


		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}


		public List<Lineitem> getItems() {
			return items;
		}
		public void setItems(List<Lineitem> items) {
			this.items = items;
		
		}

}
