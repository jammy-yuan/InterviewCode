<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<script src="${ctxPath}/js/jquery-3.1.1.js"></script>

<!-- 
	/login.jsp?error=1
 -->
 
 	<script>
	 	<c:if test="${param['error']==1}">
	 		alert("你需要先登陆 ..");
	 	</c:if>
 	</script>

	<form action="${ctxPath}/User/login" method="post">
	 	用户名称: <input type="text" name="name" /> <br/><br/>
		用户密码: <input type="text" name="password" /> <br/><br/>
		<input type="submit" value="用户登录" />
	</form>
