package com.java12.crmApp.service;

import java.sql.SQLException;
import java.util.List;

import com.java12.crmApp.dao.ProjectDao;
import com.java12.crmApp.model.Project;

public class ProjectService {
	private ProjectDao dao;
	
	public ProjectService() {
		dao = new ProjectDao();
	}

	public List<Project> findAllProject() {
		
		try {
			return dao.findAllProject();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
