package com.shopwebcake.service.impl;

import java.util.List;

import com.shopwebcake.dao.impl.CakeDao;
import com.shopwebcake.jdbc.JDBCConnection;
import com.shopwebcake.model.Cake;
import com.shopwebcake.service.ICakeService;

public class CakeService extends JDBCConnection implements ICakeService {
	  CakeDao cakeDao = new CakeDao();
	@Override
	public void insert(Cake cake) {
		cakeDao.insert(cake);
		
	}

	@Override
	public void edit(Cake cake) {
		cakeDao.edit(cake);
		
	}

	@Override
	public void delete(int id) {
		cakeDao.delete(id);
		
	}

	@Override
	public Cake get(int id) {
		// TODO Auto-generated method stub
		return cakeDao.get(id);
	}

	@Override
	public List<Cake> getAll() {
		// TODO Auto-generated method stub
		return cakeDao.getAll();
	}

	@Override
	public List<Cake> search(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cake> searchByCategory(int categoryId) {
		// TODO Auto-generated method stub
		return cakeDao.searchByCategory(categoryId);
	}

	@Override
	public List<Cake> searchByName(String cakeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String currencyPrice(long price) {
			
		return cakeDao.currencyPrice(price);
	}

}
