package com.questionboard.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public PreparedStatement getPreparedStatement(String query) throws ClassNotFoundException, SQLException {
		Class.forName(DbProperties.getValue(Constants.DRIVER_NAME));
		Connection connection = ConnectDB.getConnection(DbProperties.getValue(Constants.CONNECTION_STRING),
				DbProperties.getValue(Constants.USERNAME), DbProperties.getValue(Constants.PASSWORD));
		PreparedStatement ps = connection.prepareStatement(query);
		return ps;
	}
}
