package com.stu.model;

public class Friends {
	private int user_id_1;
	private int user_id_2;
	private int status;
	
	public static int BLOCKED = 1;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getUser_id_1() {
		return user_id_1;
	}
	public void setUser_id_1(int user_id_1) {
		this.user_id_1 = user_id_1;
	}
	public int getUser_id_2() {
		return user_id_2;
	}
	public void setUser_id_2(int user_id_2) {
		this.user_id_2 = user_id_2;
	}
}
