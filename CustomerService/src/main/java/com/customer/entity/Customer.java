package com.customer.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int custid;
	private String custname;
	private String email;
	@OneToOne(cascade=CascadeType.ALL)
	private Address BillingAddr;
	@OneToOne(cascade=CascadeType.ALL)
	private Address ShippingAddr;
	
	
	
	public Customer() {
		super();
	}

	public Customer( String custname, String email, Address billingAddr, Address shippingAddr) {
		super();
		this.custname = custname;
		this.email = email;
		BillingAddr = billingAddr;
		ShippingAddr = shippingAddr;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getBillingAddr() {
		return BillingAddr;
	}

	public void setBillingAddr(Address billingAddr) {
		BillingAddr = billingAddr;
	}

	public Address getShippingAddr() {
		return ShippingAddr;
	}

	public void setShippingAddr(Address shippingAddr) {
		ShippingAddr = shippingAddr;
	}

	
	
	
}
