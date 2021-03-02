<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>文件上传</h1>
	<form action="${pageContext.request.contextPath }/UploadServlet" method="post" enctype="multipart/form-data">
		文件描述<input type="text" name="filedesc"><br>
		<br> 上传文件<input type="file" name="myfile"> <br>
		<br> <input type="submit" value="上传">
	</form>
</body>
</html>