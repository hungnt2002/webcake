package com.shopwebcake.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopwebcake.dao.IUserDao;
import com.shopwebcake.jdbc.JDBCConnection;
import com.shopwebcake.model.User;

public class UserDao extends JDBCConnection implements IUserDao {

	@Override
	public void insert(User user) {

		String sql = "INSERT INTO tblUser ( username, password,fullName,roleId,gmail) VALUES (?,?,?,?,?)";
		java.sql.Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCConnection.getJDBCConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, statement.RETURN_GENERATED_KEYS);

			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFullName());
			statement.setInt(4, user.getRoleId());
			statement.setString(5, user.getGmail());

			statement.executeUpdate();
			connection.commit();

		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

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
	public void edit(User user) {
		String sql = "UPDATE tblUser SET username = ? , password = ?, fullName = ?,roleId=?, gmail=? WHERE userId=? ";
		java.sql.Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCConnection.getJDBCConnection();
			connection.setAutoCommit(false);

			statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFullName());
			statement.setInt(4, user.getRoleId());
			statement.setInt(5, user.getUserId());
			statement.setString(6, user.getGmail());
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
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
		String sql = "DELETE FROM tblUser WHERE userId=?";
		java.sql.Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = JDBCConnection.getJDBCConnection();
			connection.setAutoCommit(false);

			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {

			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
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
	public User get(String userName) {
		String sql = "SELECT * FROM tblUser WHERE userName=?";
		java.sql.Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		User user = new User();

		try {
			connection = JDBCConnection.getJDBCConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, userName);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				user.setUserId(resultSet.getInt("userId"));
				user.setUserName(resultSet.getString("userName"));
				user.setPassword(resultSet.getString("password"));
				user.setFullName(resultSet.getString("fullName"));
				user.setRoleId(resultSet.getInt("roleId"));
				user.setGmail(resultSet.getString("gmail"));

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
		return user;

	}

	@Override
	public User get(int id) {
		String sql = "SELECT * FROM tblUser WHERE userId=?";
		java.sql.Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		User user = new User();

		try {
			connection = JDBCConnection.getJDBCConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				user.setUserId(resultSet.getInt("userId"));
				user.setUserName(resultSet.getString("userName"));
				user.setPassword(resultSet.getString("password"));
				user.setFullName(resultSet.getString("fullName"));
				user.setRoleId(resultSet.getInt("roleId"));
				user.setGmail(resultSet.getString("gmail"));

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
		return user;

	}

	@Override
	public List<User> getAll() {
		List<User> userList = new ArrayList<User>();
		String sql = "SELECT * FROM tblUser";
		java.sql.Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCConnection.getJDBCConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				User user = new User();
				user.setUserId(resultSet.getInt("userId"));
				user.setUserName(resultSet.getString("userName"));
				user.setPassword(resultSet.getString("password"));
				user.setFullName(resultSet.getString("fullName"));
				user.setRoleId(resultSet.getInt("roleId"));
				user.setGmail(resultSet.getString("gmail"));

				userList.add(user);
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
		return userList;

	}

	@Override
	public List<User> search(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkExistEmail(String gmail) {

		boolean duplicate = false;
		String sql = "SELECT * FROM tblUser WHERE gmail=?";

		java.sql.Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {

			connection = JDBCConnection.getJDBCConnection();
			statement = connection.prepareStatement(sql);

			statement.setString(1, gmail);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				duplicate = true;
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
				e.printStackTrace();
			}
			return duplicate;
		}
	}

	@Override
	public boolean checkUsername(String username) {
		boolean duplicate = false;
		String sql = "SELECT * FROM tblUser WHERE username=?";

		java.sql.Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCConnection.getJDBCConnection();
			statement = connection.prepareStatement(sql);

			statement.setString(1, username);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				duplicate = true;
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
				e.printStackTrace();
			}

		}
		return duplicate;
	}

}
