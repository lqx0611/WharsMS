<%--
  Created by IntelliJ IDEA.
  User: DUMBLEDOG
  Date: 2020/5/7 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
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
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<script src="${ctxPath}/js/jquery-1.11.1.min.js"></script>
<style>
    #form1{
        font-weight: bold;
        position: absolute;
        top: 30%;
        left: 30%;
    }
</style>
<script>
    function LoadPage(retPage) {
        window.location = '${ctxPath}'+ retPage;
    }
    function doSubmit(){
        $.ajax({
            url : '${ctxPath}/Container/putToRepository',
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
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>码放货柜到仓库</legend>
</fieldset>

<form id="form1"class="layui-form" action="">

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">货柜类型</label>
            <div class="layui-input-inline">
                <select name="type" lay-search="" lay-verify="required" lay-reqtext="请选择货柜类型！">
                    <option value="">直接选择或搜索选择</option>
                    <option value="小型货柜">小型货柜</option>
                    <option value="中型货柜">中型货柜</option>
                    <option value="大型货柜">大型货柜</option>
                </select>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">仓库</label>
        <div class="layui-input-block">
            <select name="repositoryId" id = "repositoryId"lay-verify="required" lay-reqtext="请选择仓库类型！">
                <option value="" >请选择仓库</option>
                <option value="1">一号仓(小)</option>
                <option value="2">二号仓(小)</option>
                <option value="3">三号仓(小)</option>
                <option value="4">四号仓(中)</option>
                <option value="5">五号仓(中)</option>
                <option value="6">六号仓(中)</option>
                <option value="7">七号仓(大)</option>
                <option value="8">八号仓(大)</option>
                <option value="9">九号仓(大)</option>
                <option value="10" >十号仓(大)</option>
            </select>
        </div>

    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">数量</label>
            <div class="layui-input-inline">
                <input name="count" type="number"  lay-verify="required|number" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>



    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="button" class="layui-btn" lay-submit="" onclick="doSubmit();">立即提交</button>
            <button class="layui-btn layui-btn-primary" type="reset">重置</button>
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
