<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%--获得当前项目名 --%>
${pageContext.request.contextPath}
<%
Cookie cookie=new Cookie("pass","123");
response.addCookie(cookie);
%>
<%--获得cookie的值 --%>
${cookie.pass.value }
</body>
</html>