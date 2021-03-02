<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<style>
body, a, input {
	font-size:23px;
}
</style>

<h1>OA 管理系统</h1>

<h2>当前用户 : ${user.username}&nbsp;&nbsp;&nbsp;昵称 : ${user.nickname}</h2>
<h2>id : ${user.dept.id}&nbsp;&nbsp;&nbsp;部门名称 : ${user.dept.deptname}</h2>

<a href="${ctxPath}/index">
	用户登出
</a>

<c:forEach items="${user.roles}" var="role">
	<h2>
		角色 : ${role.id}
			&nbsp;&nbsp;
		${role.rolename}
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

<!-- {ps} 填写请假单
	/Work/showLeaveBill
 -->
<div>
	<a href="${ctxPath}/Work/showLeaveBill">
		我要请假
	</a>
</div>

	<div>
		<a href="${ctxPath}/Work/queryMyTask?assignee=${user.id}">
			查看我的任务
		</a>
	</div>
	
	
	
	

<script>
function doQryTask( who ){
	var form = document.getElementById('qryTask');
		var assignee = document.getElementById('assignee');
		assignee.value = who;
		alert( '查询'+ who +'的任务...' );
		form.submit();
	}

</script>

<form id="qryTask" method="post" 
	action="${ctxPath}/Work/queryMyTask">
	<input id="assignee" name="assignee" type="hidden" />
</form>








