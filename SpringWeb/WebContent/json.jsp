<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<script src="${ctxPath}/js/jquery-3.1.1.js"></script>
<script>
function testJson(){
	alert("---------testJson (1)---------");
	$.ajax(
		{
			url:"${ctxPath}/User/getJson",
			type:"GET",
			dataType:"json",
			success:function( data ){
				console.log( data );
			}
		}
	);
	alert("---------testJson (2)---------");
}
</script>

<input type="button" value="测试 json 获取" 
	
	onclick="testJson();" />