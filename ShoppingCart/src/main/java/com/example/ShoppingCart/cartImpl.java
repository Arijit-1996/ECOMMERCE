package com.example.ShoppingCart;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ShoppingCart.repository.CartRepo;
import com.example.ShoppingCart.repository.ItemRepo;

@Service
public class cartImpl {
	@Autowired
	CartRepo cartrepo;
	@Autowired
	ItemRepo itemrepo;
	
		public Cart addLineItem(Cart cart){
						
			return cartrepo.save(cart);
			}
	
	public void deleteLineItem(Integer cartId){
		
		cartrepo.deleteById(cartId);
	}
	
	public void updateLineItem(Cart cart){
		
		Optional<Cart> cart_ob =cartrepo.findById(cart.getCartId());
		if(cart_ob.get().getItems().size()==0){
			cartrepo.save(cart);
			
		}
		else if(cart.getItems().get(0).getItemId()==0){
			
				   Cart Cu_ob= cartrepo.findById(cart.getCartId()).get();
				   for(int i=0;i<cart.getItems().size();i++){
				   Cu_ob.getItems().add(cart.getItems().get(i));
					System.out.println(cart.getCartId());
					System.out.println(cart.getItems().size());
				   }
					cartrepo.save(Cu_ob);
					
		}

		else{
			System.out.println("in else");
		for(int i=0;i<cart_ob.get().getItems().size();i++){
			if(cart_ob.get().getItems().get(i).getItemId()==cart.getItems().get(0).getItemId()){
				System.out.println("in else");
				
				cart_ob.get().getItems().get(i).setProductId(cart.getItems().get(0).getProductId());
				cart_ob.get().getItems().get(i).setProductName(cart.getItems().get(0).getProductName());
				cart_ob.get().getItems().get(i).setQuantity(cart.getItems().get(0).getQuantity());
				cart_ob.get().getItems().get(i).setPrice(cart.getItems().get(0).getPrice());
				
				
				cartrepo.save(cart_ob.get());
				
			}
		  }
		}
	}
		
	
	public Optional<Cart> searchLineitem(Integer cartId){
		
		return cartrepo.findById(cartId);
	}
}
