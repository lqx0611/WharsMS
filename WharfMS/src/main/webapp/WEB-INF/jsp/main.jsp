<%--
  Created by IntelliJ IDEA.
  User: DUMBLEDOG
  Date: 2020/5/1 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>码头管理系统</title>
    <link rel="stylesheet" href="${ctxPath}/layui/css/layui.css">
</head>
<style>
    #primaryWin{
        width:100%; height:100%;
    }
</style>
<script>
    function showPage( urlLink ){
        //{1} 获取一个 内联框架组件, id="primaryWin"
        var win = document.getElementById( "primaryWin" );
        //urlLink = "/User/userList", 其它 ...
        win.src = '${ctxPath}'+ urlLink;
    }
</script>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo" >码头管理系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <%--   <li class="layui-nav-item"><a href="">商品管理</a></li>--%>
            <%--   <li class="layui-nav-item"><a href="">用户</a></li>--%>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">

                <a href="javascript:;">
                    <img src="${ctxPath}/images/head.jpg" class="layui-nav-img">
                    系统管理员${user.name}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="${ctxPath}/User/logout">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">船只管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="#" onclick="showPage('/Ship/showShipList');">船只信息列表</a></dd>
                        <dd><a href="#" onclick="showPage('/Ship/showAddShip');">船只停泊</a></dd>
                        <dd><a href="#" onclick="showPage('/Ship/showShipRoute');">船只路线</a></dd>
                        <dd><a href="#" onclick="showPage('/Ship/showShipPullOut');">船只出行</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">货柜管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="#" onclick="showPage('/Container/showContainerList');">货柜列表</a></dd>
                        <dd><a href="#" onclick="showPage('/Container/showPutToRepository');">货柜码放</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">船只与货柜</a>
                    <dl class="layui-nav-child">
                        <dd><a href="#" onclick="showPage('/Matching/showLoad');">装载货柜</a></dd>
                        <dd><a href="#" onclick="showPage('/Matching/showDischarge');">卸载货柜</a></dd>

                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">公告管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="#" onclick="showPage('/Notify/showUploadNotify');">发布新公告</a></dd>
                        <dd><a href="#" onclick="showPage('/Notify/showNotifyList');">查看公告</a></dd>
                    </dl>
                </li>

            </ul>
        </div>
    </div>

    <div class="layui-body">
        <iframe id="primaryWin" src="${ctxPath}/table.jsp"
                frameborder="0" scrolling="no"></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © www.DUMBLEDOG.com - 毕业设计
    </div>
</div>
<script src="${ctxPath}/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>
