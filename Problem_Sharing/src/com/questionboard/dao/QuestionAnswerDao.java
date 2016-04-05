package com.questionboard.dao;

import java.util.List;

import com.questionboard.exception.QuestionBoardException;
import com.questionboard.model.Answer;
import com.questionboard.model.Question;

public interface QuestionAnswerDao {
	public List<Question> getQuestions() throws QuestionBoardException;
	
	public Question getQuestion(Long questionId) throws QuestionBoardException;
	
	public List<Answer> getAnswerForQuestion(Long questionId) throws QuestionBoardException;

	public int insertQuestion(String questionTag, String questionDesc, Long userId) throws QuestionBoardException;

	public int insertAnswer(Long questionId, String answer, Long userId) throws QuestionBoardException;
}
