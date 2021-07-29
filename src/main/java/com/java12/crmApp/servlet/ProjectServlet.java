package com.java12.crmApp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java12.crmApp.model.Project;
import com.java12.crmApp.service.ProjectService;
import com.java12.crmApp.util.JspConst;
import com.java12.crmApp.util.ServletConst;
import com.java12.crmApp.util.UrlConst;

@WebServlet(name=ServletConst.PROJECT,urlPatterns = {
		UrlConst.PROJECT_DASHBOARD,
		UrlConst.PROJECT_ADD,
		UrlConst.PROJECT_DELETE,
		UrlConst.PROJECT_MANAGE,
		UrlConst.PROJECT_STAFF,
		UrlConst.PROJECT_STAFF_ADD,
		UrlConst.PROJECT_STAFF_REMOVE,
		UrlConst.PROJECT_UPDATE
})
public class ProjectServlet extends HttpServlet{
	private ProjectService service;
	@Override
	public void init() throws ServletException {
		super.init();
		service = new ProjectService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case UrlConst.PROJECT_DASHBOARD: {
			getProjectDashboard(req,resp);
			
			}break;
		case UrlConst.PROJECT_MANAGE: {
			
			
			}break;
		case UrlConst.PROJECT_ADD: {
			
			req.getRequestDispatcher(JspConst.PROJECT_ADD)
			.forward(req, resp);
			}break;
		case UrlConst.PROJECT_UPDATE: {
			
			
			}break;
		case UrlConst.PROJECT_DELETE: {
			
			
			}break;
		case UrlConst.PROJECT_STAFF: {
			
			
		}break;
		case UrlConst.PROJECT_STAFF_ADD: {
			
			
		}break;
		case UrlConst.PROJECT_STAFF_REMOVE: {
			
			
		}break;
		default:
			
		}//end switch
	}//end doGet
	private void getProjectDashboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Project> projects = service.findAllProject();
		
		if(projects !=null)
			req.setAttribute("projects", projects);
		
		req.getRequestDispatcher(JspConst.PROJECT_DASHBOARD)
			.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
