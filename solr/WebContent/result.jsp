<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查询结果</title>
</head>
<body>
<h1>this is your result of query：</h1>

 <c:forEach var="docs" items="${docList}" >
 <c:forEach var="doc" items="${docs}" begin="0" end="3">
 <p> <c:out value="${doc.key}"/>:<c:out value="${doc.value}"/></p>

 </c:forEach>
 <br>
 </c:forEach>


</body>
</html>