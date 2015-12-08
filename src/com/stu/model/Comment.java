package com.stu.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment {
	private int post_id;
	private int user_id;
	private String comment_date;
	private String content;
	
	public String getComment_date() {
		return comment_date;
	}
	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
	}
	public void setComment_date(Date date) {
		this.comment_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPost_id() {
		return post_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
