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

<h1>用户名: ${user.userName}</h1>
<h1>角色名称: ${user.roleName}</h1>

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








