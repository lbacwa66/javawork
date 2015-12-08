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
 * Servlet implementation class Register
 */
//@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		Account account = new Account();
		account.setUsername(username);
		account.setPwd(pwd);
		
		/**
		 * 先检查用户是否存在再添加
		 */
		System.out.println("Register : " + AccountCtrl.isAccountNameExist(account));
		System.out.println("Register : " + account.getUsername());
		if(!AccountCtrl.isAccountNameExist(account)) {
			
			AccountCtrl.addAccount(account);
			String login_suc = "login.jsp";
//			session.setAttribute("account", account);
			resp.sendRedirect(login_suc);
		} else {
			String login_fail = "registerFail.jsp";
//			session.setAttribute("account", account);
			resp.sendRedirect(login_fail);			
		}
		return;
	}

}
