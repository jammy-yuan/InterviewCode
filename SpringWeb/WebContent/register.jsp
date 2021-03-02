<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
</head>
<body>
<form action="${ctxPath }/User/register" method="post">
	用户名<input type="text" name="name">${error_name }<br><br>
	用户密码<input type="text" name="password">${error_password }<br><br>
	年龄<input type="text" name="age">${error_age }<br><br>
	<input type="submit" name="submit" value="register">
</form>
</body>
</html>