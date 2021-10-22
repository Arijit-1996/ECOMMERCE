package com.example.ShoppingCart.Controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;































import org.apache.el.stream.Stream;
import org.apache.tomcat.jni.Mmap;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import com.example.ShoppingCart.Cart;
import com.example.ShoppingCart.CustomerOrder;
import com.example.ShoppingCart.cartImpl;
import com.example.ShoppingCart.lineItem;
import com.example.ShoppingCart.repository.CartRepo;
import com.example.ShoppingCart.repository.CustOrderRepo;
import com.example.ShoppingCart.repository.ItemRepo;
import com.google.gson.Gson;




@Controller

public class CartController {
	@Autowired
	cartImpl cartservice;
	@Autowired
	CartRepo repo1;
	@Autowired
	ItemRepo repo2;
	@Autowired
	CustOrderRepo repo3;
	@Autowired
	RestTemplate rest;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/cart/addtocart")
	public ResponseEntity addcart(@RequestBody Cart cart){
	
		//cartservice.addLineItem(cart);
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cartservice.addLineItem(cart));
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/cart/delete/{cartId}/{itemId}")
	public ResponseEntity emptycart(@PathVariable Integer cartId,@PathVariable Integer itemId){
		Optional<Cart> ob_cart=repo1.findById(cartId);
		for(int i=0;i<ob_cart.get().getItems().size();i++){
		if(itemId==ob_cart.get().getItems().get(i).getItemId()){
			ob_cart.get().getItems().remove(i);
			break;
		}
		}
		repo1.save(ob_cart.get());
		return new ResponseEntity("Deleted Successflly", HttpStatus.OK);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/cart/delete/cart/{cartId}")
	public ResponseEntity emptycart(@PathVariable Integer cartId){
		
		cartservice.deleteLineItem(cartId);
		
		return new ResponseEntity("Deleted Successflly", HttpStatus.OK);
	
		
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/shoppingservice/{custid}/cart")
	@CircuitBreaker(name = "CUSTOMERSERVICE", fallbackMethod="getback")
	public ResponseEntity updateCart(@PathVariable Integer custid,@RequestBody Cart cart){
		
		Map<String,Integer> cu =  rest.getForObject("http://CUSTOMERSERVICE/customer/"+custid, Map.class);
		System.out.println(cu);
		if(cu.get("cartid")!=null){
			cart.setCartId(cu.get("cartid"));
		}
		cartservice.updateLineItem(cart);
		
		return new ResponseEntity("Updated Successflly", HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/cart/search/{cartId}")
	public ResponseEntity searchcart(@PathVariable Integer cartId ){
		
		return  ResponseEntity.ok().body(cartservice.searchLineitem(cartId));
	}
	
	@PostMapping("/shoppingservice/customer/{custid}/order")
	
	public ResponseEntity orderFromcart(@PathVariable Integer custid) throws JSONException {
		
		Map<String,Integer> cu =  rest.getForObject("http://CUSTOMERSERVICE/customer/"+custid, Map.class);
		Optional<Cart> cart_o = repo1.findById(cu.get("cartid"));
		System.out.println(cart_o.get().getItems().size());
	
		
/*		for(int i=0;i<cart_o.get().getItems().size();i++){
		items.add(cart_o.get().getItems().get(i));
		
	}*/
		

		
	
		
	/*	Map<String,List<lineItem>> res=new HashMap<String,List<lineItem>>();
		res.put("items",items);
		System.out.println(res);*/
		
		//rest.postForEntity("http://ORDERSERVICE/order/add",cart_o.get().getItems().get(0), Object.class);
		
		System.out.println("{\"items\":"+new Gson().toJson(cart_o.get().getItems())+"}");
		String JsonReq="{\"items\":"+new Gson().toJson(cart_o.get().getItems())+"}";
		
		
		Map<String, List<Integer>> inv = new HashMap<>();  
		List<Integer> list1=new ArrayList<>();
		List<Integer> list2=new ArrayList<>();
		
		
		for(int i=0;i<cart_o.get().getItems().size();i++){
			list1.add(cart_o.get().getItems().get(i).getProductId());
			list2.add(cart_o.get().getItems().get(i).getQuantity());
		}
		
		inv.put("productId", list1);
		inv.put("quantity", list2);
		System.out.println(list1.isEmpty());
		
		RequestEntity<String> res= RequestEntity.post("http://ORDERSERVICE/order/add").contentType(MediaType.APPLICATION_JSON).body(JsonReq);
		
		cart_o.get().getItems().removeAll(cart_o.get().getItems());
		
	     ResponseEntity<Map> response=  rest.exchange(res, Map.class);
	  
	     CustomerOrder co=new CustomerOrder(custid,(Integer) response.getBody().get("orderId"));
	     
	     repo3.save(co);
	  
	     
	     RequestEntity<Map<String, List<Integer>>> res2= RequestEntity.put("http://INVENTORYSERVICE/inventory/update/order").contentType(MediaType.APPLICATION_JSON).body(inv);		
			rest.exchange(res2, String.class);
		
		return ResponseEntity.ok().body(response);
		
	//	repo1.save(cart_o.get());
		
		//return  lass);
		
		}
	public ResponseEntity getback(Exception ex){
		return new ResponseEntity("Service is Down",HttpStatus.NOT_FOUND);
	}

}
