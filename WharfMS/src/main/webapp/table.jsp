<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctxPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<style>
    html,body{
        width:100%;
        height:100%;
    }
    body{
        background: url("${ctxPath}/images/table.jpg") ;
        background-size: 100%;
    }
img {
 width:100%;
 height:100%;
}
</style>
<body>
<%--<img src="${ctxPath}/images/table.jpg">--%>
</body>
</html>
