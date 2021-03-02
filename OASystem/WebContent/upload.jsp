<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctxPath" value="?{pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>上传流程文件页面</h3>
<form action="${ctxPath}/Work/doUpload" id="fileForm" 
	method="post" enctype="multipart/form-data">
	选择文件：
	<input id="file" type="file" name="zipFile"><br/><br/>
	<input type="button" name="btnUpload" value="upload" onclick="checkSubmit();"/>
</form>
</body>
</html>
<script src="${ctxPath}/static/js/jquery-1.11.1.min.js"></script>
<script>
	function checkSubmit(){
		var file=getE("file");
		if(file.value==''){
			alert('请选择文件');
			return;
		}
		var form=getE('fileForm');
		form.submit();
	}
	function getE(id){
		return document.getElementById(id);
	}
</script>