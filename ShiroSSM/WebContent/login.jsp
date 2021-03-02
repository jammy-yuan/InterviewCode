<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<h1>欢迎使用 OA 系统</h1>
<h1>
	此表单将会提交到:
	Link: ${ctxPath}/User/login
</h1>
<%
	Map<String,String> _msg = new HashMap<String,String>();
	_msg.put("1", "此用户不存在");
	_msg.put("2", "密码错误");
	_msg.put("3", "当前用户已锁定");
	//{ps} 设置到请求域 ...
	request.setAttribute( "msg", _msg );
%>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>注册页</title>
    <link rel="stylesheet" href="${ctxPath}/static/layui/css/layui.css">
</head>
<style>
.login-frame{
	width:420px; height:300px;
	border:1px solid #666;
	padding:20px;
}

.login-frame{   
	position: absolute;
	top: 50%; left: 50%;
	margin-top: -100px;
	margin-left: -200px;
}
body{ background:#333; }
.login-frame{ background:#E2E2E2; }
</style>

<body>
<script src="${ctxPath}/static/js/jquery-1.11.1.min.js"></script>
<script src="${ctxPath}/static/layui/layui.js"></script>

<script>
$( init );
function init(){
	$("#submit").click(
		function(){
			$("#userForm").submit();
		}
	);
}
</script>

	<div class="login-frame">
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
			<legend>用户登录</legend>
		</fieldset>
		<form id="userForm" class="layui-form" action="${ctxPath}/User/login">
			<div class="layui-form-item">
			
				<label class="layui-form-label">用户帐号</label>
				<div class="layui-input-block">
					<input type="text" name="username" lay-verify="title" autocomplete="off" 
						placeholder="请输入用户帐号" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">用户密码</label>
				<div class="layui-input-block">
				<input type="text" name="password" lay-verify="required" 
					lay-reqText="用户密码是必填项, 岂能为空 ?" 
					placeholder="请输入用户密码" 
					autocomplete="off" class="layui-input">
				</div>
			</div>
		  
			<div class="layui-form-item" style="margin-top:25px;">
				<div class="layui-input-block">
					<button class="layui-btn" id="submit" 
						lay-submit lay-filter="demo1">确认登录</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置表单</button>
				</div>
			</div>
			
		</form>
	<div>

<script>
<!-- 提示: Eclipse 在这里报错不一定是有问题。 -->
<c:if test="${not empty param['errcode']}">
	alert( "${msg[ param['errcode'] ]}" );
	//layer.msg( "${msg[ param['errcode'] ]}" );
</c:if>
</script>



