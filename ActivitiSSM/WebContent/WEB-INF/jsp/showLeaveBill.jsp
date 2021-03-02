<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctxPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form action="${ctxPath}/Work/doLeave" method="post">
		<!-- {ps} 流程的发起人: -->
		<div class="form-item">
			<label>发起人 ID</label> <input type="text" name="initcator"
				value="${user.id}" readonly />
		</div>
		<div class="form-item">
			<label>开始时间</label> <input type="text" name="startDate" />
		</div>
		<div class="form-item">
			<label>结束时间</label> <input type="text" name="endDate" />
		</div>
		<div class="form-item">
			<label>请假的原因</label> <input type="text" name="reason" />
		</div>
		<div class="form-item">
			<input type="submit" name="submit" />
		</div>
	</form>
</body>
</html>