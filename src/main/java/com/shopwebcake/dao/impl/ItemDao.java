package com.shopwebcake.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopwebcake.dao.IItemDao;
import com.shopwebcake.jdbc.JDBCConnection;
import com.shopwebcake.model.Cake;
import com.shopwebcake.model.Cart;
import com.shopwebcake.model.Item;

public class ItemDao extends JDBCConnection implements IItemDao {

	@Override
	public void insert(Item item) {
		String sql = "INSERT INTO tblCartItem (quantity, price, cakeId, cartId) VALUES (?,?,?,?)";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCConnection.getJDBCConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, statement.RETURN_GENERATED_KEYS);

			statement.setInt(1, item.getQuantity());
			statement.setLong(2, item.getUnitPrice());
			statement.setInt(3, item.getCake().getCakeId());
			statement.setInt(4, item.getCart().getCartId());

			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void edit(Item item) {
		String sql = "UPDATE tblCartItem SET quantity = ? , price = ?, cakeId = ?,cartId=?  WHERE id = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCConnection.getJDBCConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, statement.RETURN_GENERATED_KEYS);

			statement.setInt(1, item.getQuantity());
			statement.setLong(2, item.getUnitPrice());
			statement.setInt(3, item.getCake().getCakeId());
			statement.setInt(4, item.getCart().getCartId());
			statement.setInt(5, item.getId());

			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM tblCartItem WHERE id=?";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = JDBCConnection.getJDBCConnection();
			connection.setAutoCommit(false);

			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

	}

	@Override
	public Item get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item get(int id) {
		String sql = "SELECT * FROM tblCartItem WHERE id=?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Item item = new Item();

		try {
			connection = JDBCConnection.getJDBCConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				item.setId(resultSet.getInt("id"));
				item.setQuantity(resultSet.getInt("quantity"));
				item.setUnitPrice(resultSet.getLong("price"));

				CakeDao cakeDao = new CakeDao();
				Cake cake = cakeDao.get(resultSet.getInt("cakeId"));
				item.setCake(cake);

				CartDao cartDao = new CartDao();
				Cart cart = cartDao.get(resultSet.getInt("cartId"));
				item.setCart(cart);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
		return item;

	}

	@Override
	public List<Item> getAll() {

		List<Item> itemList = new ArrayList<Item>();
		String sql = "SELECT * FROM tblCartItem ";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCConnection.getJDBCConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Item item = new Item();

				item.setId(resultSet.getInt("id"));
				item.setQuantity(resultSet.getInt("quantity"));
				item.setUnitPrice(resultSet.getLong("price"));
				CakeDao cakeDao = new CakeDao();
				Cake cake = cakeDao.get(resultSet.getInt("cakeId"));
				item.setCake(cake);

				CartDao cartDao = new CartDao();
				Cart cart = cartDao.get(resultSet.getInt("cartId"));
				item.setCart(cart);
				itemList.add(item);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
		return itemList;
	}

	@Override
	public List<Item> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
