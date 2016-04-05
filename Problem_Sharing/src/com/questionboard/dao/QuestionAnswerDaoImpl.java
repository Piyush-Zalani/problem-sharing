package com.questionboard.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.questionboard.exception.QuestionBoardException;
import com.questionboard.model.Answer;
import com.questionboard.model.Question;
import com.questionboard.util.ConnectionUtil;

public class QuestionAnswerDaoImpl implements QuestionAnswerDao {
	private ConnectionUtil connection = null;

	public QuestionAnswerDaoImpl() {
		connection = new ConnectionUtil();
	}

	@Override
	public List<Question> getQuestions() throws QuestionBoardException {
		List<Question> questions = new ArrayList<Question>();
		try {
			PreparedStatement preparedStatement = connection
					.getPreparedStatement("SELECT q.qid, q.questiontag, q.questiondesc, q.QuestionDate, u.username FROM Question q INNER JOIN registeruser u ON q.USER_ID = u.uid ORDER BY qid DESC");
			preparedStatement.executeQuery();
			ResultSet rs = preparedStatement.getResultSet();
			while (rs.next()) {
				Long id = rs.getLong(1);
				String questionTag = rs.getString(2);
				String description = rs.getString(3);
				java.sql.Timestamp questionDate = rs.getTimestamp(4);
				String username = rs.getString(5);

				Question question = new Question(id, questionTag, description, questionDate, username);
				questions.add(question);
			}
		} catch (Exception e) {
			throw new QuestionBoardException(e.getMessage());
		}

		return questions;
	}

	@Override
	public Question getQuestion(Long questionId) throws QuestionBoardException {
		Question question = null;
		try {
			PreparedStatement preparedStatement = connection.getPreparedStatement(
					"SELECT q.qid, q.questiontag, q.questiondesc, q.QuestionDate, u.username FROM Question q INNER JOIN registeruser u ON q.USER_ID = u.uid WHERE q.qid = ? ORDER BY qid DESC");
			preparedStatement.setLong(1, questionId);
			preparedStatement.executeQuery();
			ResultSet rs = preparedStatement.getResultSet();

			rs.next();
			String questionTag = rs.getString(2);
			String description = rs.getString(3);
			java.sql.Timestamp questionDate = rs.getTimestamp(4);

			question = new Question(questionId, questionTag, description, questionDate, null);
		} catch (Exception e) {
			throw new QuestionBoardException(e.getMessage());
		}
		return question;
	}

	@Override
	public List<Answer> getAnswerForQuestion(Long questionId) throws QuestionBoardException {
		List<Answer> answers = new ArrayList<Answer>();

		try {
			PreparedStatement preparedStatement = connection
					.getPreparedStatement("SELECT a.aid, a.uid, a.description, a.answertime, r.username FROM answer a INNER JOIN registeruser r ON a.uid = r.uid WHERE qid = ? order by aid desc");
			preparedStatement.setLong(1, questionId);
			preparedStatement.executeQuery();
			ResultSet rs = preparedStatement.getResultSet();
			while (rs.next()) {
				Long answerId = rs.getLong(1);
				Long userId = rs.getLong(2);
				String description = rs.getString(3);
				java.sql.Timestamp answerDate = rs.getTimestamp(4);
				String username = rs.getString(5);

				Answer answer = new Answer(answerId, userId, questionId, description, answerDate.toString(), username);
				answers.add(answer);
			}
		} catch (Exception e) {
			throw new QuestionBoardException(e.getMessage());
		}

		return answers;
	}

	@Override
	public int insertQuestion(String questionTag, String questionDesc, Long userId) throws QuestionBoardException {
		int status = 0;
		Date questionDate = new Date();

		try {
			PreparedStatement ps = connection
					.getPreparedStatement("insert into question(questiontag, questiondesc, QuestionDate, USER_ID) values(?,?,?,?)");

			ps.setString(1, questionTag);
			ps.setString(2, questionDesc);
			ps.setTimestamp(3, new java.sql.Timestamp(questionDate.getTime()));
			ps.setLong(4, userId);

			status = ps.executeUpdate();
		} catch (Exception e) {
			throw new QuestionBoardException(e.getMessage());
		}

		return status;
	}

	@Override
	public int insertAnswer(Long questionId, String answer, Long userId) throws QuestionBoardException {
		int status = 0;
		Date questionDate = new Date();

		try {
			PreparedStatement ps = connection
					.getPreparedStatement("insert into answer(qid, uid, description, answertime) values(?,?,?,?)");

			ps.setLong(1, questionId);
			ps.setLong(2, userId);
			ps.setString(3, answer);
			ps.setTimestamp(4, new java.sql.Timestamp(questionDate.getTime()));

			status = ps.executeUpdate();
		} catch (Exception e) {
			throw new QuestionBoardException(e.getMessage());
		}

		return status;
	}

}
