<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="/Test/AjaxServlet1" id="form1">
			账号：<input type="text" name="name" class="text"><br>
			<br> 密码：<input type="password" name="password" class="text"><br>
			<br> 验证码：<input type="text" name="check" class="text2"><br>
			<br> 
		</form>
		<button>注册</button>
</body>
</html>
<script type="text/javascript" src="jquery-easyui-1.7.6/jquery.min.js"></script>
<script>
$('button').click(function(){
	var json=$('#form1').serialize();
	$.post("/Test/AjaxServlet1", json,
			function(data, XMLHttpReuest) {
		alert(data);
    });
})
</script>