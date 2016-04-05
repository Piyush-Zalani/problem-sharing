package com.questionboard.model;

import java.util.Date;

public class Question {
	private long questionId;
	
	private String questionTag;
	
	private String description;
	
	private Date questionDate;
	
	private String user;

	public Question(long questionId, String questionTag, String description, Date questionDate, String user) {
		super();
		this.questionId = questionId;
		this.questionTag = questionTag;
		this.description = description;
		this.questionDate = questionDate;
		this.user = user;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getQuestionTag() {
		return questionTag;
	}

	public void setQuestionTag(String questionTag) {
		this.questionTag = questionTag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getQuestionDate() {
		return questionDate;
	}

	public void setQuestionDate(Date questionDate) {
		this.questionDate = questionDate;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}
