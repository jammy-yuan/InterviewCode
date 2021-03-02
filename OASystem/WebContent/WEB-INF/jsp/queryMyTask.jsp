<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<style>
body, a, input {
	font-size:23px;
}
table { border-collapse: collapse; border:2px solid #666; }
table td{
	border:1px solid #666;
	height:55px;
}
td:nth-child(1){ width:120px; }
td:nth-child(2){ width:120px; }
td:nth-child(3){ width:150px; }
td:nth-child(4){ width:160px; }
td:nth-child(5){ width:160px; }

</style>

<script>
<!-- 办理任务失败 ... -->
<c:if test="${param['errcode']=='1'}">
	alert( "办理任务失败.." );
</c:if>

<c:if test="${param['errcode']=='0'}">
	alert( "办理任务成功.." );
</c:if>

</script>


<h1>当前页: /jsp/queryMyTask.jsp</h1>

<h3>当前用户: ID: ${user.id}  userName: ${user.username}</h3>

<table>
	<tr>
		<td>任务ID</td>
		<td>创建日期</td>
		<td>流程实例ID</td>
		<td>操作(1)</td>
		<td>操作(2)</td>
	</tr>
	<c:forEach items="${list}" var="task">
		<tr>
			<td>${task.id}</td>
			<td>
				<!-- task.createTime -->			
				----
			</td>
			<td>${task.processInstanceId}</td>
			<td>
				<a href="${ctxPath}/Work/viewTaskInfo?taskId=${task.id}">
					查看详情
				</a>
			</td>
			<td>
				<a href="${ctxPath}/Work/finishMyTask?taskId=${task.id}">
					确认申请
				</a>
			</td>
		</tr>
	</c:forEach>
</table>
	


