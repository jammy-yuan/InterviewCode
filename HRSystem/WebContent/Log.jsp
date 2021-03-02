<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0px;
	padding: 0px;
}

body {
	position: relative;
}

div {
	position: absolute;
	width: 450px;
	height: 250px;
	margin: -500px 850px;
	border: 1px solid black;
	background-color: white;
	padding: 20px 20px;
}

#img {
	width: 100%;
	height: 750px;
}

.text {
	width: 200px;
	height: 26px;
}

.text2 {
	width: 120px;
	height: 26px;
}
</style>
</head>
<body>
	<img src="img/1.jpg" id="img">
	<div id="login">
		<form action="/HRSystem/ConnectJSP">
			账号：<input type="text" name="name" class="text"><br>
			<br> 密码：<input type="password" name="password" class="text"><br>
			<br> 验证码：<input type="text" name="check" class="text2">
			<img alt="图片飞了" src="/HRSystem/CheckCokeUtil" id="img2"> <span
				id="a"><a href="#" style="font-size: 15px">看不清，换一张</a></span><br>
			<br> <input type="submit" value="登录"> <br>
		</form>		
		<button style="margin-top: 15px">免费注册</button>
	</div>
	<div style="display:none" id="register">
	<form action="/HRSystem/RegisterServlet">
			账号：<input type="text" name="newname" id="username" class="text"><span id="reg1" style="color:red"></span><br><br> 
			密码：<input type="password" name="newpassword"  id="pwd" class="text"><span id="reg2"></span><br><br>
			确认密码：<input type="password" name="newpassword2"  id="pwd2" class="text"><span id="reg3"></span><br><br>
			 验证码：<input type="text" name="newcheck" class="text2" id="reg">
			<img alt="图片飞了" src="/HRSystem/CheckCokeUtil" id="img3">
			<span id="a2"><a href="#" style="font-size: 15px">看不清，换一张</a></span><br>
			<span id="reg4"></span><br>
			<input type="submit" value="注册"><br><br>
		</form>
	</div>
</body>
</html>
<script type="text/javascript" src="jquery-easyui-1.7.6/jquery.min.js"></script>
<script>
	var a = 1;
	setInterval(function() {
		if (a % 2 == 0) {
			$('#img').attr("src", "img/1.jpg");
		} else {
			$('#img').attr("src", "img/2.jpg");
		}
		a++;
	}, 3000)

	$('#a').click(function() {
			$('#img2').attr("src","/HRSystem/CheckCokeUtil?time="+ new Date().getTime());
	});
	$('#a2').click(function() {
		$('#img3').attr("src","/HRSystem/CheckCokeUtil?time="+ new Date().getTime());
});
	$('button').click(function(){
		$('#login').css("display","none");
		$("#register").css("display","block");
	});
	$("#username").mouseleave(			
			function() {
				var json = {
					username : $("#username").val()
				};
				$("#reg1").load("/HRSystem/RegisterServlet", json,
						function(data, texts, XMLHttpReuest) {
			           });
			});

</script>