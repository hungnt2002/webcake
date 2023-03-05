package com.shopwebcake.dao;

import java.util.List;

import com.shopwebcake.model.Item;



public interface IItemDao {
	void insert(Item item);

	void edit(Item item);

	void delete(int id);

	Item get(String name);

	Item get(int id);

	List<Item> getAll();

	List<Item> search(String name);
}
