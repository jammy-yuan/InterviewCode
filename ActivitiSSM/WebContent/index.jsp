<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctxPath" value="${pageContext.request.contextPath}" />
<style>
body {
	font-size: 23px;
}
</style>

<h1>OA 管理系统</h1>

<a href="${ctxPath}/login.jsp">我要登录</a>
<br />
<br />

<!-- 
		{1} 对应的控制器方法:
			WorkController: deployProcDef
		{2} 访问地址:
			/Work/deployProcDef
	 -->
<a href="${ctxPath}/Work/deployProcDef"> 布署请假流程定义 BPMN </a>
<br />
<br />
