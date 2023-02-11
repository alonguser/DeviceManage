<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>操作失败！</title>
</head>
<body style="background: url(image/start.jpg); background-size:100% 100% ; background-attachment: fixed">

<%
	request.setCharacterEncoding("utf-8");
    String cz=request.getParameter("cz");
%>
<table align="center" height="250px"><tr><td></td></tr></table>
<table align="center" width="100%" height="100%">
<tr align="center"><td align="center"><font color="FFFFFF"><h1><%=cz %></h1></font>
</td></tr></table>
</body>
</html>