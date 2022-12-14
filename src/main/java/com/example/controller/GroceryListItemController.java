package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.GroceryListItem;
import com.example.service.GroceryListItemService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("grocerylistitems")
@CrossOrigin("*")
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class GroceryListItemController {

	private GroceryListItemService gServ;
	
	@PostMapping("/newitem")
	public GroceryListItem addItem(@RequestBody GroceryListItem gli) {
		return gServ.createGroceryListItem(gli.getName(), gli.getDescription(), gli.getPrice());
	}
	
	@PutMapping("/purchaseditem")
	public void purchaseItem(@RequestParam(name="id") Integer id) {
		gServ.groceryListItemPurchased(id);
	}
	
	@GetMapping("/all")
	public List<GroceryListItem> getAllGroceryListItems() {
		return gServ.getAllGroceryListItems();
	}
	
}
