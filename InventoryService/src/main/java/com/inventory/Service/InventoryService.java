package com.inventory.Service;

import java.util.List;
import java.util.Map;

import com.inventory.domain.Inventory;

public interface InventoryService {

	public Inventory addinventory(Inventory inventory);

	public Inventory searchinventory(int id);

	public void deleteinventory(int id);

	public Inventory updateinventory(int id,Inventory inventory) throws Exception;

	public void updateInventory2(Map<String, List<Integer>> inv);


	public void update1(Map<String, Integer> inv);
}
