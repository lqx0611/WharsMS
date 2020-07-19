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
    </style>
</head>
<br>
<h1>测试页面</h1>

<a href="${ctxPath}/User/test"> 测试 mvc /User/test</a><br/><br/>

<a href="${ctxPath}/User/showLogin"> 测试 登录页面 /User/showLogin</a><br/><br/>

<a href="${ctxPath}/User/showAddUser"> 直接去增加用户，测试拦截 /User/showAddUser</a><br/><br/>

<a href="${ctxPath}/User/showUserList"> 用户列表测试 /User/showUserList</a><br/><br/>

<a href="${ctxPath}/Ship/shipList"> 船只列表测试 /Ship/shipList</a><br/><br/>

<a href="${ctxPath}/addShipTest.jsp"> 增加船只测试 /addShipTest.jsp</a><br/><br/>

<a href="${ctxPath}/putToRepositoryTest.jsp"> 码放货柜测试 /putToRepositoryTest.jsp</a><br/><br/>


</body>
</html>
