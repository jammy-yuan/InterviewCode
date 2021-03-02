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
	<table style="text-align:center">
		<tr>
			<c:forEach items="${list}" var="li" varStatus="num1">
				<td>
					<div>
						<img src="img/${li.name}" style="width: 200px">
						<p>${li.name}</p>
						<p style="color: red">￥${li.price}</p>
					</div>
				</td>
				<c:if test="${num1.count%3==0}">
					<tr>
				</c:if>
			</c:forEach>
		</tr>
	</table>
</body>
</html>