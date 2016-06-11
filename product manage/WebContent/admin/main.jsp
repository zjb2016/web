<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="entity.*"%>
<jsp:useBean id="userMgr" class="entity.UserMgr" scope="application"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
   
  <body>
  <p>系统管理-&gt;用户管理-&gt;用户列表
    <br>
  </p>
  <form name="searchForm" method="post" action="userSearch">

  	 请选择搜索条件： <select name="searchType">
  	    <option value="0">用户名</option>
  	    <option value="1">用户类型</option>
    </select>
   	<label>
  	请输入搜索内容：<input type="text" name="searchInput">
  	</label>
	<label>
	   
	   <input type="submit" name="Submit" value="提交">
	</label>
	

<p></p>
  
  用户列表：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

 <input type="button" align="right" value="添加用户" onClick="location.href='../admin/addUser.jsp'">
  <table width="95%" height="125" border="1">
    <tr>
      <th width="15%" height="46" bgcolor="#FFcc33" scope="col">用户名</th>
       <th width="15%" height="46" bgcolor="#FFcc33" scope="col">密码</th>
       <th width="15%" height="46" bgcolor="#FFcc33" scope="col">真实姓名</th>
        <th width="15%" height="46" bgcolor="#FFcc33" scope="col">性别</th>
      <th  width="15%" bgcolor="#FFcc33" scope="col">用户类型</th>
      <th  width="15%" bgcolor="#FFcc33" scope="col">编辑</th>
      <th  width="15%" bgcolor="#FFcc33" scope="col">删除</th>
    </tr>
     <%
	java.util.HashMap<String,User> usermap = new java.util.HashMap<String,User>();
	usermap = userMgr.getUserList();
	java.util.Iterator iterator = usermap.keySet().iterator();

	while(iterator.hasNext()){
		User user = (User)usermap.get(iterator.next());
		int userType = user.getUserType();
		String userTypeName = "";
		
		switch(userType){
		case 0:
			userTypeName = "买家";
			break;
		case 1:
			userTypeName = "卖家";
			break;
		case 2:
			userTypeName = "管理员";
			break;
		}
%>
      <tr>
    <td align="center"><%=user.getUsername()%></td>
    <td align="center"><%=user.getPassword()%></td>
    <td align="center"><%=user.getRealname()%></td>
     <td align="center">
     <%
        if(user.getSex() ==1){
            out.println("男");
        }
        if(user.getSex() ==0){
            out.println("女");
        }
     %>
     </td>
    <td align="center"><%=userTypeName%></td>
    <td align="center">
     <input type="button" align="right" value="编辑" onClick="location.href='../admin/editUser.jsp?username=<%=user.getUsername()%>'">
     </td>  
    <td align="center">
 
     <a href="UserServlet?operation=del&username=<%=user.getUsername()%>&userType=<%=userType %>" onclick='return window.confirm("您确实要删除用户吗？")'>删除</a>
    </td>
    
  </tr>
  <%
  	}
  %>
  </table>
</form>
  </body>
</html>
