package com.java12.crmApp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java12.crmApp.util.JspConst;
import com.java12.crmApp.util.ServletConst;
import com.java12.crmApp.util.UrlConst;

@WebServlet(name=ServletConst.TASK,urlPatterns = {
		UrlConst.TASK_DASHBOARD,
		UrlConst.TASK_ADD,
		UrlConst.TASK_UPDATE,
		UrlConst.TASK_DELETE
})
public class TaskServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case UrlConst.TASK_DASHBOARD: {
			req.getRequestDispatcher(JspConst.TASK_DASHBOARD)
				.forward(req, resp);
		}break;
		case UrlConst.TASK_ADD: {
			req.getRequestDispatcher(JspConst.TASK_ADD)
				.forward(req, resp);
		}break;
		case UrlConst.TASK_UPDATE: {
			req.getRequestDispatcher(JspConst.TASK_UPDATE)
				.forward(req, resp);
		}break;
		case UrlConst.TASK_DELETE: {
			
		}break;
		default:
		}
	}
}
