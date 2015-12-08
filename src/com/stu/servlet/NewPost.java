package com.stu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stu.ctrl.AccountCtrl;
import com.stu.ctrl.PostCtrl;
import com.stu.model.Account;
import com.stu.model.Post;

/**
 * Servlet implementation class Post
 */

public class NewPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String theme = request.getParameter("theme");
		HttpSession session=request.getSession();

		Account account = (Account) request.getSession().getAttribute("account");
//		System.out.println(account);

		// 创建新主题
		// 创建好后，进入该主题
		String username = account.getUsername();
		if("on".equals(request.getParameter("anonymous"))) {
			// 匿名
			account.setUser_id(1);
		}
		String newTheme = (String) request.getParameter("newTheme");
		String comment = (String) request.getParameter("comment");
		
		Post p = new Post();
		p.setUser_id(account.getUser_id());
		p.setPost_title(newTheme);
		PostCtrl.addNewPost(p);
		
		// 回到原先的网页，从哪里来回哪里去
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
