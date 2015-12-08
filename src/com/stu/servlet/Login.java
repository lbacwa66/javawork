package com.stu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stu.ctrl.AccountCtrl;
import com.stu.model.Account;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		/*
		if ("admin".equals(username) && "123456".equals(pwd)) {
			String login_admin = "admin.jsp";
			session.setAttribute("account", account);
			resp.sendRedirect(login_admin);
			return ;
		}*/
		Account account = new Account();
		account.setUsername(username);
		account.setPwd(pwd);
		// 用户名存在 且 密码正确
		if(AccountCtrl.isAccountNameExist(account) & AccountCtrl.checkAccount(account)) {
			account.setUser_id(AccountCtrl.getAccountByName(username).getUser_id());
			account = AccountCtrl.getAccountById(account.getUser_id());
			resp.sendRedirect("post.jsp");
		} else {
			String login_fail = "loginFail.jsp";
			resp.sendRedirect(login_fail);
		}
		session.setAttribute("account", account);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
