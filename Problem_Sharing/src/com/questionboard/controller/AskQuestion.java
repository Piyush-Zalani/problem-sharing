package com.questionboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionboard.dao.QuestionAnswerDao;
import com.questionboard.dao.QuestionAnswerDaoImpl;
import com.questionboard.model.User;

@WebServlet("/AskQuestion")
public class AskQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private QuestionAnswerDao dao;

	public AskQuestion() {
		super();
		dao = new QuestionAnswerDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String questionTag = request.getParameter("questionTag");
		String questionDesc = request.getParameter("questionDesc");
		
		User user = (User)request.getSession().getAttribute("user");
		
		int status = dao.insertQuestion(questionTag, questionDesc, user.getUserId());
		if(status == 1) {
			response.sendRedirect("QuestionList");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
