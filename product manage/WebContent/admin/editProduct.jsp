<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="entity.*"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="productMgr" class="entity.productMgr" scope="application"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base href="<%=basePath%>">
<title>修改产品信息</title>
</head>

<body>
     
<form action="productEdit" method="post">
	 <%
         String brand = request.getParameter("brand"); 
	     String type = request.getParameter("type"); 
		 bycycle bike = productMgr.getproduct(brand, type); 
		 HttpSession s=request.getSession();
		 s.setAttribute("bike",bike);
		 
	 %>
*品牌：
<input type="radio" name="pinpai" value="GIANT" />捷安特（GIANT）&nbsp;&nbsp;
<input type="radio" name="pinpai" value="MERIDA" />美利达（MERIDA）&nbsp;&nbsp;
<input type="radio" name="pinpai"  value="EMMELLE"/>阿米尼（EMMELLE）&nbsp;&nbsp;
 <input type="radio" name="pinpai"  value="FOREVER"/>永久&nbsp;&nbsp;
<input type="radio" name="pinpai"  value="BATTLE"/>邦德富士达（BATTLE）&nbsp;&nbsp;
 <input type="radio" name="pinpai"  value="TREK"/>崔克（TREK）&nbsp;&nbsp;
 <input type="radio" name="pinpai"  value="Decathion"/>迪卡侬（Decathion）&nbsp;&nbsp;
 <input type="radio" name="pinpai"  value="GAMMA"/>捷马（GAMMA）&nbsp;&nbsp;
<input type="radio" name="pinpai"  value="Phoenix"/>凤凰（Phoenix）&nbsp;&nbsp;
<input type="radio" name="pinpai"  value="others"/>其他：
 <input type="text" size="10px" />  <br /><br />
                                                 
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*型号：
  <input type="radio" name="xinghao" value="20"/>20及以下&nbsp;&nbsp;&nbsp;
  <input type="radio" name="xinghao" value="22"/>22&nbsp;&nbsp;&nbsp;
  <input type="radio" name="xinghao" value="24"/>24&nbsp;&nbsp;&nbsp;
  <input type="radio" name="xinghao" value="26"/>26&nbsp;&nbsp;&nbsp;
  <input type="radio" name="xinghao" value="28"/>28&nbsp;&nbsp;&nbsp;
  <input type="radio" name="xinghao" value="30"/>30及以上<br /><br />
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  
  *成色：
  <input type="radio" name="chengse" value="9.9"/>9.9成新&nbsp;&nbsp;&nbsp;
  <input type="radio" name="chengse" value="9"/>9成新&nbsp;&nbsp;&nbsp;
  <input type="radio" name="chengse" value="8"/>8成新&nbsp;&nbsp;&nbsp;
  <input type="radio" name="chengse" value="7"/>7成新&nbsp;&nbsp;&nbsp;
  <input type="radio" name="chengse" value="6"/>6成新&nbsp;&nbsp;&nbsp;
  <input type="radio" name="chengse" value="5"/>5成新及以下<br /><br />
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  
  *类型：<input type="radio" name="leixing" />普通自行车&nbsp;&nbsp;&nbsp;<input type="radio" name="leixing" />山地车&nbsp;&nbsp;&nbsp;<input type="radio" name="leixing" />折叠车&nbsp;&nbsp;&nbsp;<input type="radio" name="leixing" />公路车&nbsp;&nbsp;&nbsp;<input type="radio" name="leixing" />其他：<input type="text" /><br /><br />
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  
  *价格：<input type="text" name="price" /><br /><br />
  
  *信息标题：<input type="text" name="lname" /><br /><br />
  
  详细介绍：<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<textarea cols="80" rows="5"/></textarea><br /><br />
  上传照片：<input type="file" name="uploadFile" /><br /><br />
 *联系电话：<input type="text" /><br /><br />
  &nbsp;&nbsp;&nbsp;
  联系QQ：<input type="text" /><br /><br />
  
  <input type="submit" value="提交" style="background:#FFCC33;" onClick="location.href='../admin/productMain.jsp'" /></p>
  
  <hr size="3" color="#FFCC33" width="80%"></hr><br /><br />
</form>
     


</body>
</html>