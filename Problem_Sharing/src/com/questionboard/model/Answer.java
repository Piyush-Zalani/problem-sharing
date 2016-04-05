package com.questionboard.model;

public class Answer {
	private long answerId;
	private long questionId;
	private long userId;
	private String AnswerDesc;
	private String answerDate;
	private String user;
	
	public long getAnswerId() {
		return answerId;
	}
	public void setAnswerId(long answerId) {
		this.answerId = answerId;
	}
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getAnswerDesc() {
		return AnswerDesc;
	}
	public void setAnswerDesc(String answerDesc) {
		AnswerDesc = answerDesc;
	}
	public String getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	public Answer(long answerId, long questionId, long userId, String answerDesc, String answerDate, String user) {
		super();
		this.answerId = answerId;
		this.questionId = questionId;
		this.userId = userId;
		AnswerDesc = answerDesc;
		this.answerDate = answerDate;
		this.user = user;
	}
}
