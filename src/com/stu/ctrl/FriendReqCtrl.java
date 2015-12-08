package com.stu.ctrl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.stu.model.Account;
import com.stu.model.Comment;
import com.stu.model.Friend_req;

public class FriendReqCtrl {
	public static void addfriendReq(int req_tor, int req_tee) {
		Connection con = SqlCtrl.getCon();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = con.prepareStatement("select REQ_TOR, REQ_TEE from friend_req where REQ_TOR=? AND REQ_TEE=?");
			ps.setInt(1, req_tor);
			ps.setInt(2, req_tee);
			resultSet = ps.executeQuery();
			if (resultSet.next() == false) {;
				ps = con.prepareStatement("INSERT INTO friend_req(REQ_TOR, REQ_TEE, STATUS) VALUES(?, ?, ?)");
				ps.setInt(1, req_tor);
				ps.setInt(2, req_tee);
				ps.setInt(3, Friend_req.WAITING);
				ps.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlCtrl.closeStatement(ps);
		SqlCtrl.closeCon(con);
	}
	
	public static List<Account> getfriendReqByTee(int req_tee) {
		Connection con = SqlCtrl.getCon();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		List<Account> list = new ArrayList<>();
		try {
			ps = con.prepareStatement("select REQ_TOR from friend_req where REQ_TEE=? and status=?");
			ps.setInt(1, req_tee);
			ps.setInt(2, Friend_req.WAITING);
			resultSet = ps.executeQuery();
			while(resultSet.next()) {
				Account account = new Account();
				account.setUser_id(resultSet.getInt("REQ_TOR"));
				account = AccountCtrl.getAccountById(account.getUser_id());
				list.add(account);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlCtrl.closeStatement(ps);
		SqlCtrl.closeCon(con);
		return list;
	}
	
	public static List<Account> getrefuseFriendReqByTee(int req_tee) {
		Connection con = SqlCtrl.getCon();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		List<Account> list = new ArrayList<>();
		try {
			ps = con.prepareStatement("select REQ_TOR from friend_req where REQ_TEE=? and status=?");
			ps.setInt(1, req_tee);
			ps.setInt(2, Friend_req.REFUSED);
			resultSet = ps.executeQuery();
			while(resultSet.next()) {
				Account account = new Account();
				account.setUser_id(resultSet.getInt("REQ_TOR"));
				account = AccountCtrl.getAccountById(account.getUser_id());
				list.add(account);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlCtrl.closeStatement(ps);
		SqlCtrl.closeCon(con);
		return list;
	}
	
	public static List<Account> getrefuseFriendReqByTor(int req_tor) {
		Connection con = SqlCtrl.getCon();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		List<Account> list = new ArrayList<>();
		try {
			ps = con.prepareStatement("select REQ_TEE from friend_req where REQ_TOR=? and status=?");
			ps.setInt(1, req_tor);
			ps.setInt(2, Friend_req.REFUSED);
			resultSet = ps.executeQuery();
			while(resultSet.next()) {
				Account account = new Account();
				account.setUser_id(resultSet.getInt("REQ_TEE"));
				account = AccountCtrl.getAccountById(account.getUser_id());
				list.add(account);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlCtrl.closeStatement(ps);
		SqlCtrl.closeCon(con);
		return list;
	}
	
	public static void delfriendReq(int req_tor, int req_tee) {
		Connection con = SqlCtrl.getCon();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = con.prepareStatement("delete from friend_req where REQ_TOR=? AND REQ_TEE=?");
			ps.setInt(1, req_tor);
			ps.setInt(2, req_tee);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlCtrl.closeStatement(ps);
		SqlCtrl.closeCon(con);
	}
	
	public static void refuseFriendReq(int req_tor, int req_tee) {
		Connection con = SqlCtrl.getCon();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = con.prepareStatement("update friend_req set status=? where REQ_TOR=? AND REQ_TEE=?");
			ps.setInt(1, Friend_req.REFUSED);
			ps.setInt(2, req_tor);
			ps.setInt(3, req_tee);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlCtrl.closeStatement(ps);
		SqlCtrl.closeCon(con);
	}
}
