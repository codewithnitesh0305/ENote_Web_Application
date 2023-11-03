package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.catalina.User;

import com.User.userDetails;
import com.mysql.cj.protocol.Resultset;

public class userDAO {
	private Connection connection;

	public userDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public boolean addUser(userDetails user) {
		boolean f = false;
		try {
			String query = "Insert into user(Name,Email,Password) values(?,?,?)";
			
			PreparedStatement pstmPreparedStatement = connection.prepareStatement(query);
			
			pstmPreparedStatement.setString(1, user.getName());
			pstmPreparedStatement.setString(2, user.getEmail());
			pstmPreparedStatement.setString(3, user.getPassword());
			
			int i = pstmPreparedStatement.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}
	
	public userDetails loginUser(userDetails user) {
		userDetails user1 = null;
		try {
			String query = "Select * from user where email = ? and password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			
			ResultSet rsResultset = preparedStatement.executeQuery();
			if (rsResultset.next()) {
				user1 = new userDetails();
				user1.setId(rsResultset.getInt("id"));
				user1.setName(rsResultset.getString("name"));
				user1.setEmail(rsResultset.getString("email"));
				user1.setPassword(rsResultset.getString("password"));
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return user1;
	}
}
