<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>Servlet3.0实现文件上传</title>
    <style>
body{
                    background-image: url("css/2.jpg");
                    background-attachment: fixed;
                    background-repeat: no-repeat;
                    background-size: cover;
                    font-family: "Segoe UI";
               
                }

</style>
  </head>
  
  <body>
  <table width="80%" border="1" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>
     <form action="${pageContext.request.contextPath}/UploadServlet"
                method="post" enctype="multipart/form-data">
    <table width="80%" border="1" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td colspan="2" align="center">上传单个文件</td>
        </tr>
      <tr>
        <td width="30%" align="right"> 上传文件</td>
        <td width="70%" align="left"><input type="file" name="file"></td>
      </tr>
      <tr>
        <td colspan="2" align="center">  <input type="submit" value="上传"></td>
        </tr>
    </table>
      </form>
    </td>
  </tr>
  <tr>
    <td>
     <form action="${pageContext.request.contextPath}/UploadServlet"
                method="post" enctype="multipart/form-data">
    <table width="80%" border="1" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td colspan="2" align="center">上传多个文件</td>
        </tr>
      <tr>
        <td width="30%" align="right">上传文件</td>
        <td width="70%"><input type="file" name="file"></td>
      </tr>
      <tr>
        <td align="right">上传文件</td>
        <td><input type="file" name="file2"></td>
      </tr>
      <tr>
        <td colspan="2" align="center"> <input type="submit" value="上传"></td>
        </tr>
    </table>
    </form>
    </td>
  </tr>
</table>
        
    </body>
</html>