package com.java12.crmApp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java12.crmApp.model.Role;
import com.java12.crmApp.service.RoleService;
import com.java12.crmApp.util.JspConst;
import com.java12.crmApp.util.ServletConst;
import com.java12.crmApp.util.UrlConst;

@WebServlet(name=ServletConst.ROLE,urlPatterns = {
		UrlConst.ROLE_DASHBOARD,
		UrlConst.ROLE_ADD,
		UrlConst.ROLE_UPDATE,
		UrlConst.ROLE_DELETE
})
public class RoleServlet extends HttpServlet {
	private RoleService roleService;
	@Override
	public void init() throws ServletException {
		super.init();
		roleService = new RoleService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case UrlConst.ROLE_DASHBOARD: {
			getRoleDashboard(req, resp);	
		}break;
		case UrlConst.ROLE_ADD: {
			req.getRequestDispatcher(JspConst.ROLE_ADD)
				.forward(req, resp);
		}break;
		case UrlConst.ROLE_UPDATE: {
			getRoleUpdate(req,resp);
			
		}break;
		case UrlConst.ROLE_DELETE: {
			getRoleDelete(req,resp);
		}break;
		default:
		}
	}
	private void getRoleUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idToUpdate = Integer.parseInt(req.getParameter("id"));
		
		Role roleToUpdate = roleService.findRoleById(idToUpdate);
		
		req.setAttribute("role", roleToUpdate);
			
		req.getRequestDispatcher(JspConst.ROLE_UPDATE)
		.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case UrlConst.ROLE_DASHBOARD: {
				
		}break;
		case UrlConst.ROLE_ADD: {
			postRoleAdd(req,resp);
		}break;
		case UrlConst.ROLE_UPDATE: {
			postRoleUpdate(req,resp);
		}break;
		case UrlConst.ROLE_DELETE: {
			
		}break;
		default:
		}
	}

	private void postRoleUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int idUpdate = Integer.parseInt(req.getParameter("id"));
		
		Role roleUpdate = roleService.findRoleById(idUpdate);
		
		roleUpdate = extractRoleFromReq(req);
		
		roleService.update(roleUpdate, idUpdate);
		
		resp.sendRedirect(req.getContextPath() + UrlConst.ROLE_DASHBOARD);
		
	}
	private Role extractRoleFromReq(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		return new Role(id, name, description);
	}
	private void postRoleAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		Role role = extractRoleFromReq(req);
//		System.out.printf("id :%d, name:%s, description:%s\n",id,name,description);
		roleService.addNewRole(role);
		
		resp.sendRedirect(req.getContextPath() + UrlConst.ROLE_DASHBOARD);
	}

	private void getRoleDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		roleService.deleteById(id);
		
		resp.sendRedirect(req.getContextPath() + UrlConst.ROLE_DASHBOARD);
		
	}

	private void getRoleDashboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Role> roles = roleService.findAllRole();
		
		if(roles != null && !roles.isEmpty())
		req.setAttribute("roles", roles);
			
		req.getRequestDispatcher(JspConst.ROLE_DASHBOARD)
		.forward(req, resp);
		
	}
	
}
