<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/login.css">
<title>register</title>
</head>
<script>
function checkNewPwd() {
    var firstNewPwd = document.getElementById("pwd");
    var secondNewPwd = document.getElementById("re_pwd");
    if (firstNewPwd != secondNewPwd) {
        document.getElementById("hint").innerHTML = "The new passwords are not matched! Please check again!";
    }
}
</script>
<body>
<center>
<div class="head">
</div>
	<table>
	<form action="register" method="post">
	<tr>
		<td class="td_prompt">username:</td>
		<td colspan="2"><input type="text" name="username" required="required"></td> <br>
	</tr>
	<tr>
		<td class="td_prompt">password:</td>
		<td colspan="2"><input type="password" id="pwd" name="pwd" required="required"></td> <br> 
	</tr>
	<tr>
		<td class="td_prompt">Comfirm password:</td>
		<td colspan="2"><input type="password" id="re_pwd" name="re_pwd" required="required" onchange="checkNewPwd()"></td> <br> 
	</tr>
    <tr>
		<td align="center" colspan="3"]>
		<input class="td_btn" type="submit" value="注册" onclick="check()">
		<input class="td_btn" type="reset" value="清除">
		<input class="td_btn" type="button" value="取消"  onclick="window.location='login.jsp'">
		</td>
    </tr>
    <tr>
        <td colspan="2"><p id="hint"></p></td>
    </tr>
	</form>
	</table>
</center>
</body>
</html>