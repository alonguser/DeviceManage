<%@page import="control.UserDao"%>
<%@page import="model.UserBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加设备</title>
</head>
<body style="background: url(../image/main.jpg); background-size:100% 100% ; background-attachment: fixed">

<form action="UpdateStudentServlet" method="post">
<%
	String stuid=request.getParameter("ID");
    int id=Integer.parseInt(stuid.toString().trim());
    UserDao ud=new UserDao();
	UserBean stu=ud.selectById(id);
	if(stu!=null){
%>
<table align="center" height="250px"><tr><td></td></tr></table>
<table align="center" bgcolor="FFFFFF">
<tr><td></td><td><input type="hidden" name="id" value="<%=id%>"></td></tr>
<tr><td>学生学号</td><td><input type="text" name="stuId" value="<%=stu.getStuId()%>"></td></tr>
<tr><td>学生密码</td><td><input type="text" name="password" value="<%=stu.getPassword()%>"></td></tr>
<tr><td>学生姓名</td><td><input type="text" name="stuName" value="<%=stu.getStuName()%>"></td></tr>
<tr><td>学生所在班级及专业</td><td><input type="text" name="pro" value="<%=stu.getPro()%>"></td></tr>
<tr><td>学生手机号</td><td><input type="text" name="phone" value="<%=stu.getPhone()%>"></td></tr>
<tr><td colspan="2"><input type="submit" value="修改"></td></tr>
</table>
<%} %>
</form>
</body>
</html>