<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>首页</title>
</head>
<%
	request.setCharacterEncoding("utf-8");
    String name=request.getParameter("name");
%>
<body bgcolor="000000">
<table background="image/top.png" align="left" width="100%" height="100px"><tr align="right">
<td align="right">用户：<font color=blue><%=name %></font>	|	
<a href="login.jsp"><font color=blue>退出</font></a>	|	</td>
</tr></table>
<table width="100%" height="760px"><tr>
<td width="20%" height="100%"><iframe src="studentLeft.jsp" width="100%" height="100%" frameborder="0"></iframe></td>
<td width="80%" height="100%"><iframe src="DeviceView/SelectAllDevice.jsp" name="main" width="100%" height="100%" frameborder="0"></iframe></td>
</tr></table></body>
<table width="100%" height="90px"><tr>
<td width="100%" height="100%"><iframe src="down.jsp" width="100%" height="100%" frameborder="0"></iframe></td>
</tr></table>
</html>
