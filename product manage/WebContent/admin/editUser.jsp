<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="entity.*"%>
<jsp:useBean id="userMgr" class= "entity.UserMgr" scope="application" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>编辑用户</title>

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
	<p>系统管理-&gt;用户管理-&gt;编辑用户</p>
	<form name="addUserform" method="post" action="UserServlet">
		<input name="operation" type="hidden" id="operation" value="edit">
		<%
         String username = request.getParameter("username"); 
   		 User user = userMgr.getUser(username);
     %>
		<table width="95%" height="389" border="0">
			<tr>
				<td>&nbsp;</td>
				<td>用 户 名：
				 <label> <input name="username" type="text"
						        id="username" value="<%=username%>" readonly="true">
				</label></td>
				<td>&nbsp;</td>
			</tr>
			
			<tr>
				<td>&nbsp;</td>
				<td>用户类型： <label> <select name="userType">
							<option value="0"
								<% 
        if(user.getUserType() == 0)
        	out.print("selected=\"true\"");
        %>>买家</option>
							<option value="1"
								<% 
        if(user.getUserType() == 1)
        	out.print("selected=\"true\"");
        %>>卖家</option>
							<option value="2"
								<% 
        if(user.getUserType() == 2)
        	out.print("selected=\"true\"");
        %>>管理员</option>
					</select>
				</label></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>真实姓名： <label> <input name="realname" type="text"
						id="realname" value="<%=user.getRealname()%>">
				</label></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>性 别： <label> <select name="sex">
							<option value="1"
								<%
           if(user.getSex() ==1)
        	 out.print("selected=\"true\"");
         %>>男</option>
							<option value="0"
								<%
           if(user.getSex() ==0)
        	 out.print("selected=\"true\"");
         %>>女</option>
					</select>
				</label></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><label> <input type="submit" name="Submit"
						value="提交">
				</label></td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</form>
	<p>
		<br>
	</p>
</body>
</html>
