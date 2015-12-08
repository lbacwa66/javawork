<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.stu.model.*"%>
<%@page import="com.stu.servlet.*"%>
<%@page import="com.stu.ctrl.*"%>
<%@page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
body{
                    /*background-image: url("http://img2.xue163.com/img1.pconline.com.cn/piclib/200906/05/batch/1/34512/1244162971339xo0exzw8lt.jpg");*/
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
<center>
<%
    Post p = PostCtrl.getPostById((Integer.parseInt(request.getParameter("post_id"))));
    out.println("<table>");
    out.print("<tr>"+
            "<td class=user>" + AccountCtrl.getAccountById(p.getUser_id()).getUsername() +"</td>"+
            "<td class=comment>" + p.getPost_title() +"</td>"+
            "</tr>"
        );
    
    List <Comment> list = CommentCtrl.getCommentList(p);
    for(Comment comment : list) {
        out.print("<tr>"+
                    "<td class=user>" + AccountCtrl.getAccountById(comment.getUser_id()).getUsername() +"</td>"+
                    "<td class=comment>" +  comment.getContent() +"</td>"+
                    "</tr>"
                );
    }
    out.println("</table>");
%>
      <form action="AddComment" align="center" method="post">
            <input type="hidden" name="post_id" value=<%= p.getPost_id()%>></input>
            <b class="comment">Comment Here:</b>
            <textarea placeholder="You can post from here" class="reply" name="content" rows=15 cols="50" required="required"></textarea></br>
            <input type="checkbox" name="anonymous"><b  class="comment">Anonymous</b><input type="submit" class="button">
        </form>
</center>
</body>
</html>