<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.stu.servlet.*"%>
<%@page import="com.stu.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register success</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<script>
window.onload = function() {
    var timer = null;
    var lastTime = 4;
    function countTime() {
        if(lastTime == 0) {
            window.location.assign("login.jsp");
            clearInterval(timer);
        }
        lastTime --;
        document.getElementById('hint').innerHTML = "After " + lastTime + " seconds, it will come back to login page!";
    }
   
    timer = setInterval(countTime, 1000);
}
</script>
</head>
<body>
    <center>
	<%
		Account account = (Account) session.getAttribute("account");
	%>
	<table>
		<tr>
			<td><%=account.getUsername()%>用户</td>
		</tr>
		<tr>
			<td>恭喜你注册成功！！！</td>
		</tr>
		<tr>
			<td><a href="login.jsp">返回登陆界面</a></td>
		</tr>
        <tr>
            <td>
        <p id="hint"></p>
        </td>
        </tr>
	</table>
    </center>
</body>
</html>