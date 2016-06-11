<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="entity.*"%>

<jsp:useBean id="productMgr" class="entity.productMgr" scope="application"/>
<%
String path = request.getContextPath();//product Manage:
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
       <meta http-equiv="content-Type" content="text/html;charset=UTF-8">
        <base href="<%=basePath%>">
        <title>产品管理</title>
        <style type="text/css">
#customers
  {
  font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
  width:100%;
  border-collapse:collapse;
  }

#customers td, #customers th 
  {
  font-size:1em;
  border:1px solid #98bf21;
  padding:3px 7px 2px 7px;
  }

#customers th 
  {
  font-size:1.1em;
  text-align:left;
  padding-top:5px;
  padding-bottom:4px;
  background-color:#A7C942;
  color:#ffffff;
  }

#customers tr.alt td 
  {
  color:#000000;
  background-color:#EAF2D3;
  }
</style>
  </head>
 
   
  <body>

  <form  method="post" action="productSearch">

  
   	<label>
  	       请输入搜索内容：<input type="text" name="condition">
  	</label>
	<label>
	                  <input type="submit" name="Submit" value="提交">
	</label>
</form>	

<div>
 <input type="button" align="right" value="添加产品" onClick="location.href='../sellbike.html'">
</div>

<form  method="post" action="productDelete">
  <table id="customers">
    <tr>
        <th>品牌</th>
        <th>价格</th>
        <th>型号</th>
        <th>成色</th>
        <th>编辑</th>
        <th>删除</th>
    </tr>
<%
	java.util.HashMap<String,bycycle> bikemap = new java.util.HashMap<String,bycycle>();
	bikemap = productMgr.getProductList();
	java.util.Iterator iterator =  bikemap.keySet().iterator();

	while(iterator.hasNext()){
		bycycle product = (bycycle)bikemap.get(iterator.next());
		
		String brand=product.getBrand();
		String type=product.getType();
		String chengse=product.getChengse();
		String price=product.getPrice();
%>
  <tr>
        <td ><%=brand%></td>
        <td ><%=price%></td>
        <td ><%=type%></td>
        <td ><%=chengse%></td>
        <td >
            <input type="button" align="right" value="编辑" onClick="location.href='../admin/editProduct.jsp?brand=<%=brand%>&type=<%=type%>'">
        </td>  
        <td >
            <a href="productDelete?brand=<%=brand%>&type=<%=type%>" onclick='return window.confirm("您确实要删除用户吗？")'>删除</a>
        </td>
    
  </tr>
  <%
  	}
  %>
  </table>
</form>	
  </body>


</html>
