<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--    c标签要使用,那么就必须要有它 ${pageContext.request.contextPath}-->
 
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set scope="page" var="url"
    value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>My JSP 'MyJsp.jsp' starting page</title>    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
  </head>  
  <body>
   <form action="selecttemplate" method="post">  
<table>  
<tr><td>原始密码</td><td><input type="text" name="question_id"></td></tr>  
<tr><td>新密码</td><td><input type="text" name="psw"></td></tr>  
<tr><td>新密码</td><td><input type="text" name="direction"></td></tr> 
<tr><td colspan="2" align="center"><input type="submit"  value="登陆"></td></tr>  
</table>  
</form>  
  </body>
</html>