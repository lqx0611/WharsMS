<%--
  Created by IntelliJ IDEA.
  User: DUMBLEDOG
  Date: 2020/5/3 23:53
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
    <link rel="stylesheet" href="${ctxPath}/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>


<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>船只停泊</legend>
</fieldset>

<form class="layui-form" action="${ctxPath}/Ship/addShip" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">ID</label>
        <div class="layui-input-block">
            <input name="id" class="layui-input" type="text" placeholder="请输入id" autocomplete="off" lay-verify="required" lay-reqtext="ID是必填项，不能为空！"  >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">船只编号</label>
        <div class="layui-input-block">
            <input name="no" class="layui-input" type="text" placeholder="请输入编号" autocomplete="off" lay-verify="required" lay-reqtext="编号是必填项，不能为空！"  >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">公司</label>
        <div class="layui-input-block">
            <input name="company" class="layui-input" type="text" placeholder="请输入公司名" autocomplete="off" lay-verify="required" lay-reqtext="公司是必填项，不能为空！"  >
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">船只类型</label>
            <div class="layui-input-inline">
                <select name="type" lay-search="" lay-verify="required">
                    <option value="">直接选择或搜索选择</option>
                    <option value="小型货轮">小型货轮</option>
                    <option value="中型货轮">中型货轮</option>
                    <option value="大型货轮">大型货轮</option>
                </select>
            </div>
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">船名</label>
            <div class="layui-input-inline">
                <input name="name" class="layui-input" type="tel" autocomplete="off" lay-verify="required" lay-reqtext="用户名是必填项，不能为空！" >
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">船长</label>
            <div class="layui-input-inline">
                <input name="captain" class="layui-input" type="text" autocomplete="off" >
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">容量</label>
            <div class="layui-input-inline">
                <input name="capacity" class="layui-input" type="text" autocomplete="off" >
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">数量</label>
            <div class="layui-input-inline">
                <input name="count" class="layui-input" type="text" autocomplete="off" >
            </div>
        </div>

    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">泊位</label>
        <div class="layui-input-block">
            <select name="berthNo" id = "berthNo">
                <option value=""></option>
                <option value="" >请选择泊位</option>
                <option value="B1" >B1</option>
                <option value="B2" >B2</option>
                <option value="B3" >B3</option>
                <option value="B4" >B4</option>
                <option value="B5" >B5</option>
                <option value="B6" >B6</option>
                <option value="B7" >B7</option>
                <option value="B8" >B8</option>
                <option value="B9" >B9</option>
                <option value="B10" >B10</option>
                <option value="B11" >B11</option>
                <option value="B12" >B12</option>
                <option value="B13" >B13</option>
                <option value="B14" >B14</option>
                <option value="B15" >B15</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">状态</label>
        <div class="layui-input-block">
            <select name="shipStatus" id = "shipStatus">
                <option value=""></option>
                <option value="1" >停泊</option>
                <option value="0" >出航</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">停泊开始日期</label>
            <div class="layui-input-inline">
                <input name="startTime" class="layui-input" id="date" type="text" placeholder="yyyy-MM-dd" autocomplete="off" lay-verify="date">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">停泊结束日期</label>
            <div class="layui-input-inline">
                <input name="endTime" class="layui-input" id="date1" type="text" placeholder="yyyy-MM-dd" autocomplete="off" lay-verify="date">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" type="submit" lay-filter="demo1" lay-submit="">确认停泊</button>
            <button class="layui-btn layui-btn-primary" type="reset">重置</button>
        </div>
    </div>
</form>
<script src="${ctxPath}/layui/layui.js" charset="utf-8"></script>
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



        //监听提交
        form.on('submit(demo1)', function(data){
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })
            return true;
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
