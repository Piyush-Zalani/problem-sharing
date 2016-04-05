package com.questionboard.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.questionboard.model.User;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {
	private String message = "Login first";
	private String LOGIN_ACTION_URI;
	private final String REGISTRATION_ACTION_URI = "";
	private String LOGIN_JSP = "index.jsp";
	private String[] ignoreList = {".css", ".js"};
	
	public AuthenticationFilter() {
		LOGIN_ACTION_URI = "LoginController";
	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		
		User user = (User)req.getSession().getAttribute("user");
		
		if (user != null || req.getRequestURI().contains(LOGIN_ACTION_URI) ||  req.getRequestURI().contains(REGISTRATION_ACTION_URI) ||
				req.getRequestURI().contains(LOGIN_JSP) || isIgnore(req.getRequestURI())) {
			chain.doFilter(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp?error=" + message);
			rd.include(request, response);
		}
	}
	
	public boolean isIgnore(String url) {
		boolean ignore = false;
		
		for(String extention : ignoreList) {
			if(url.endsWith(extention)) {
				ignore = true;
				break;
			}
		}
		
		return ignore;
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
