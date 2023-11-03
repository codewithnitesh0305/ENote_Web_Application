package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.tribes.util.TcclThreadFactory;

import com.User.Post;
import com.User.userDetails;
import com.mysql.cj.protocol.Resultset;

public class PostDAO {
private Connection connection;

public PostDAO(Connection connection) {
	super();
	this.connection = connection;
}
//Insert notes in the database
public boolean addNotes(String title, String content, int id) {
	boolean f = false;
	try {
		String query = "insert into post(title,content,User_Id) values(?,?,?)";
		PreparedStatement pStatement = connection.prepareStatement(query);
		pStatement.setString(1, title);
		pStatement.setString(2, content);
		pStatement.setInt(3, id);
		int i = pStatement.executeUpdate();
		if(i == 1) {
			f = true;
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return f;
	}
	
//Retrive Notes from Database
	public List<Post> getData(int id){
		List<Post> list =  new ArrayList<Post>();
		Post post = null;
		try {
			String query = "select * from post where User_Id = ?";
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, id);
			
			ResultSet resultset = pStatement.executeQuery();
			while(resultset.next()) {
				post=new Post();
				post.setId(resultset.getInt(1));
				post.setTitle(resultset.getString(2));
				post.setContent(resultset.getString(3));
				list.add(post);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
		
	}
	
	public Post getDataById(int noteId) {
		Post post = null;
		try {
			String query = "select * from post where id = ?";
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, noteId);
			ResultSet resultset = pStatement.executeQuery();
			
			if (resultset.next()) {
				post = new Post();
				post.setId(resultset.getInt(1));
				post.setTitle(resultset.getString(2));
				post.setContent(resultset.getString(3));
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return post;
	}
	
	public boolean postUpdate(int nid , String title , String content) {
		boolean f = false;
		try {
			String query = "update post set title = ? , content = ? where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, content);
			preparedStatement.setInt(3, nid);
			int i = preparedStatement.executeUpdate();
			if(i == 1) {
				f = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean detletNotes(int nid) {
		boolean f = false;
		try {
			String query = "Delete from post where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, nid);
			int i =	preparedStatement.executeUpdate();
			if (f) {
				f = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
		
	}
}
