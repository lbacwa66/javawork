package com.stu.model;

public class Account {
	private int user_id;
	private String username;
	private String pwd;
	private int visible;
	
	public static int VISIBLE = 0;
	public static int UNVISIBLE = 1;
	
	
	public int getUser_id() {
		return user_id;
	}
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getVisible() {
		return visible;
	}
	public void setVisible(int visible) {
		this.visible = visible;
	}
}
