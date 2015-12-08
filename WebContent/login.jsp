<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<div class="head"></div>
     	<center>
     		<form action="login" method="post">
     			<table width="380" border="0" >
     				<tr>
     					<td colspan=3 align="center"><h1>welcome</h1></td>
     				</tr>
     				<tr>
     					<td class="td_prompt">
     						username:</td>
     						<td colspan=2><input name="username" type="text" required="required" pattern="[\S]+" title="Blank is not allowed."></td>
     						<tr>
     						<td class="td_prompt">password:</td>
     						<td colspan=2>
     						<input name="pwd" type="password" required="required"></td>
     						</tr>
     						<tr>
     						<td >
     						<input class="td_btn" type="submit" name="submit" value="login">
     						 </td>
     						 <td>
     						 <input class="td_btn" type="button" value="register" onclick="window.location='register.jsp'"> 	
     						</td>
     						<td>
     						<input class="td_btn" type="button" value="modify" onclick="window.location='modify.jsp'"> 
     						</td>
     						</tr>  				
     			</table>
     		</form>
     	</center>

</body>
</html>