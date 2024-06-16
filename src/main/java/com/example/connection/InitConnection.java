package com.example.connection;

import java.sql.*;

public class InitConnection {
	
	public static Connection initializeConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost/grey_goose";
        String username = "root";
        String password = "5246";
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	}
}
