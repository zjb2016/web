<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="entity.item" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>order Mgr</title>
</head>
<body>
<h1>订单管理</h1>

   <p>订单时间：${deal["date"]}</p>
    <p>买家电话：${deal.buyer}</p>
     <p>卖家电话：${deal.owner}</p>
      <p>商品编号：${deal.bycycleID}</p>
</body>
</html>