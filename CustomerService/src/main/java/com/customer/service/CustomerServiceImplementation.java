package com.customer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.customer.entity.Customer;
import com.customer.entity.CustomerCart;
import com.customer.repository.CustCartRepo;
import com.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImplementation {
		
		@Autowired
	    CustomerRepository custrepo;
		@Autowired
		RestTemplate rest;
		@Autowired
		CustCartRepo ccrepo;
		
		public Customer addcustomer(Customer customer) {
			
			Customer cu_ob= custrepo.save(customer);
			
			
			Map<String,Object> items=new HashMap<String,Object>();
			
			Map<String,Integer> map=rest.postForObject("http://SHOPPINGCART/cart/addtocart", items, Map.class);
			
			CustomerCart cc=new CustomerCart(cu_ob.getCustid(),map.get("cartId"));
			ccrepo.save(cc);
			
			
			
			return cu_ob;
		}

		public Customer searchcustomer(int id) {
			return custrepo.findById(id).get();
		}

		public void deletecustomer(int id) {
			custrepo.deleteById(id);
			
		}

		public Customer updatecustomer(int id) {
			 
			Customer customerToChange = new Customer();
	/*		Customer newCustomer=custrepo.findById(id).get();

			//Update the allowed fields with the new data
	        customerToChange.BillingAddr = newCustomer.BillingAddr;
	        customerToChange.ShippingAddr = newCustomer.ShippingAddr;
	        customerToChange.email = newCustomer.email;
	        customerToChange.custname = newCustomer.custname;
		 

	      //Save the data changes*/
	        return custrepo.save(customerToChange);
	             
		       
		}
		
		
}
