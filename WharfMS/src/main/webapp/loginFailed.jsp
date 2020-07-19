<%--
  Created by IntelliJ IDEA.
  User: DUMBLEDOG
  Date: 2020/5/1 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <style>
        html,body{
            width:100%;
            height:100%;
        }
        body{
            background: url("${ctxPath}/images/loginBG.jpg") ;
            background-size: 100%;
        }
        img{
            width: 800px;
            height: 800px;
        }
    </style>
</head>
<br>
<h1>登录失败测试页面</h1>
<a href="${ctxPath}/User/test"> 测试 mvc</a><br/><br/>
<a href="${ctxPath}/User/showLogin"> 测试 登录页面</a><br/><br/>
</body>
</html>
