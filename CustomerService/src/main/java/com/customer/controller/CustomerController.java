package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entity.Customer;
import com.customer.entity.CustomerCart;
import com.customer.repository.CustCartRepo;
import com.customer.service.CustomerServiceImplementation;

@RestController
public class CustomerController {
		@Autowired
		private CustomerServiceImplementation service;
		@Autowired
		CustCartRepo ccrepo;
		
		
		@PostMapping("/api/add")
		public Customer addCustomer(@RequestBody Customer newCustomer)
		{
	     return service.addcustomer(newCustomer);
		 }
		   
		    @PutMapping("/api/update/{custid}")
		    public Customer updateCustomer(@PathVariable int custid, @RequestBody Customer newCustomer)
		    {

		        return service.updatecustomer(custid);

		    }
		    @DeleteMapping("/api/delete/{custid}")
		    public void deleteCustomer(@PathVariable int custid)
		    {
		    	 service.deletecustomer(custid);	   
		    	 }
		    
		    @GetMapping("/api/search/{custid}")
		    public Customer searchCustomer(@PathVariable int custid)
		    {
		    	return service.searchcustomer(custid);	   
		    	}
		    @GetMapping("customer/{custid}")
		    public CustomerCart getcart(@PathVariable Integer custid){
		    	
		    return	ccrepo.findById(custid).get();
		    }
}
