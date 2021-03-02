<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div style="heigth:1000px;border-bottom:1px solid gray">
<span>头部</span>
<span>头部</span>
<span>头部</span>
<span>头部</span>
<%--向指定域存取对象 --%>
<% pageContext.setAttribute("name", "zs",PageContext.REQUEST_SCOPE); %>
<%=request.getAttribute("name") %>
<%=pageContext.findAttribute("name") %>
</div>
