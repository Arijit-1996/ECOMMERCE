package com.customer.service;

import com.customer.entity.Customer;

public interface CustomerService {
	
	public Customer addcustomer(Customer customer);
	public Customer searchcustomer(int id);
	public void deletecustomer(int id);
	public Customer updatecustomer(int id);

}
