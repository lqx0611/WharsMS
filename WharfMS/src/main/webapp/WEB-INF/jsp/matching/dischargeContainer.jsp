<%--
  Created by IntelliJ IDEA.
  User: DUMBLEDOG
  Date: 2020/5/10 23:01
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
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${ctxPath}/layui/css/layui.css"  media="all">

</head>
<style>
    #form1{
        font-weight: bold;
        position: absolute;
        top: 15%;
        left: 5%;
    }
</style>
<script src="${ctxPath}/js/jquery-1.11.1.min.js"></script>
<script>
    function LoadPage(retPage) {
        window.location = '${ctxPath}'+ retPage;
    }
    function doSubmit(){
        $.ajax({
            url : '${ctxPath}/Matching/dischargeContainer',
            type : 'POST', // 请求方式
            data : $('#form1').serialize(),
            dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
            beforeSend : function(xhr) {
                console.log('----发送前---');
                console.log(xhr);
                console.log('----发送前---');
            },
            success : function(resp) {
                console.log(resp);
                var ret= resp['result'];
                var retPage = resp['resultPage'];
                if( ret=='success' ){
                    layer.msg( resp['msg'] );
                    //{1} 重定向到它给的地址。
                    setTimeout(LoadPage(retPage),1500);
                }else{
                    //{2} 提示用户错误 (LayUI 的方法)。
                    layer.msg( resp['msg'] );
                }
            }
        })
    }
</script>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>货柜卸载</legend>
</fieldset>
<%--action="${ctxPath}/Matching/loadContainer" method="post"--%>
<form id="form1"class="layui-form" action="" >
    <div class="layui-form-item">
        <label class="layui-form-label">卸货船只</label>
        <div class="layui-input-block">
            <select name="shipNo" lay-verify="required" lay-reqtext="请选择船只！">
                <option value=""></option>
                <c:forEach items="${listShip}" var="listShip">
                    <option value="${listShip.no}">${listShip.no}-${listShip.name}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">卸货到仓库</label>
        <div class="layui-input-block">
            <select name="repositoryId" lay-verify="required" lay-reqtext="请选择仓库！">
                <option value=""></option>
                <c:forEach items="${listLandRepository}" var="listLR">
                    <option value="${listLR.id}">${listLR.name}-${listLR.containerType}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">货柜id</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" name="idMin"  autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid">-</div>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" name="idMax"  autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="button" class="layui-btn" lay-submit="" onclick="doSubmit();">确认</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script src="${ctxPath}/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            title: function(value){
                if(value.length < 5){
                    return '标题至少得5个字符啊';
                }
            }
            ,pass: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
            ,content: function(value){
                layedit.sync(editIndex);
            }
        });

        //监听指定开关
        form.on('switch(switchTest)', function(data){
            layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });

        //监听提交
        form.on('submit(demo1)', function(data){
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })
            return false;
        });

        //表单赋值
        layui.$('#LAY-component-form-setval').on('click', function(){
            form.val('example', {
                "username": "贤心" // "name": "value"
                ,"password": "123456"
                ,"interest": 1
                ,"like[write]": true //复选框选中状态
                ,"close": true //开关状态
                ,"sex": "女"
                ,"desc": "我爱 layui"
            });
        });

        //表单取值
        layui.$('#LAY-component-form-getval').on('click', function(){
            var data = form.val('example');
            alert(JSON.stringify(data));
        });

    });
</script>
</body>
</html>
