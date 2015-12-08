package com.stu.ctrl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.stu.model.Account;
import com.stu.model.Friends;

public class FriendsCtrl {
	public static void addFriend(int user_id_1, int user_id_2) {
		Connection con = SqlCtrl.getCon();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = con.prepareStatement("select user_id_1, user_id_2 from friend where USER_ID_1=? AND USER_ID_2=?");
			ps.setInt(1, user_id_1);
			ps.setInt(2, user_id_2);
			resultSet = ps.executeQuery();
			if (resultSet.next() == false) {
				ps = con.prepareStatement("INSERT INTO friend VALUES(?, ?)");
				ps.setInt(1, user_id_1);
				ps.setInt(2, user_id_2);
				ps.execute();
				
				ps = con.prepareStatement("INSERT INTO friend VALUES(?, ?)");
				ps.setInt(2, user_id_1);
				ps.setInt(1, user_id_2);
				ps.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlCtrl.closeStatement(ps);
		SqlCtrl.closeCon(con);
	}
	
	public static List<Account> getFriendAccountListById(int user_id) {
		Connection con = SqlCtrl.getCon();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		List<Account> list = new ArrayList<>();
		try {
			ps = con.prepareStatement("select * from friend where USER_ID_1=?");
			ps.setInt(1, user_id);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Account account = new Account();
				account.setUser_id(resultSet.getInt("USER_ID_2"));
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
	
	public static List<Account> getRefusedFriendAccountListBy(int user_id) {
		Connection con = SqlCtrl.getCon();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		List<Account> list = new ArrayList<>();
		try {
			ps = con.prepareStatement("select * from friend where USER_ID_1=?");
			ps.setInt(1, user_id);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Account account = new Account();
				account.setUser_id(resultSet.getInt("USER_ID_2"));
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
	
	public static void blockFriend(int user_id_1, int user_id_2) {
		Connection con = SqlCtrl.getCon();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = con.prepareStatement("select user_id_1, user_id_2 from friend where USER_ID_1=? AND USER_ID_2=?");
			ps.setInt(1, user_id_1);
			ps.setInt(2, user_id_2);
			resultSet = ps.executeQuery();
			if (resultSet.next() == false) {
				ps = con.prepareStatement("update table friend set status=? where USER_ID_1=? AND USER_ID_2=?");
				ps.setInt(1, Friends.BLOCKED);
				ps.setInt(2, user_id_1);
				ps.setInt(3, user_id_2);
				ps.execute();
				
				ps = con.prepareStatement("update table friend set status=? where USER_ID_1=? AND USER_ID_2=?");
				ps.setInt(1, Friends.BLOCKED);
				ps.setInt(3, user_id_1);
				ps.setInt(2, user_id_2);
				ps.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlCtrl.closeStatement(ps);
		SqlCtrl.closeCon(con);
	}
}
