package com.stu.ctrl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.stu.model.Account;
import com.stu.model.Comment;
import com.stu.model.Friend_req;
import com.stu.model.Post;

public class PostCtrl {
	
	private static int counter = 0;
	
	static {
		Connection con = SqlCtrl.getCon();
		ResultSet resultSet = null;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT * FROM post");
			resultSet = ps.executeQuery();
			while(resultSet.next()) {
				++ counter;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Post> getPostList() {
		Connection con = SqlCtrl.getCon();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		List<Post> list = new ArrayList<Post>();
		try {
			ps = con.prepareStatement("SELECT * FROM post ORDER BY POST_ID");
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Post p = new Post();
				p.setPost_id(resultSet.getInt("POST_ID"));
				p.setUser_id(resultSet.getInt("USER_ID"));
				p.setPost_title(resultSet.getString("POST_TITLE"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlCtrl.closeStatement(ps);
		SqlCtrl.closeCon(con);
		return list;
	}
	
	public static void addNewPost(Post p) {
		Connection con = SqlCtrl.getCon();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = con.prepareStatement("INSERT INTO post VALUES (?, ?, ?)");
			ps.setInt(1, ++ counter);
			ps.setInt(2, p.getUser_id());
			ps.setString(3, p.getPost_title());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlCtrl.closeStatement(ps);
		SqlCtrl.closeCon(con);
	}
	
	public static Post getPostById(int id) {
		Connection con = SqlCtrl.getCon();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		List<Post> list = new ArrayList<Post>();
		Post p = new Post();
		try {
			ps = con.prepareStatement("SELECT * FROM post where POST_ID=?");
			ps.setInt(1, id);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				p.setPost_id(resultSet.getInt("POST_ID"));
				p.setUser_id(resultSet.getInt("USER_ID"));
				p.setPost_title(resultSet.getString("POST_TITLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlCtrl.closeStatement(ps);
		SqlCtrl.closeCon(con);
		return p;
	}
	
	public static List<Post> getVisiblePost(Account account) {
		Connection con = SqlCtrl.getCon();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		List<Post> list = new ArrayList<Post>();
		try {
			ps = con.prepareStatement("SELECT * FROM post where USER_ID not in "
					+ "(select REQ_TOR from friend_req where status=? and REQ_TEE=?)");
			ps.setInt(1, Friend_req.REFUSED);
			ps.setInt(2, account.getUser_id());
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Post p = new Post();
				p.setPost_id(resultSet.getInt("POST_ID"));
				p.setUser_id(resultSet.getInt("USER_ID"));
				p.setPost_title(resultSet.getString("POST_TITLE"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			SqlCtrl.closeStatement(ps);
			SqlCtrl.closeCon(con);
		}
		return list;
	}
}
