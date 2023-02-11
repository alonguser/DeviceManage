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
<body>
<table bgcolor="dddddd" border="1" width="100%" height="50px">
<tr><td align="center">设备序号</td>
<td align="center">设备名称</td>
<td align="center">所在楼号</td>
<td align="center">所在教室/宿舍号</td>
<td align="center">报修内容</td>
<td align="center">报修时间</td></tr>
<% request.setCharacterEncoding("utf-8");
 String content=request.getParameter("content");
 String selectdevice=request.getParameter("selectdevice");
            DeviceDao dd=new DeviceDao();
            List<DeviceBean> devList=new ArrayList<DeviceBean>();
			devList=dd.selectByName(content);
			if(devList.size()!=0){
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
<%}} else{%>
<tr>
<td align="center">无结果！</td></tr>
<%} %>
</table>
</body>
</html>