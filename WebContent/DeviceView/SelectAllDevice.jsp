<%@page import="model.DeviceBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="control.DeviceDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>展示设备信息</title>
</head>
<script>
function deleteDVD(id){
	if(confirm("确定要删除吗？")){
		window.location.href = "<%=request.getContextPath()%>/DeviceView/DeleteDeviceServlet?DEVID="+id;
	}
}
</script>
<body style="background: url(../image/main.jpg); background-size:100% 100% ; background-attachment: fixed">

<form method="post" action="SelectDeviceServlet">
<table bgcolor="FFFFFF" border="1" width="100%" height="60px"><tr>
<td align="center">按
<select name="selectdevice">
      <option value="name">设备名称</option>
      <option value="location">所在楼号</option>
      <option value="address">所在教室/宿舍号</option>
      <option value="repair">报修内容</option>
      <option value="time">报修时间</option>
    </select>查询   |  
    <input type="text" name="content" placeholder="请输入要查询的内容"><input type="submit" value="查询"></td></tr>
</table>
</form>
<table bgcolor="FFFFFF" border="1" width="100%" height="50px">
<tr><td align="center">设备序号</td>
<td align="center">设备名称</td>
<td align="center">所在楼号</td>
<td align="center">所在教室/宿舍号</td>
<td align="center">报修内容</td>
<td align="center">报修时间</td></tr>
<% 
            DeviceDao dd=new DeviceDao();
			List<DeviceBean> devList=new ArrayList<DeviceBean>();
			devList=dd.selectAll();
			for(DeviceBean dev:devList){ 
			%>
<tr>
<td align="center"><%=dev.getId() %></td>
<td align="center"><%=dev.getName() %></td>
<td align="center"><%=dev.getLocation() %></td>
<td align="center"><%=dev.getAddress() %></td>
<td align="center"><%=dev.getRepair() %></td>
<td align="center"><%=dev.getTime() %></td>
<td align="center"><a href="<%=request.getContextPath()%>/DeviceView/UpdateDevice.jsp?ID=<%=dev.getId() %>">修改</a></td>
    <td align="center"><a href="javaScript:deleteDVD(<%=dev.getId() %>)">删除</a></td>
</tr>
<%} %>
<tr>
			  	<td colspan="8" align="center">
			  		<%! int page=1; %>
			  		&nbsp;&nbsp;每页显示 5 条  &nbsp;&nbsp;&nbsp;
			  			| <a href="DeviceListPageServlet?currentPage=page">首页</a>
			  			
						| <a href="DeviceListPageServlet?currentPage=page-1">上一页</a>
						
						<% int d=devList.size()/5;%>	
						| <a href="DeviceListPageServlet?currentPage=page+1">下一页</a>
						| <a href="DeviceListPageServlet?currentPage=page+1">尾页</a>  |  
			  			&nbsp;&nbsp;总计 <%=d %> 条记录  &nbsp;&nbsp;&nbsp;
			  			
			  	</td>
			  </tr>
</table>
</body>
</html>