package com.questionboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionboard.dao.QuestionAnswerDao;
import com.questionboard.dao.QuestionAnswerDaoImpl;

@WebServlet("/PostAnswer")
public class PostAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private QuestionAnswerDao questionAnswerDao;

	public PostAnswer() {
        super();
        questionAnswerDao = new QuestionAnswerDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long questionId = Long.valueOf(request.getParameter("questionId"));
		String answer = request.getParameter("answer");
		Long userId = Long.valueOf(request.getParameter("userId")); 
		questionAnswerDao.insertAnswer(questionId, answer, userId);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
