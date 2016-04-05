package com.questionboard.exception;

public class QuestionBoardException extends RuntimeException {

		private static final long serialVersionUID = -7838985516165790288L;
	
	private String message;

	public QuestionBoardException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
