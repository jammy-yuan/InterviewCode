<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/AjaxDemo">
		账号：<input type="text" name="name" class="name"><span
			class="reg1"></span><br> <br> 密码：<input type="password"
			name="password" class="pass"><span class="reg2"></span><br>
		<br>
		<Button id="sp1">ajax操作</Button>
	</form>
</body>
</html>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
alert('1111');
$("#sp1").click(			
			function() {
				alert('22221');
				var name = $('.name').val();
				alert(name);
				var password = $('.pass').val();
				var json = {name : name,password : password};
				$('.reg1').load("/MyJSP/AjaxDemo", json,
						function(data, texts, XMLHttpRequest) {
							if (data == "账号已存在") {
								$('.reg1').html("用户已注册");
							}
						});
				$('.reg2').load("/MyJSP/AjaxDemo", json,
						function(data, texts, XMLHttpRequest) {
							if(data=="密码错误"){
								$('.reg2').html("密码错误");
							}else {
								alert("注册成功！");
							}
						});
			});

</script>