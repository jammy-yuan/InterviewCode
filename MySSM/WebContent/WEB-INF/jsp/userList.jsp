<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
UserController: TUser [id=1, userName=Marry, passWord=123, age=20, weight=50.2]<br/>
UserController: TUser [id=2, userName=andy, passWord=123, age=30, weight=40.8]<br/>
<body>
	<c:forEach items="${users}" var="user">
		${user.userName},${user.passWord},${user.age}</br>
	</c:forEach>
</body>
</html>