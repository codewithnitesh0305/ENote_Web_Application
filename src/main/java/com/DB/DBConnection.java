package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection connection = null;
	public static Connection getConnection() {
		try {
			
				String url = "jdbc:mysql://localhost:3306/enotes";
				String userName = "root";
				String password = "Nitesh@0305";
//				Class.forName("com.mysql.cj.jdbc.Driver");

				connection = DriverManager.getConnection(url,userName,password);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
		

	}
}
