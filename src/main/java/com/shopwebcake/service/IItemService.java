package com.shopwebcake.service;

import java.util.List;

import com.shopwebcake.model.Item;

public interface IItemService {
	void insert(Item item);

	void edit(Item item);

	void delete(int id);

	Item get(int id);
	
	List<Item> getAll();


}
