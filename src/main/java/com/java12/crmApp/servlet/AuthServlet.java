package com.java12.crmApp.servlet;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java12.crmApp.service.AuthService;
import com.java12.crmApp.util.JspConst;
import com.java12.crmApp.util.ServletConst;
import com.java12.crmApp.util.UrlConst;

@WebServlet(name=ServletConst.AUTH, urlPatterns = {
		UrlConst.AUTH_LOGIN,
		UrlConst.AUTH_LOGOUT,
		UrlConst.AUTH_FORGOT_PASSWORD,
		UrlConst.AUTH_SIGNUP
})
public class AuthServlet extends HttpServlet {
	private AuthService service;
	@Override
	public void init() throws ServletException {
		service = new AuthService();
		super.init();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
			case UrlConst.AUTH_LOGIN: {
				//cookie demo
				Cookie cookie = new Cookie("firstcookie", "ThisIsFirstCookie");
				cookie.setMaxAge(60);
				resp.addCookie(cookie);
				
				//kiem tra cookie-email
				Cookie[] cookies = req.getCookies();
				int cookiesCount = cookies == null ? 0:cookies.length;
				for (int i = 0; i < cookiesCount; i++) {
					if(cookies[i].getName().equals("email"))
						req.setAttribute("email", cookies[i].getValue());
				}	
				
				String status = String.valueOf(req.getSession().getAttribute("status"));
				if(!status.equals("null"))
					resp.sendRedirect(req.getContextPath() + UrlConst.HOME);
				else
					req.getRequestDispatcher(JspConst.AUTH_LOGIN)
						.forward(req, resp);
			}break;
			case UrlConst.AUTH_LOGOUT: {
				req.getSession().invalidate();
				resp.sendRedirect(req.getContextPath() + UrlConst.AUTH_LOGIN);
			}break;
	
		default:
			}
		}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case UrlConst.AUTH_LOGIN: {
			//cookie demo
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String remember = req.getParameter("rememberUsername");
			boolean isLogin = true;
	
			
			if(remember!=null) {
				Cookie cookie = new Cookie("email",email);
				cookie.setMaxAge(60*60*24*30);
				resp.addCookie(cookie);
			}
					
			System.out.printf("Email: %s,Remember: %s\n",email,remember);
			
	//		session demo
			HttpSession currentSession = req.getSession();
	//		String pingo = (String) currentSession.getAttribute("pingo");
	//		System.out.printf("\nPingo:%s",pingo);
			
			//logic dang nhap
			if(email==null||password==null)
				isLogin = false;
			
			else if(!service.login(email, password))
				isLogin = false;
			
			if(isLogin) {
				currentSession.setAttribute("status", "Logged in successfully");
				resp.sendRedirect(req.getContextPath() + UrlConst.HOME);
			}
			else 
				resp.sendRedirect(req.getContextPath() + UrlConst.AUTH_LOGIN);
		}break;
		case UrlConst.AUTH_LOGOUT: {
	
		}break;
	
		default:
		}
	}
}
