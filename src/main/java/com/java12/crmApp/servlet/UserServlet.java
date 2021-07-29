package com.java12.crmApp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java12.crmApp.dto.UserCreateDto;
import com.java12.crmApp.dto.UserUpdateDto;
import com.java12.crmApp.model.User;
import com.java12.crmApp.service.UserService;
import com.java12.crmApp.util.JspConst;
import com.java12.crmApp.util.ServletConst;
import com.java12.crmApp.util.UrlConst;

@WebServlet(name=ServletConst.USER,urlPatterns = {
		UrlConst.USER_ADD,
		UrlConst.USER_DASHBOARD,
		UrlConst.USER_PROFILE,
		UrlConst.USER_DELETE,
		UrlConst.USER_UPDATE,
})
public class UserServlet extends HttpServlet {
	private UserService service;
	@Override
	public void init() throws ServletException {
		super.init();
		service = new UserService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case UrlConst.USER_DASHBOARD: {
			getUserDasboard(req,resp);
		}break;
		case UrlConst.USER_PROFILE: {
			getUserProfile(req,resp);
		}break;
		case UrlConst.USER_UPDATE: {
			getUserUpdate(req,resp);
		}break;
		case UrlConst.USER_ADD: {
			getUserAdd(req,resp);		
		}break;
		case UrlConst.USER_DELETE: {
			getUserDelete(req,resp);
		}break;
		default:
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case UrlConst.USER_DASHBOARD: {
			
		}break;
		case UrlConst.USER_PROFILE: {
			
		}break;
		case UrlConst.USER_UPDATE: {
			postUserUpdate(req,resp);
		}break;
		case UrlConst.USER_ADD: {
			postUserAdd(req,resp);		
		}break;
		case UrlConst.USER_DELETE: {
			
		}break;
		default:
		}
	}
	private void postUserAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			UserCreateDto dto = extractDtoFromReq(req);
			
			service.add(dto);
			
			resp.sendRedirect(req.getContextPath() + UrlConst.USER_DASHBOARD);
	}
	private UserCreateDto extractDtoFromReq(HttpServletRequest req) {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			int roleId = Integer.parseInt(req.getParameter("role"));
		return new UserCreateDto(email, password, name, address, phone, roleId);
	}
	private void getUserDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		service.deleteUserById(id);
		
		resp.sendRedirect(req.getContextPath() + UrlConst.USER_DASHBOARD);
		
	}
	private void getUserProfile(HttpServletRequest req, HttpServletResponse resp) {
		
		
	}
	private void getUserAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JspConst.USER_ADD)
			.forward(req, resp);
		
	}
	private void getUserUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idToUpdate = Integer.parseInt(req.getParameter("id"));
		
		UserUpdateDto userToUpdate = service.findUserUpdateDtoById(idToUpdate);
		
		
		req.setAttribute("user", userToUpdate);
		
		req.getRequestDispatcher(JspConst.USER_UPDATE)
			.forward(req, resp);	
	}
	private void postUserUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int idToUpdate = Integer.parseInt(req.getParameter("id"));
		
		UserUpdateDto userToUpdate = service.findUserUpdateDtoById(idToUpdate);
		userToUpdate.setEmail(req.getParameter("email"));
		userToUpdate.setPassword(req.getParameter("password"));
		userToUpdate.setName(req.getParameter("name"));
		userToUpdate.setPhone(req.getParameter("phone"));
		userToUpdate.setAddress(req.getParameter("address"));
		userToUpdate.setRoleId(Integer.parseInt(req.getParameter("role")));

		service.update(userToUpdate, idToUpdate);
		
		resp.sendRedirect(req.getContextPath() + UrlConst.USER_DASHBOARD);	
	}

	private void getUserDasboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = service.findAll();
		
		if(users != null && !users.isEmpty())
			req.setAttribute("users", users);
		
		req.getRequestDispatcher(JspConst.USER_DASHBOARD)
			.forward(req, resp);	
	}
	
}
