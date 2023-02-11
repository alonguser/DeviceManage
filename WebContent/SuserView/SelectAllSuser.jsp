<%@page import="model.ManageUserBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="control.ManageUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>展示维修工信息</title>
</head>
<script>
function deleteDVD(id){
	if(confirm("确定要删除吗？")){
		window.location.href = "<%=request.getContextPath()%>/SuserView/DeleteSuserServlet?STUID="+id;
	}
}
</script>
<body style="background: url(../image/main.jpg); background-size:100% 100% ; background-attachment: fixed">

<form method="post" action="SelectSuserServlet">
<table bgcolor="FFFFFF" border="1" width="100%" height="60px"><tr>
<td align="center">按
<select name="selectdevice">
      <option value="userId">维修工ID</option>
      <option value="name">维修工姓名</option>
      <option value="phone">维修工手机号</option>
    </select>
    查询    <input type="text" name="content" placeholder="请输入要查询的内容"><input type="submit" value="查询"></td></tr>
</table>
</form>
<table bgcolor="FFFFFF" border="1" width="100%" height="50px">
<tr><td align="center">维修工序号</td>
<td align="center">维修工ID</td>
<td align="center">密码</td>
<td align="center">维修工姓名</td>
<td align="center">维修工手机号</td></tr>
<% 
            ManageUserDao mud=new ManageUserDao();
			List<ManageUserBean> sList=new ArrayList<ManageUserBean>();
			sList=mud.selectAllSuser();
			for(ManageUserBean suser:sList){ 
			%>
<tr>
<td align="center"><%=suser.getId() %></td>
<td align="center"><%=suser.getUserId() %></td>
<td align="center"><%=suser.getPassword() %></td>
<td align="center"><%=suser.getName() %></td>
<td align="center"><%=suser.getPhone() %></td>
<td align="center"><a href="<%=request.getContextPath()%>/SuserView/UpdateSuser.jsp?ID=<%=suser.getId() %>">修改</a></td>
    <td align="center"><a href="javaScript:deleteDVD(<%=suser.getId() %>)">删除</a></td>
</tr>
<%} %>
<tr>
			  	<td colspan="8" align="center">
			  		<%! int page=1; %>
			  		&nbsp;&nbsp;每页显示 5 条  &nbsp;&nbsp;&nbsp;
			  			| <a href="DeviceListPageServlet?currentPage=page">首页</a>
			  			
						| <a href="DeviceListPageServlet?currentPage=page-1">上一页</a>
						
						<% int d=sList.size()/5;%>	
						| <a href="DeviceListPageServlet?currentPage=page+1">下一页</a>
						| <a href="DeviceListPageServlet?currentPage=page+1">尾页</a>  |  
			  			&nbsp;&nbsp;总计 <%=d %> 条记录  &nbsp;&nbsp;&nbsp;
			  			
			  	</td>
			  </tr>
</table>
</body>
</html>