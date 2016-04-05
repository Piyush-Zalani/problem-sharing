package com.questionboard.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.questionboard.exception.QuestionBoardException;
import com.questionboard.model.User;
import com.questionboard.util.ConnectionUtil;

public class UserDao {
	private ConnectionUtil connection;

	public UserDao() {
		connection = new ConnectionUtil();
	}

	public User getUser(String username, String password) throws ClassNotFoundException, SQLException {
		User user = null;

		PreparedStatement ps = connection
				.getPreparedStatement("select uid, username from registerUser where username=? and password=?");

		ps.setString(1, username);
		ps.setString(2, password);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			Long uid = rs.getLong(1);
			String firstName = null;
			String lastName = null;
			String email = null;

			user = new User(uid, firstName, lastName, username, email);
		}

		return user;
	}

	public User getUser(long userId) throws QuestionBoardException {
		User user = null;

		try {
			PreparedStatement ps = connection.getPreparedStatement("select username from registerUser where uid = ?");
			ps.setLong(1, userId);
			ps.executeQuery();

			ResultSet rs = ps.getResultSet();
			rs.next();
			String username = rs.getString(1);
			user = new User(userId, null, null, username, null);
		} catch (Exception e) {
			throw new QuestionBoardException(e.getMessage());
		}

		return user;
	}

	public int insertUser(User user) throws QuestionBoardException {
		int status = 0;
		try {
			PreparedStatement ps = connection
					.getPreparedStatement("insert into registerUser(username, email, password) values(?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			status = ps.executeUpdate();
		} catch (Exception e) {
			throw new QuestionBoardException(e.getMessage());
		}
		return status;
	}
}
