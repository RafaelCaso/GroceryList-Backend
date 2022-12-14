package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.GroceryListItem;
import com.example.repository.GroceryListItemRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class GroceryListItemService {
	
	GroceryListItemRepository gRepo;
	
	public GroceryListItem createGroceryListItem(String name, String description, Double price) {
		GroceryListItem newItem = new GroceryListItem(name, description, price);
		return gRepo.save(newItem);
	}
	
	public void groceryListItemPurchased(Integer id) {
		GroceryListItem purchasedItem = gRepo.findById(id).get();
		purchasedItem.setPurchased(true);
		gRepo.save(purchasedItem);
	}
	
	public List<GroceryListItem> getAllGroceryListItems() {
		return gRepo.findAll();
	}

}
