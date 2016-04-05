package com.questionboard.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("MySQL db driver isnot on classpath");
		}
	}
	
	private static Connection connection = null;

	public static synchronized Connection getConnection(String connectionString, String userName, String password)
			throws SQLException {
		if(connection == null) {
			connection = DriverManager.getConnection(connectionString, userName, password);
		}
		return connection;
	}
}
