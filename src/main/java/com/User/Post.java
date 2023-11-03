package com.User;

import java.util.Date;

public class Post {
	private int id;
	private String title;
	private String content;
	
	private userDetails user;
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(int id, String title, String content,  userDetails user) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}



	public userDetails getUser() {
		return user;
	}

	public void setUser(userDetails user) {
		this.user = user;
	}
	
	
}
