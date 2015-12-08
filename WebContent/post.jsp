<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "com.stu.servlet.*" %>
<%@page import = "com.stu.ctrl.*" %>
<%@page import = "com.stu.model.*" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
 function goupload()
 {
	 window.open("Upload.jsp","_self");
 }
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login success!</title>
<style>
body{
                    background-image: url("css/2.jpg");
                    background-attachment: fixed;
                    background-repeat: no-repeat;
                    background-size: cover;
                }
                #div1{
                    left: 0px;
                    width: 300px;
                    height: 50%;
                    background: green;
                    position: absolute;
                }
                table {
                    margin-left: 20%;
                    margin-right: 10%;
                    width: 70%;
                }
                td.user {
                    height: 100px;
                    width: 15%;
                    background-color: aquamarine;
                    opacity: 0.5;
                    padding-bottom: 50px;
                    font-size: 35px;
                    font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif
                    
                }
                td.comment {
                    height: 100px;
                    width: 70%;
                    background-color: white;
                    border-bottom: 50px solid white;
                    font-weight: bolder;
                    font-size: 20px;
                    font-family: Arial, Helvetica, sans-serif;
                }
                .reply {
                    margin-left: 20%;
                    margin-right: 10%;
                    width: 70%;
                }
                .button {
                    color: #900;
                    background: #DC0;
                    font-weight: bold;
                    border: 1px solid #900;
                    height: 32px;
                    width: 80px;
                    margin-left: 10%;
                }
                
                .button:hover {
                    color: #FFF;
                    background: #900;
                }
                
                .comment {
                    font-family: Arial, Helvetica, sans-serif;
                    font-size: 30px;
                    /*margin-right: 30%;*/
                }
</style>
</head>
<body>
<input type="button" value="退出登录"style="height:30px;width:80px" onclick="window.location='login.jsp'">
<input type="button" value="查找朋友"style="height:30px;width:80px" onclick="window.location='friendfind.jsp'">
<input type="button" value="消息中心"style="height:30px;width:80px" onclick="window.location='message.jsp'">
<%
Account account = (Account) session.getAttribute("account");
List <Account> listA = FriendReqCtrl.getfriendReqByTee(account.getUser_id());
out.println("<text style=\"color:white\">你有" + listA.size() + "条消息</text>");
%>
<input type="button" value="我的朋友"style="height:30px;width:80px" onclick="window.location='showfriends.jsp'">
<button style="height:30px;width:80px" onclick="window.location='ChangeVisible'">
<%if(account.getVisible() == Account.VISIBLE){
        out.print("变为隐身");
    } else {
    	out.print("取消隐身");
    }
	%>
</button>
<input type="button" value="上传文件" style="height:30px;width:80px" onclick="goupload()">
</br>
<center>
    <%
        List<Post> list = PostCtrl.getVisiblePost(account);
        out.println("<table>");
        for (Post p : list) {
            out.print(
                    "<table frame=\"box\">"+
                    "<form action=\"singlePost.jsp\"" + " method=\"get\"" + ">"  + 
                    "<input type=hidden  name=post_id value="+ p.getPost_id() +">" + 
                    "<tr>"+
                     "<td class=user>" + "Post Name : " + p.getPost_title() +"</td>"+
                     "<td class=user>" + "PostOwner : " + AccountCtrl.getAccountById(p.getUser_id()).getUsername() +"</td>"+
                    "</tr>"+
                    "<tr><td>" +
                    "<input type=\"submit\" value=\"See it!\" >" +
                    "</td></tr>" +
                    "</form>"
            );
        }
        out.println("</table>");
    %>
      <form action="NewPost" align="center">
            <input type="text" name="newTheme" required="required"></br>
            <b class="comment">Comment Here:</b>
            <textarea placeholder="You can post from here" class="reply" name="comment" rows=15 cols="50"></textarea></br>
             <input type="checkbox" name="anonymous"><b  class="comment">Anonymous</b><input type="submit" class="button">
        </form>
    </center>
</body>
</html>