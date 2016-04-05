package com.questionboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionboard.dao.UserDao;
import com.questionboard.model.User;

@WebServlet("/RegistrationAction")
public class RegistrationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;
       
    public RegistrationAction() {
        super();
        userDao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User("", "", username, email, password);
		
		int status = userDao.insertUser(user);
		
		if(status == 1) {
			String message = "Registraton Successful. Please login to proceed.";
			response.sendRedirect("index.jsp?error=" + message);
		}
	}


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
