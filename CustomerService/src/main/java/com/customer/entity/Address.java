package com.customer.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {


	
		
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private int id;
		
		private long doorno;
		private String stName;
		private String layout;
		private String city;
		private long pincode;
		
		
		
		
		
		
		public Address() {
			super();
		}
		public Address( long doorno, String stName, String layout, String city, long pincode) {
			super();
			
			this.doorno = doorno;
			this.stName = stName;
			this.layout = layout;
			this.city = city;
			this.pincode = pincode;
			
		}
		public long getDoorno() {
			return doorno;
		}
		public void setDoorno(long doorno) {
			this.doorno = doorno;
		}
		public String getStName() {
			return stName;
		}
		public void setStName(String stName) {
			this.stName = stName;
		}
		public String getLayout() {
			return layout;
		}
		public void setLayout(String layout) {
			this.layout = layout;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public long getPincode() {
			return pincode;
		}
		public void setPincode(long pincode) {
			this.pincode = pincode;
		}
	
		
}
