package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.GroceryListItem;

@Repository
public interface GroceryListItemRepository extends JpaRepository<GroceryListItem, Integer> {

	
	
}
