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
import com.questionboard.model.Answer;
import com.questionboard.model.Question;

@WebServlet("/QuestionPage")
public class QuestionPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private QuestionAnswerDao dao;
       
    public QuestionPage() {
        super();
        dao = new QuestionAnswerDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Long id = Long.valueOf(request.getParameter("id"));
			if(id != null && id != 0) {
				Question question = dao.getQuestion(id);
				
				List<Answer> answers = dao.getAnswerForQuestion(id);
				
				request.setAttribute("question", question);
				request.setAttribute("answers", answers);
			} else {
				// send an error jsp.
			}
		} catch (QuestionBoardException e) {
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("questionPage.jsp");
		requestDispatcher.forward(request, response);		
	}

}
