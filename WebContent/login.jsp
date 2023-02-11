<%@ page contentType="text/html; charset=utf-8"%>
<html>
<jsp:useBean id="user" class="model.UserBean" scope="session"/>
<body style="background: url(image/start.jpg); background-size:100% 100% ; background-attachment: fixed">
<form method=post action=CheckLoginServlet>
<table height="300px"><tr><td></td></tr></table>
<table align="center" bgcolor="dddddd">
	<tr align="center">
		<td align="center">输入学号：</td>
		<td align="center"><input type=text name=stuId required="required"></td>
	</tr>
	<tr align="center">
		<td align="center">输入密码：</td>
		<td align="center"><input type=password name=password required="required"></td>
	</tr>
	<tr colspan=2 align="center">
		<td align="center"><input type=submit  value="登录"></td>
		<td align="center"><a href="register.jsp"><font color=blue>没有账号？去注册</font></a></td>
	</tr>
	<tr colspan=2 align="center">
		<td align="center"><a href="managerLogin.jsp"><font color=red>管理员登录</font></a></td>
	</tr>
</table>
</form>
</body>
</html>
