package com.questionboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionboard.dao.UserDao;
import com.questionboard.model.User;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;

	public LoginController() {
		super();
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			final User user = userDao.getUser(username, password);
			if (user != null) {
				request.getSession().setAttribute("user", user);
				response.sendRedirect("QuestionList");
			} else {
				response.sendRedirect("index.jsp?error=Incorrect Username/Password");
			}
		} catch (Exception ex) {
			final String message = "Something went wrong in server."; 
			response.sendRedirect("index.jsp?error=" + message);
		}
	}

}
