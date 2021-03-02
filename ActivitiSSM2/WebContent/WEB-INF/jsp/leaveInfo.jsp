<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<!-- 
	ins.getId()
	ins.getProcessInstanceId();
	ins.getProcessVariables();
 -->
 
	 <h1>请假流程开启 (但发起人未提交)</h1>
	 <h1>流程实例ID: ${ instance.id }</h1>
	 
	 
	 
