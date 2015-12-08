<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "com.stu.servlet.*" %>
<%@page import = "com.stu.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register fail</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<script src="js/goto.js"></script>
<script>goTo("login.jsp", 3000);</script>
</head>
<body>
<%Account account = (Account) session.getAttribute("account");%>
	<table align="center">
		<tr>
			<td><%=account.getUsername()%> 用户名或密码错误两次密码不同</td>
		</tr>
		<tr>
		  <td><a href="login.jsp">返回登陆界面</a></td>
		</tr>
		<tr>
          <td>3秒后返回登录页面</td>
        </tr>
	</table>
</body>
</html>