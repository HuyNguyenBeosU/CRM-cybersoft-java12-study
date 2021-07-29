package com.java12.crmApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.java12.crmApp.dbconnection.MySqlConnection;
import com.java12.crmApp.model.Project;
import com.java12.crmApp.model.User;

public class ProjectDao {

	public List<Project> findAllProject() throws SQLException {
		List<Project> projects = new LinkedList<>();
		
		
		Connection connection = MySqlConnection.getConnection();
		String query = "SELECT p.id as id, p.name as name, p.description as description, "
				+ "p.start_date as start_date, p.end_date as end_Date, u.id as owner, "
				+ "u.email as user_email, u.password as user_password, u.name as user_name, u.address as user_address, u.phone as user_phone, "
				+ "u.role_id as user_role_id FROM project p, user u WHERE p.owner = u.id";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Project project = new Project();
				
				project.setId(resultSet.getInt("id"));
				project.setName(resultSet.getString("name"));
				project.setDescription(resultSet.getString("description"));
				project.setStartDate(resultSet.getDate("start_date"));
				project.setEndDate(resultSet.getDate("end_date"));
				
				User user = new User();
				user.setId(resultSet.getInt("owner"));
				user.setEmail(resultSet.getString("user_email"));
				user.setPassword(resultSet.getString("user_password"));
				user.setName(resultSet.getNString("user_name"));
				user.setAddress(resultSet.getNString("user_address"));
				user.setPhone(resultSet.getString("user_phone"));
				//user.setRole(resultSet.getInt("user_role_id"));
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		}finally {
			connection.close();
		}
		
		return projects;
	}

}
