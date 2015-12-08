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
     <h1 style="color:white">以下用户申请成为你的好友</h1>
        <input type="text" id="content" />
        <button onclick="search()" value="search">Search</button>
        <%
            Account account = (Account) session.getAttribute("account");
            List <Account> list = FriendReqCtrl.getfriendReqByTee(account.getUser_id());
        %>
        <ul id="demo">
        <%
            
            for (Account acc : list) {
                if (acc.getUser_id() == account.getUser_id() || acc.getUser_id() == 1) {
                    continue;
                }
                out.println("<li><text>");
                out.println(acc.getUsername());
                out.println("</text> <button>Agree</button><button>Refuse</button></li>");
            }
        %>
        </ul>
        
        <h1 style="color:white">以下用户拒绝成为你的好友</h1>
        <input type="text" id="content" />
        <button onclick="search()" value="search">Search</button>
        <%
            account = (Account) session.getAttribute("account");
            list = FriendReqCtrl.getrefuseFriendReqByTor(account.getUser_id());
        %>
        <ul id="demo">
        <%
            
            for (Account acc : list) {
                if (acc.getUser_id() == account.getUser_id() || acc.getUser_id() == 1) {
                    continue;
                }
                out.println("<li><text>");
                out.println(acc.getUsername());
                out.println("</li>");
            }
        %>
        </ul>
        </center>
        <script src="js/agreefriend.js"></script>
</body>
</html>