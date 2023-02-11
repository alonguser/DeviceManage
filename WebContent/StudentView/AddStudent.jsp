<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户注册</title>
</head>
<body style="background: url(../image/main.jpg); background-size:100% 100% ; background-attachment: fixed">

	<form action="AddStudentServlet" method="post">
	<table align="center" height="250px"><tr><td></td></tr></table>
<table align="center" bgcolor="FFFFFF">
	<tr align="center">
		<td align="center">输入学号：
		<td align="center"><input type=text name=stuId required="required"></td>
	</tr>
	<tr align="center">
		<td align="center">输入密码：</td>
		<td align="center"><input type=password name=password required="required"></td>
	</tr>
	<tr align="center">
		<td align="center">确认密码：</td>
		<td align="center"><input type=password name=password2 required="required"></td>
	</tr>
	<tr align="center">
		<td align="center">输入姓名：</td>
		<td align="center"><input type=text name=stuName required="required"></td>
	</tr>
	<tr align="center">
		<td align="center">输入班级及专业：</td>
		<td align="center"><input type=text name=pro required="required"></td>
	</tr>
	<tr align="center">
		<td align="center">输入手机号：</td>
		<td align="center"><input type=text name=phone required="required"></td>
	</tr>
	<tr colspan=2 align="center">
		<td align="center"><input type="reset" value="重置" /></td>
		<td align="center"><input type="submit" value="添加" /></td>
		</tr>
</table>
</form>
</body>
</html>
