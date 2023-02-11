<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户注册</title>
</head>
<body style="background: url(image/start.jpg); background-size:100% 100% ; background-attachment: fixed">
<table height="300px"><tr><td></td></tr></table>	
	<form action="RegisterServlet" method="post">
	<table align="center" bgcolor="dddddd">
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
		<td align="center"><input type="submit" value="注册" /></td>
		<td align="center"><a href="login.jsp"><font color=blue>已有账号？去登录</font></a></td>
	</tr>
</table>
</form>
</body>
</html>
