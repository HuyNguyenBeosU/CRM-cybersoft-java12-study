package com.java12.crmApp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java12.crmApp.util.UrlConst;

@WebFilter(urlPatterns = {
		UrlConst.ROOT
})
public class EncodingFilter implements Filter {
	private int requestCount = 1;
	
@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
	
	HttpServletRequest req = (HttpServletRequest) request;
	HttpServletResponse resp = (HttpServletResponse) response;
	int count = requestCount++;
	//xu ly request
	req.setCharacterEncoding("UTF-8");
	chain.doFilter(request, response);
	//xu ly response
	resp.setCharacterEncoding("UTF-8");	
	}
}
