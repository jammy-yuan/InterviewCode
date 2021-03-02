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

<!-- 
	{ps} 当前表单将会提交到:
		WorkController.doLeave() 方法中...
	
	{ps} 这里要收集请假的相关信息, 并封装到  Leave 对象中
		 public String doLeave( Leave leave ){ .. }
	
	明确一下, 我们要提交的信息:
	(1) 提交谁请假 (暂时是无效, 因为流程文件已写死了)
		initcator: 流程的发起人
		
	(2) 请假的开始时间
		startDate
		
	(3) 请假的结束时间
		endDate
		
	(4) 请假的原因
		reason
		
	{ps} 去 com.gec.domain.Leave 类中设置上述的内容...	
		
 -->

	<form action="${ctxPath}/Work/doLeave" method="post">
		<!-- {ps} 流程的发起人:  -->
		<div class="form-item">
			<label>发起人 ID</label>
			<input type="text" name="initcator" value="${user.id}" readonly />
		</div>
		
		<div class="form-item">
			<label>开始时间</label>
			<input type="text" name="startDate" />
		</div>
		
		<div class="form-item">
			<label>结束时间</label>
			<input type="text" name="endDate" />
		</div>
		
		<div class="form-item">
			<label>请假的原因</label>
			<input type="text" name="reason" />
		</div>
		
		<div class="form-item">
			<input type="submit" name="submit" />
		</div>
	</form>






