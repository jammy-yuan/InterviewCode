<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<style>
body{ background:#E2E2E2; }
a{ font-size:20px; display:block; }
</style>

<h2>当前用户 : ${user.username}&nbsp;&nbsp;&nbsp;${user.nickName}</h2>
<h2>id : ${user.dept.id}&nbsp;&nbsp;&nbsp;部门名称 : ${user.dept.deptName}</h2>

<a href="${ctxPath}/User/logout">
	用户登出
</a>

<c:forEach items="${user.roles}" var="role">
	<h2>
		角色 : ${role.id}
			&nbsp;&nbsp;
		${role.roleName}
			&nbsp;&nbsp;
		(${role.descript})
	</h2>
</c:forEach>

<a href="${ctxPath}/Cource/viewList">
	(1) /Cource/viewList ---- 需持有 [r01] 角色
</a>
<br/>
<a href="${ctxPath}/User/viewList">
	(2) /User/viewList ---- 需持有 [r02] 角色
</a>


