<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<style>
.form-item{
	font-size:18px; height:50px;
}
</style>

	<form action="${ctxPath}/User/login" method="post">
		<div class="form-item">
			<label>用户名</label>
			<input type="text" name="userName" />
		</div>
		<div class="form-item">
			<label>用户密码</label>
			<input type="text" name=passWord/>
		</div>
		<div class="form-item">
			<input type="submit" name="submit" />
		</div>
	</form>
	
	






