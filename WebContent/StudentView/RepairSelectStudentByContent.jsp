<%@page import="model.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="control.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>展示学生信息</title>
</head>
<body style="background: url(../image/main.jpg); background-size:100% 100% ; background-attachment: fixed">

<form method="post" action="RepairSelectStudentServlet">
<table bgcolor="FFFFFF" border="1" width="100%" height="60px"><tr>
<td align="center">按
<select name="selectdevice">
      <option value="stuId">学生学号</option>
      <option value="stuName">学生姓名</option>
      <option value="pro">学生所在班级及专业</option>
      <option value="phone">学生手机号</option>
    </select>
    查询    <input type="text" name="content" placeholder="请输入要查询的内容"><input type="submit" value="查询"></td></tr>
</table>
</form>
<table bgcolor="FFFFFF" border="1" width="100%" height="50px">
<tr><td align="center">学生序号</td>
<td align="center">学生学号</td>
<td align="center">学生密码</td>
<td align="center">学生姓名</td>
<td align="center">学生所在班级及专业</td>
<td align="center">学生手机号</td></tr>
<% request.setCharacterEncoding("utf-8");
String content=request.getParameter("content");
String selectdevice=request.getParameter("selectdevice");
            UserDao ud=new UserDao();
			List<UserBean> stuList=new ArrayList<UserBean>();
			if(selectdevice.equals("stuId")){
				stuList=ud.selectStudentByStuId(content);
            }else if(selectdevice.equals("stuName")){
            	stuList=ud.selectStudentByStuName(content);
            }else if(selectdevice.equals("pro")){
            	stuList=ud.selectStudentByPro(content);
            }else if(selectdevice.equals("phone")){
            	stuList=ud.selectStudentByPhone(content);
            }
			if(stuList.size()!=0){
			for(UserBean stu:stuList){ %>
<tr>
<td align="center"><%=stu.getId() %></td>
<td align="center"><%=stu.getStuId() %></td>
<td align="center"><%=stu.getPassword() %></td>
<td align="center"><%=stu.getStuName() %></td>
<td align="center"><%=stu.getPro() %></td>
<td align="center"><%=stu.getPhone() %></td>
</tr>
<%}} else{%>
<tr>
<td align="center">无结果！</td></tr>
<%} %>
<tr>
			  	<td colspan="8" align="center">
			  		<%! int page=1; %>
			  		&nbsp;&nbsp;每页显示 5 条  &nbsp;&nbsp;&nbsp;
			  			| <a href="DeviceListPageServlet?currentPage=page">首页</a>
			  			
						| <a href="DeviceListPageServlet?currentPage=page-1">上一页</a>
						
						<% int d=stuList.size()/5;%>	
						| <a href="DeviceListPageServlet?currentPage=page+1">下一页</a>
						| <a href="DeviceListPageServlet?currentPage=page+1">尾页</a>  |  
			  			&nbsp;&nbsp;总计 <%=d %> 条记录  &nbsp;&nbsp;&nbsp;
			  			
			  	</td>
			  </tr>
</table>
</body>
</html>