<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加设备</title>
</head>
<body style="background: url(../image/main.jpg); background-size:100% 100% ; background-attachment: fixed">

<form action="AddDeviceServlet" method="post">
<table align="center" height="250px"><tr><td></td></tr></table>
<table align="center" bgcolor="FFFFFF">
<tr><td>设备名称</td><td><input type="text" name="name" required="required"></td></tr>
<tr><td>所在楼号</td><td><input type="text" name="location" required="required"></td></tr>
<tr><td>所在教室/宿舍号</td><td><input type="text" name="address" required="required"></td></tr>
<tr><td>报修内容</td><td><input type="text" name="repair"></td></tr>
<tr><td>报修时间（年/月/日）</td><td><input type="text" name="time" required="required"></td></tr>
<tr><td colspan="2"><input type="submit" value="添加"></td></tr>
</table>
</form>
</body>
</html>