package com.questionboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionboard.dao.QuestionAnswerDao;
import com.questionboard.dao.QuestionAnswerDaoImpl;
import com.questionboard.exception.QuestionBoardException;
import com.questionboard.model.Question;

@WebServlet("/QuestionList")
public class QuestionList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private QuestionAnswerDao dao;
       
    public QuestionList() {
        super();
        dao = new QuestionAnswerDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws QuestionBoardException {
		try {
			List<Question> questions = dao.getQuestions();
			
			request.setAttribute("questions", questions);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("questionsList.jsp");
			requestDispatcher.forward(request, response);
		} catch (QuestionBoardException | ServletException | IOException e) {
			throw new QuestionBoardException(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws QuestionBoardException {
		doGet(request, response);
	}

}
