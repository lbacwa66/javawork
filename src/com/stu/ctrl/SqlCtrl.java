package com.stu.ctrl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SqlCtrl {
	
	private static String user = "root";
	private static String pwd = "";
	
	public static Connection getCon() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeCon(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeStatement(Statement con) {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
