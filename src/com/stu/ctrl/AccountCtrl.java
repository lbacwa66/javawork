package com.stu.ctrl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import com.stu.model.Account;
import com.stu.model.Post;

public class AccountCtrl {
	private static int counter = 0;
	
	static {
	Connection con = SqlCtrl.getCon();
		ResultSet resultSet = null;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT * FROM account");
			resultSet = ps.executeQuery();
			while(resultSet.next()) {
				++ counter;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 添加账号，重要的是用户名和密码，id随意
	public static void addAccount(Account account) {
		Connection con = SqlCtrl.getCon();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("INSERT INTO account VALUES(?, ?, ?)");
			ps.setInt(1, ++counter);
			ps.setString(2, account.getUsername());
			ps.setString(3, account.getPwd());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlCtrl.closeStatement(ps);
		SqlCtrl.closeCon(con);
	}
	
	// 通过用户名查找账号
	public static Account getAccountByName(String name) {
		Connection con = SqlCtrl.getCon();
		ResultSet resultSet;
		PreparedStatement ps = null;
		Account account = null;
		try {
			ps = con.prepareStatement("SELECT * FROM account WHERE USERNAME = ?");
			ps.setString(1, name);
			resultSet = ps.executeQuery();
			account = new Account();
			
			resultSet.next();
			
			account.setUser_id(resultSet.getInt("USER_ID"));
			account.setUsername(resultSet.getString("USERNAME"));
			account.setPwd(resultSet.getString("PWD"));
			account.setVisible(resultSet.getInt("VISIBLE"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}
	
	// 检查用户名是否存在
	public static boolean isAccountNameExist(Account account) {
		Connection con = SqlCtrl.getCon();
		ResultSet resultSet = null;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT * FROM account WHERE username=?");
			ps.setString(1, account.getUsername());
			resultSet = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			resultSet.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}
	
	// 检查用户名的名字和密码是否对应
	public static boolean checkAccount(Account account) {
		Connection con = SqlCtrl.getCon();
		ResultSet resultSet = null;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT * FROM account WHERE USERNAME=? and PWD=?");
			ps.setString(1, account.getUsername());
			ps.setString(2, account.getPwd());
			resultSet = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			resultSet.next();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	// 通过id查找账号
	public static Account getAccountById(int id) {
		Connection con = SqlCtrl.getCon();
		ResultSet resultSet;
		PreparedStatement ps = null;
		Account account = null;
		try {
			ps = con.prepareStatement("SELECT * FROM account WHERE USER_ID = ?");
			ps.setInt(1, id);
			resultSet = ps.executeQuery();
			account = new Account();
			
			resultSet.next();
			
			account.setUser_id(resultSet.getInt("USER_ID"));
			account.setUsername(resultSet.getString("USERNAME"));
			account.setPwd(resultSet.getString("PWD"));
			account.setVisible(resultSet.getInt("VISIBLE"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}
	
	// 返回所有用户
	public static List<Account> getAccountList() {
		Connection con = SqlCtrl.getCon();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		List<Account> list = new ArrayList<Account>();
		try {
			ps = con.prepareStatement("SELECT * FROM account ORDER BY USER_ID");
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Account account = new Account();
				account.setUser_id(resultSet.getInt("USER_ID"));
				account.setUsername(resultSet.getString("USERNAME"));
				account.setPwd(resultSet.getString("PWD"));
				account.setVisible(resultSet.getInt("VISIBLE"));
				list.add(account);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlCtrl.closeStatement(ps);
		SqlCtrl.closeCon(con);
		return list;
	}
	
	// 返回所有用户
	public static List<Account> getVISIBLEAccountList() {
		Connection con = SqlCtrl.getCon();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		List<Account> list = new ArrayList<Account>();
		try {
			ps = con.prepareStatement("SELECT * FROM account where VISIBLE=? ORDER BY USER_ID");
			ps.setInt(1, Account.VISIBLE);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Account account = new Account();
				account.setUser_id(resultSet.getInt("USER_ID"));
				account.setUsername(resultSet.getString("USERNAME"));
				account.setPwd(resultSet.getString("PWD"));
				account.setVisible(resultSet.getInt("VISIBLE"));
				list.add(account);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlCtrl.closeStatement(ps);
		SqlCtrl.closeCon(con);
		return list;
	}
	
	// 返回所有用户
	public static void changeVisible(Account account) {
		Connection con = SqlCtrl.getCon();
		PreparedStatement ps = null;
		account.setVisible(account.getVisible() == Account.VISIBLE ? Account.UNVISIBLE : account.VISIBLE);
		try {
			ps = con.prepareStatement("UPDATE account set VISIBLE=? where USER_ID=?");
			ps.setInt(1, account.getVisible());
			ps.setInt(2, account.getUser_id());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			SqlCtrl.closeStatement(ps);
			SqlCtrl.closeCon(con);
		}
	}
}
