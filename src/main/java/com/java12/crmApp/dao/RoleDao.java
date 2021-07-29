package com.java12.crmApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.java12.crmApp.dbconnection.MySqlConnection;
import com.java12.crmApp.model.Role;

public class RoleDao {

	public List<Role> findAllRole() throws SQLException {
		List<Role> roles = new LinkedList<Role>();
		
		Connection connection = MySqlConnection.getConnection();
		String  query = "SELECT id, name, description from role";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Role role = new Role();
				role.setId(resultSet.getInt("id"));
				role.setName(resultSet.getString("name"));
				role.setDescription(resultSet.getString("description"));
				
				roles.add(role);
			}
		} catch (SQLException e) {
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
		
		return roles;
	}

	public void deleteById(int id) throws SQLException {
		
		Connection connection = MySqlConnection.getConnection();
		String query = "DELETE FROM role where id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, id);
			
			statement.execute();
		} catch (SQLException e) {
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
	}

	public void addNewRole(Role role) throws SQLException {
		Connection connection = MySqlConnection.getConnection();
		String query = "INSERT INTO role(id, name, description) VALUE (?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, role.getId());
			statement.setString(2, role.getName());
			statement.setString(3, role.getDescription());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
	}

	public Role findRoleById(int id) throws SQLException {
		Role role = null;
		
		Connection connection = MySqlConnection.getConnection();
		String query = "SELECT id, name, description FROM role where id =?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				role = new Role();
				role.setId(resultSet.getInt("id"));
				role.setName(resultSet.getString("name"));
				role.setDescription(resultSet.getString("description"));
			}
			
			
		} catch (SQLException e) {
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		}finally {
			connection.close();
		}
		
		return role;
	}

	public int update(Role roleUpdate, int idUpdate) throws SQLException {
		int resultSet = -1;
		String query = "UPDATE role SET name = ?, description = ? where id = ?";
		Connection connection = MySqlConnection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, roleUpdate.getName());
			statement.setString(2, roleUpdate.getDescription());
			statement.setInt(3, idUpdate);
			
			resultSet = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return resultSet;
	}

}
