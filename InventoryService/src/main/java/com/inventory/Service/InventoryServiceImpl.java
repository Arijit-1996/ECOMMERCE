package com.inventory.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.domain.Inventory;
import com.inventory.repo.InventoryRepo;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryRepo repo;

	public Inventory addinventory(Inventory inventory) {
		//Inventory toAdd = new Inventory(inventory.productId, inventory.quantity);
		return repo.save(inventory);
	}

	public Inventory searchinventory(int id) {
		return repo.findById(id).get();
	}

	public void deleteinventory(int id) {
		repo.deleteById(id);
	}

	public Inventory updateinventory(int id, Inventory inventory)  {  //throws Exception

//		if (repo.findById(id).isPresent()) {
//			Inventory ToChange = new Inventory();
//			ToChange.setInventoryId(ToChange.getInventoryId());
//			ToChange.setProductId(ToChange.getProductId());
//			ToChange.setQuantity(ToChange.getQuantity());
//			
//			return repo.save(ToChange);
//		} else {
//			throw new Exception("Id not Exists");
//		}
		
		
 	Inventory newInven=repo.findById(id).get();

		 //Update the allowed fields with the new data
//		newInven.productId = inventory.productId;
//	    newInven.quantity= inventory.quantity;
	
		 //Save the data changes
		return repo.save(newInven);
	}

	public void updateInventory2(Map<String, List<Integer>> inv) {
	
		List<Inventory> list_in=inv.get("productId").stream().map(p -> 
		              repo.findByproductId(p)).collect(Collectors.toList());
		List<Integer> quant = inv.get("quantity").stream().collect(Collectors.toList());
		for(int i=0;i<list_in.size();i++){
			list_in.get(i).setQuantity(list_in.get(i).getQuantity()-quant.get(i));
			repo.save(list_in.get(i));
		}
		
	}

	
	public void update1(Map<String, Integer> inv) {
		
		Inventory in_ob=repo.findByproductId(inv.get("productId"));
		
		in_ob.setQuantity(in_ob.getQuantity()+inv.get("quantity"));
		repo.save(in_ob);
		
	}

	
	
	



}
