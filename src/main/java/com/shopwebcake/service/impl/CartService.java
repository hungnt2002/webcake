package com.shopwebcake.service.impl;

import java.util.List;

import com.shopwebcake.dao.impl.CartDao;
import com.shopwebcake.model.Cart;
import com.shopwebcake.service.ICartService;

public class CartService implements ICartService {

	CartDao cartDao = new CartDao();
	
	@Override
	public void insert(Cart cart) {
		cartDao.insert(cart);
		
	}

	@Override
	public void edit(Cart cart) {
		cartDao.edit(cart);
		
	}

	@Override
	public void delete(int id) {
		cartDao.delete(id);
		
	}

	@Override
	public Cart get(int id) {
		// TODO Auto-generated method stub
		return cartDao.get(id);
	}

	@Override
	public List<Cart> getAll() {
		// TODO Auto-generated method stub
		return cartDao.getAll();
	}

	

}
