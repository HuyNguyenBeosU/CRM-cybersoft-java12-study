package com.java12.crmApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.java12.crmApp.dbconnection.MySqlConnection;
import com.java12.crmApp.dto.UserCreateDto;
import com.java12.crmApp.dto.UserUpdateDto;
import com.java12.crmApp.model.Role;
import com.java12.crmApp.model.User;


public class UserDao {

	public List<User> findAll() throws SQLException {
		List<User> users = new LinkedList<User>();
		List<Role> roles = new ArrayList<Role>();
		
		Connection connection = MySqlConnection.getConnection();
		String query =	"SELECT u.id as id, u.name as name, u.email as email, "
				+ "u.phone as phone, r.id as role_id, r.name as role_name, r.description as role_description "
				+ "FROM user u, role r WHERE u.role_id = r.id";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				User user = new User();
				
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setPhone(resultSet.getString("phone"));
				
				int roleId = resultSet.getInt("role_id");
				Role role = getRoleFromList(roles,roleId);
				if(role == null) {
					role = new Role();
					role.setId(resultSet.getInt("role_id"));
					role.setName(resultSet.getString("role_name"));
					role.setDescription(resultSet.getString("role_description"));
					roles.add(role);
				}
				
				
				user.setRole(role);
				users.add(user);
			}
			
		} catch (SQLException e) {
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return users;
	}
	public UserUpdateDto  findUserUpdateDtoById(int id) throws SQLException  {
		Connection connection = MySqlConnection.getConnection();
		UserUpdateDto userUpdateDto = null;
		String query = "SELECT id, email, password, name, address, phone, role_id FROM user WHERE id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				userUpdateDto = new UserUpdateDto();
				userUpdateDto.setId(resultSet.getInt("id"));
				userUpdateDto.setEmail(resultSet.getString("email"));
				userUpdateDto.setPassword(resultSet.getString("password"));
				userUpdateDto.setName(resultSet.getString("name"));
				userUpdateDto.setAddress(resultSet.getString("address"));
				userUpdateDto.setPhone(resultSet.getString("phone"));
				userUpdateDto.setRoleId(resultSet.getInt("role_id"));
			}
			
			
		} catch (SQLException e) {
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		}	finally {
			connection.close();
		}
		
		return userUpdateDto;
	
	}
	
	
	public void deleteUserById(int id) throws SQLException {
		String query = "DELETE FROM user WHERE id = ?";
		Connection connection = MySqlConnection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		}finally {
			connection.close();
		}
	}
	
	
	
	public void add(UserCreateDto dto) throws SQLException {
		String query = "INSERT INTO user(email, password, name, address, phone, role_id)"
				+ "VALUES(?,?,?,?,?,?)";
		Connection connection = MySqlConnection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, dto.getEmail());
			statement.setString(2, dto.getPassword());
			statement.setString(3, dto.getName());
			statement.setString(4, dto.getAddress());
			statement.setString(5, dto.getPhone());
			statement.setInt(6, dto.getRoleId());
			statement.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		}finally {
			connection.close();
		}
		
	}

	public int update(UserUpdateDto userToUpdate, int idToUpdate) throws SQLException {
		int resultSet = -1;
		String query = "UPDATE user SET email = ?, password = ?, name = ?, phone = ?, address = ?, role_id = ? WHERE id = ?";
		Connection connection = MySqlConnection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, userToUpdate.getEmail());
			statement.setString(2, userToUpdate.getPassword());
			statement.setString(3, userToUpdate.getName());
			statement.setString(4, userToUpdate.getPhone());
			statement.setString(5, userToUpdate.getAddress());
			statement.setInt(6, userToUpdate.getRoleId());
			statement.setInt(7, idToUpdate);
			
			resultSet = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return resultSet;
		
	}
	private Role getRoleFromList(List<Role> roles, int roleId) {
		for(Role role :roles) {
			if (role.getId() == roleId)
				return role;
		}
		
		return null;
	}

}
