package com.inventory.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.Service.InventoryService;
import com.inventory.domain.Inventory;


@RestController
public class InventoryController {

	@Autowired
	InventoryService service;

	@PostMapping("/add")
	public Inventory addInventory(@RequestBody Inventory newInventory) {
		return service.addinventory(newInventory);
	}

//	@SuppressWarnings("rawtypes")
//	@RequestMapping(value="/update/{inventoryId}", method = RequestMethod.PUT)
//	public ResponseEntity updateCustomer(@PathVariable("inventoryId") int id,@RequestBody Inventory inventory) throws Exception {
//
//		return ResponseEntity.ok(service.updateinventory(id, inventory));
//
//	}
	@PutMapping("/update/{inventoryId}")
	public Inventory updateInventory(@PathVariable("inventoryId") int id,@RequestBody Inventory inventory) throws Exception {
		return service.updateinventory(id, inventory);
		
	}

	@DeleteMapping("/delete/{inventoryId}")
	public void deleteCustomer(@PathVariable("inventoryId") int id) {
		service.deleteinventory(id);
		System.out.println("Deleted successfully!");
	}

	@GetMapping("/search/{inventoryId}")
	public Inventory searchCustomer(@PathVariable("inventoryId") int id) {
		return service.searchinventory(id);
	}
	@PutMapping("inventory/update/add")
	public void update1(@RequestBody Map<String,Integer> inv){
		service.update1(inv);
		
	}
	@PutMapping("inventory/update/order")
	public void update2(@RequestBody Map<String, List<Integer>> inv){
		service.updateInventory2(inv);
	}

}
