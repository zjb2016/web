 <%@ page language="java" contentType="text/html;" pageEncoding= "utf-8" %>
 <%@ page import="entity.*" %>
 
<%
     bycycle bike=(bycycle)request.getAttribute("bike");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>搜索结果</title>
</head>

<body>
<h1>搜索结果:</h1>
<div>
<tr>
   <th width="15%" height="46" bgcolor="#FFcc33" scope="col">品牌</th>
   <th width="15%" height="46" bgcolor="#FFcc33" scope="col">价格</th>
   <th width="15%" height="46" bgcolor="#FFcc33" scope="col">型号</th>
   <th width="15%" height="46" bgcolor="#FFcc33" scope="col">成色</th>
 </tr>  
</div> 
  <tr>
    <td align="center"><%=bike.getBrand()%></td>
    <td align="center"><%=bike.getPrice()%></td>
    <td align="center"><%=bike.getType()%></td>
    <td align="center"><%=bike.getChengse()%></td>
    
</tr>  
</body>
</html>