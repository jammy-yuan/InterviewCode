<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/UploadServlet" method="post" enctype="multipart/form-data">
		文件描述<input type="text" name="filedesc"><br>
		<br> 上传文件<input type="file" name="myfile"> <br>
		<br> <input type="submit" value="上传">
		<input type="button" value="添加" onclick=run()>
		<div id="div"></div>
	</form>
</body>
</html>
<script type="text/javascript" src="jquery-easyui-1.7.6/jquery.min.js"></script>
<script>
function run(){
	$('#div').html()+="";
}

</script>