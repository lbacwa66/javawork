package com.stu.ctrl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stu.model.Account;
import com.stu.model.Comment;
import com.stu.model.Post;

public class CommentCtrl {
	
	private static int counter = 0;
	
	static {
		Connection con = SqlCtrl.getCon();
		ResultSet resultSet = null;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT * FROM comment");
			resultSet = ps.executeQuery();
			while(resultSet.next()) {
				++ counter;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 根据某个post获取评论列表，重要的是id
	public static List getCommentList(Post post) {
		Connection con = SqlCtrl.getCon();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		List<Comment> list = new ArrayList<Comment>();
		try {
			ps = con.prepareStatement("select * from comment where POST_ID=? ORDER BY COMMENT_DATE");
			ps.setInt(1, post.getPost_id());
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Comment c = new Comment();
				c.setPost_id(resultSet.getInt("post_id"));
				c.setComment_date(resultSet.getString("comment_date"));
				c.setContent(resultSet.getString("content"));
				c.setUser_id(resultSet.getInt("user_id"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlCtrl.closeStatement(ps);
		SqlCtrl.closeCon(con);
		return list;
	}
	
	// 添加一个评论
	public static void addComment(Comment comment) {
		Connection con = SqlCtrl.getCon();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = con.prepareStatement("INSERT INTO comment VALUES(?, ?, ?, ?)");
			ps.setInt(1, comment.getPost_id());
			ps.setString(2, comment.getContent());
			ps.setInt(3, comment.getUser_id());
			ps.setString(4, comment.getComment_date());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlCtrl.closeStatement(ps);
		SqlCtrl.closeCon(con);
	}
}
