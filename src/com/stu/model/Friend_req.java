package com.stu.model;

public class Friend_req {
	private int req_tor;
	private int req_tee;
	private int status;
	
	public static int WAITING = 0;
	public static int SUCCESS = 1;
	public static int REFUSED = 2;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getReq_tor() {
		return req_tor;
	}
	public void setReq_tor(int req_tor) {
		this.req_tor = req_tor;
	}
	public int getReq_tee() {
		return req_tee;
	}
	public void setReq_tee(int req_tee) {
		this.req_tee = req_tee;
	}
}
