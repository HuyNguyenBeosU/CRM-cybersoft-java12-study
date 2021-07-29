package com.java12.crmApp.service;

import java.sql.SQLException;
import java.util.List;

import com.java12.crmApp.dao.RoleDao;
import com.java12.crmApp.model.Role;

public class RoleService {

	private RoleDao dao;
	
	public RoleService() {
		dao = new RoleDao();
	}

	public List<Role> findAllRole() {
		List<Role> roles = null;
		
		try {
			roles = dao.findAllRole();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return roles;
	}
	public Role findRoleById(int id) {
		Role role = new Role();
		try {
			role = dao.findRoleById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}

	public void deleteById(int id) {
		try {
			dao.deleteById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void addNewRole(Role role) {
		try {
			dao.addNewRole(role);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public int update(Role roleUpdate, int idUpdate) {
		try {
			return dao.update(roleUpdate,idUpdate);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
		
	}
	
}
