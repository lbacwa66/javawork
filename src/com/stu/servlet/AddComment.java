package com.stu.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stu.ctrl.CommentCtrl;
import com.stu.model.Account;
import com.stu.model.Comment;

/**
 * Servlet implementation class AddComment
 */
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.println("AddComment : " + request.getParameter("post_id"));
		
		Account account = (Account)session.getAttribute("account");
		
		if("on".equals(request.getParameter("anonymous"))) {
//			account.setUsername("匿名");
			account.setUser_id(1);
		}
		
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		String content = request.getParameter("content");
		Comment comment = new Comment();
		comment.setComment_date(new Date());
		comment.setContent(content);
		comment.setPost_id(post_id);
		System.out.println("AddComment : " + ((Account)session.getAttribute("account")).getUser_id());
		comment.setUser_id(account.getUser_id());
		CommentCtrl.addComment(comment);
		response.sendRedirect(request.getHeader("Referer"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
