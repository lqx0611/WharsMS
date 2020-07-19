<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${ctxPath}/layui/css/layui.css"  media="all">
</head>
<style>
    html,body{
        width:100%;
        height:100%;
    }
    body{
        background: url("${ctxPath}/images/loginBG.jpg") ;
        background-size: 100%;
    }
    label{
        font-weight: bold;
    }
    #login {
        font-weight: bold;
        position: absolute;
        top: 30%;
        left: 35%;
}
    #divBG{
        width: 800px;height: 400px;
        background-color: white;
        opacity: 0.5;
        position: absolute;
        top: 25%;
        left: 24%;
    }
    #notify{
        font-size: 20px;
        position: absolute;
        top: 5%;
        left: 90%;
    }
    span{
        color:red;
    }
</style>

<body>

<!--
	{ps} 登录验证
	<script src="${ctxPath}/js/verify.js"></script>
 -->
<div id="divBG"></div>
<div id="notify">
    <a href="${ctxPath}/Notify/showNotifyList" >查看公告</a>
</div>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend> 欢迎使用 </legend>
</fieldset>
<div id="login">
    <h1>码头船只出行及其配套货柜管理系统</h1><br/><br/><br/>
    <form class="layui-form" action="${ctxPath}/User/login" id="form">
        <div class="layui-form-item">
            <label class="layui-form-label">用户账户</label>
            <div class="layui-input-inline" >
                <input type="text" id="account" name="account"
                       lay-verify="title"
                       autocomplete="off" placeholder="请输入用户账户"
                       class="layui-input wd-450" ><span></span>
            </div>
            <div class="layui-input-inline" >
                <span id="span1"></span>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" >用户密码</label>
            <div class="layui-input-inline">
                <input type="password" id="password" name="password"
                       lay-verify="password"
                       autocomplete="off" placeholder="请输入用户密码"
                       class="layui-input wd-450"><span></span>

            </div>
            <div class="layui-input-inline" >
                <span id="span2"></span>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <input name="roleId" title="系统管理员" type="radio" value="1">
                <input name="roleId" title="普通管理员" type="radio" checked="" value="2">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="button" id="bt1" class="layui-btn" >登录</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

<script src="${ctxPath}/js/jquery-1.11.1.min.js"></script>
<script src="${ctxPath}/layui/layui.js" charset="utf-8"></script>
<script>
    // 按钮绑定点击事件
    $('#bt1').click(function () {
        let $name=$('#account');
        let $pwd=$('#password');
        let $span1=$('#span1');
        let $span2=$('#span2');
        // 按钮点击后检查输入框是否为空，为空则找到span便签添加提示
        if ($name.val().length===0)
        {
            $span1.text('账号不能为空')
            // $name.next().text('账号不能为空')
        }
        if($pwd.val().length===0)
        {
            $span2.text('密码不能为空')
          //  $pwd.next().text('密码不能为空')
        }
        if($pwd.val().length!=0 && $name.val().length!=0){
            document.getElementById('form').submit();
        }
    });
    // 给输入框添加时间，获取焦点时,将span标签中的内容设置成空
    $('.layui-input').focus(function () {
        $(this).next().text('');
    })
    $('#account').focus(function () {
        $('#span1').text('');
    })
    $('#password').focus(function () {
        $('#span2').text('');
    })
</script>
<script>
    layui.use(
        ['form', 'layedit', 'laydate'],
        function(){
            //var msg ="<%=session.getAttribute("msg")%>";
            //layer.msg(msg);
            console.log('{DEBUG} layui.user...');
        }
    );
</script>

</body>
</html>