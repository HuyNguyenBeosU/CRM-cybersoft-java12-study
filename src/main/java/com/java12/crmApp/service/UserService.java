package com.java12.crmApp.service;

import java.sql.SQLException;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.java12.crmApp.dao.UserDao;
import com.java12.crmApp.dto.UserCreateDto;
import com.java12.crmApp.dto.UserUpdateDto;
import com.java12.crmApp.model.User;
import com.java12.crmApp.util.PwdUtils;

public class UserService {
	private UserDao dao;
	
	public UserService() {
		dao = new UserDao();
	}
	
	public List<User> findAll(){
		List<User> users = null;
		try {
			users = dao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	public UserUpdateDto findUserUpdateDtoById(int id) {
		UserUpdateDto user = null;
		try {
			user = dao.findUserUpdateDtoById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public void deleteUserById(int id) {
		
		try {
			dao.deleteUserById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		};
		
	}

	public void add(UserCreateDto dto) {
		String hashedPwd = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
		dto.setPassword(hashedPwd);
		try {
			dao.add(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public int update(UserUpdateDto userToUpdate, int idToUpdate) {
		String hashedPwd = BCrypt.hashpw(userToUpdate.getPassword(), BCrypt.gensalt());
		userToUpdate.setPassword(hashedPwd);
		try {
			return dao.update(userToUpdate, idToUpdate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;	
	}


}
