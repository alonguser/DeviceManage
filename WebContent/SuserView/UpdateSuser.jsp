<%@page import="control.ManageUserDao"%>
<%@page import="model.ManageUserBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加设备</title>
</head>
<body style="background: url(../image/main.jpg); background-size:100% 100% ; background-attachment: fixed">

<form action="UpdateSuserServlet" method="post">
<%
	String userid=request.getParameter("ID");
    int id=Integer.parseInt(userid.toString().trim());
    ManageUserDao mud=new ManageUserDao();
	ManageUserBean suser=mud.selectById(id);
	if(suser!=null){
%>
<table align="center" height="250px"><tr><td></td></tr></table>
<table align="center" bgcolor="FFFFFF">
<tr><td></td><td><input type="hidden" name="id" value="<%=id%>"></td></tr>
<tr><td>维修工ID</td><td><input type="text" name="userId" value="<%=suser.getUserId()%>"></td></tr>
<tr><td>密码</td><td><input type="text" name="password" value="<%=suser.getPassword()%>"></td></tr>
<tr><td>维修工姓名</td><td><input type="text" name="name" value="<%=suser.getName()%>"></td></tr>
<tr><td>维修工手机号</td><td><input type="text" name="phone" value="<%=suser.getPhone()%>"></td></tr>
<tr><td colspan="2"><input type="submit" value="修改"></td></tr>
</table>
<%} %>
</form>
</body>
</html>