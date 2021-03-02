<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
		<c:forEach items="${list}" var="li" varStatus="num1">
			<img src="img/${li.name}"> <span>￥${m1.price}</span>
			<c:if test="${num1.count%4==0}">
				<br>
			</c:if>
		</c:forEach>
</body>
</html>