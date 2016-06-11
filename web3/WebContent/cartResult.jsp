<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="entity.item" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Shooping cart</title>
</head>
<body>
<h1>您的购物车清单</h1>

 <c:forEach var="i" items="${mycart}">
 <tr>   
   <td>品牌:<c:out value="${i.brand}" default="其他"/> </td>   
   <td>数量: <c:out value="${i.num}" default="1"/> </td> 
   <td>价格: <c:out value="${i.price}" default="未知"/> </td>   
   <td>型号: <c:out value="${i.type}" default="未知"/> </td>  
 </tr> 
 </br>
 </c:forEach>
  

 
</body>
</html>