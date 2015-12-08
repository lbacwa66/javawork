package com.stu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stu.ctrl.AccountCtrl;
import com.stu.ctrl.FriendReqCtrl;
import com.stu.ctrl.FriendsCtrl;
import com.stu.model.Account;

/**
 * Servlet implementation class AgreeFriend
 */
public class AgreeFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgreeFriend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String friendsName = request.getParameter("friendname");
		
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("account");
		Account friend = AccountCtrl.getAccountByName(friendsName);
		
		// 请求方 放在前面
		FriendReqCtrl.delfriendReq(friend.getUser_id(), account.getUser_id());
		FriendsCtrl.addFriend(account.getUser_id(), friend.getUser_id());
		
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
