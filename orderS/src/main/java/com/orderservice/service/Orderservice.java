package com.orderservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.stereotype.Service;




import com.orderservice.Repository.Lineitem;
import com.orderservice.Repository.LineitemRepository;
import com.orderservice.Repository.OrderDb;
import com.orderservice.Repository.OrderRepository;


@Service
public class Orderservice {
	
	@Autowired
	OrderRepository repo1;
	@Autowired
	LineitemRepository repo2;
	
	public OrderDb addOrder(OrderDb order)
	{
	/*	Lineitem item=new Lineitem();
		item.setItemId(order.getItems().get(0).getItemId());
		item.setPrice(order.getItems().get(0).getPrice());
		item.setProductId(order.getItems().get(0).getProductId());
		item.setProductName(order.getItems().get(0).getProductName());
		item.setQuantity(order.getItems().get(0).getQuantity());
		
		 OrderDb od=new OrderDb();
		 od.setItems(item);*/
		 return repo1.save(order);
		 
		
	}
	
	public void deleteOrder(int id)
	{
		repo1.deleteById(id);
	}
	
	@SuppressWarnings("deprecation")
	public void updateOrder(OrderDb order) {
    Optional<OrderDb> order_ob =repo1.findById(order.getOrderId());
		
		for(int i=0;i<order.getItems().size();i++){
			if(order_ob.get().getItems().get(i).getItemId()==order.getItems().get(i).getItemId()){
				order_ob.get().getItems().get(i).setProductId(order.getItems().get(i).getProductId());
				order_ob.get().getItems().get(i).setProductName(order.getItems().get(i).getProductName());
				order_ob.get().getItems().get(i).setQuantity(order.getItems().get(i).getQuantity());
				order_ob.get().getItems().get(i).setPrice(order.getItems().get(i).getPrice());
				repo1.save(order_ob.get());
				System.out.println("in loop");
				
			}
			
		}
		
	}
	
	public OrderDb searchOrder(int id) {
		return  repo1.findById(id).get();
	}

}
