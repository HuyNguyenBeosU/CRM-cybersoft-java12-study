package com.java12.crmApp.service;

import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import com.java12.crmApp.dao.AuthDao;
import com.java12.crmApp.dto.UserLoginDto;

public class AuthService {
	private AuthDao dao;
	
	public AuthService() {
		dao = new AuthDao();
	}
	public boolean login(String email, String password) {
			UserLoginDto dto;
			try {
				dto = dao.findUserLogin(email);
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
			if(dto==null)
				return false;
			
			return BCrypt.checkpw(password, dto.getPassword());
		
	}
}
