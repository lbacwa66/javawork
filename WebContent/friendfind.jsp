<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.stu.model.*" %>
<%@page import="com.stu.servlet.*" %>
<%@page import="com.stu.ctrl.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/friends.css">
</head>
<body>
<input type="button" value="返回"style="height:30px;width:80px" onclick="window.location='post.jsp'">
     <center>
        <input type="text" id="content" />
        <button onclick="search()" value="search">Search</button>
        <%
            List <Account> list = AccountCtrl.getVISIBLEAccountList();
        %>
        <ul id="demo">
        <%
            Account account = (Account) session.getAttribute("account");
            for (Account acc : list) {
            	if (acc.getUser_id() == account.getUser_id() || acc.getUser_id() == 1) {
            		continue;
            	}
            	out.println("<li><text>");
            	out.println(acc.getUsername());
            	out.println("</text> <button>Add Friend</button></li>");
            }
        %>
        </ul>
        </center>
        <script src="js/friends.js"></script>
</body>
</html>