<%--
  Created by IntelliJ IDEA.
  User: DUMBLEDOG
  Date: 2020/5/5 22:32
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
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>用户列表页</title>
    <link rel="stylesheet" href="${ctxPath}/layui/css/layui.css?t=1554901098009" media="all">
    <style>
        body{margin: 10px;}
        .demo-carousel{height: 200px; line-height: 200px; text-align: center;}
    </style>

    <style>
        #tbl{ margin-top:15px; margin-left:25px; }
        #tbl th{ height:45px; }
        #tbl td{
            font-weight:normal; height:45px;
            font-family:微软雅黑; font-size:17px;
        }
        #tbl [type='text']{
            height:28px; font-size:17px;
            text-indent:0.3em;
        }
        #tbl select { width:200px; height:32px; font-size:17px; }
        #tbl td:nth-child(1){ width:80px; }
        #tbl td:nth-child(2){ width:350px; }

        #account{
            background:#D5D5D5;
            border:1px solid #999;
            color:#666;
        }

        [type='text']{
            background:#EAEAEA;
            border:1px solid #999;
            border-radius:2px;
        }
        select{
            background:#EAEAEA;
            cursor:pointer;
        }

        /*
        .layui-layer-content{
            background:#EEE;
        } */
    </style>

</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>船只信息列表</legend>
</fieldset>
<table class="layui-hide" id="demo" lay-filter="test"></table>

<script type="text/html" id="barDemo">

    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">立即出行</a>
</script>

<script src="${ctxPath}/js/jquery-1.11.1.min.js"></script>
<script src="${ctxPath}/js/form.js"></script>
<script src="${ctxPath}/layui/layui.js?t=1554901098009"></script>

<script>

    var role_data = [
        {text:"请选择角色",val:"0"},
        {text:"酒店经理",val:"1"},
        {text:"前台营业员",val:"2"},
        {text:"保洁人员",val:"3"},
        {text:"维修人员",val:"4"},
        {text:"后勤人员",val:"5"},
    ];
    var sex_data = [
        {text:"请选择性别",val:"0"},
        {text:"男",val:"男"},
        {text:"女",val:"女"}
    ];

    //{ps} 留在此页
    function getUser( _id ){
        $.ajax(
            {
                url:"${ctxPath}/User/getUser",
                type:"post",
                data:{id:_id},
                dataType:"json",
                success:function( data ){
                    console.log( data );
                    onRecvMsg( data );
                }
            }
        );
    }

    //{ps} 留在此页
    function doPullOut( _no ){
        $.ajax(
            {
                url:"${ctxPath}/Ship/shipOutNow",
                type:"post",
                data:{ no:_no },
                dataType:"json",
                success:function( data ){
                    var ret = data["result"];
                    if( ret=='success' ){

                        setTimeout( reloadPage, 500 );
                    }
                }
            }
        );
    }

    function reloadPage(){
        window.location = "${ctxPath}/Ship/showShipRoute";
    }

    function pickData( arr ){
        var data = {};
        var key;
        for( var key of arr ) {
            data[ key ] = $("#"+ key).val();
            console.log( key +" = "+ data[ key ] );
        }
        return data;
    }

    function onRecvMsg( json ){
        if( json['result']!='success' ){
            //{1} 获取用户失败。
            layer.msg( json['msg'] );
            return;
        }
        //{ps} 生成表格 HTML
        var HTML = makeTable( gInputs, json['user'] );
        //{ps} 弹出一个对话框。
        layer.open({
            type: 1
            ,title: '编辑用户'      //显示标题栏
            ,closeBtn: false
            ,area: ['450px','350px']
            ,shade: 0
            ,id: 'LAY_layuipro'   //设定一个 id, 防止重复弹出
            ,btn: ['保存用户', '关闭对话框']  //{ps} 两个按钮
            ,btnAlign: 'c'        //居中对齐
            ,moveType: 1          //拖拽模式, 0 或者 1
            ,content: HTML        //这是上面生成的表格 html 代码
            ,yes: function(){
                //{1} 当点击 '保存用户' 时候, 调用这个函数
                saveUser();       //保存用户(写到数据库)
                //不建议这里关闭, 等消息回来才做。
                //layer.closeAll(); //关闭对话框
            }
            ,success: function( layero ){
                //-----
            }
        });
    }

</script>

<script>
    layui.config({
        version: '1554901098009'      //为了更新 js 缓存，可忽略
    });

    layui.use(
        ['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider'],
        function(){
            var laydate = layui.laydate //日期
                ,laypage = layui.laypage //分页
                ,layer = layui.layer //弹层
                ,table = layui.table //表格
                ,carousel = layui.carousel //轮播
                ,upload = layui.upload //上传
                ,element = layui.element //元素操作
                ,slider = layui.slider //滑块

            //友好提示
            layer.msg( '正在加载数据...' );

            //监听Tab切换
            element.on('tab(demo)', function(data){
                layer.tips('切换了 '+ data.index +'：'+ this.innerHTML, this, {
                    tips: 1
                });
            });

            //执行一个 table 实例
            table.render({
                elem: '#demo'
                ,height: 560
                /*  这是一个数据接口，拿到 json 数据，重新绘制表格   */
                ,url: '${ctxPath}/Ship/shipRoute'
                ,title: '用户表'
                ,page: true //开启分页
                ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
                ,totalRow: false //开启合计行
                ,cols: [[     //设置表头
                    {type: 'checkbox', width:50,fixed: 'left'}
                    ,{field: 'id', title: 'ID', width:50, sort: true, fixed: 'left'}
                    ,{field: 'no', title: '船只编号', width:120}
                    ,{field: 'type', title: '类型', width: 100, sort: true, totalRow: true}
                    ,{field: 'name', title: '船名', width: 80, sort: true, totalRow: true}
                    ,{field: 'captain', title: '船长', width:80}
                    ,{field: 'company', title: '公司', width:120}
                    ,{field: 'origin', title: '始发地', width:80}
                    ,{field: 'destination', title: '目的地', width:100}
                    ,{field: 'departureTime', title: '离开日期', width:200}
                    ,{field: 'arrivalTime', title: '到达日期', width:200}
                    ,{fixed: 'right', width: 180, align:'center', toolbar: '#barDemo'}
                ]]
            });


            //{ps} 监听头工具栏事件
            table.on('toolbar(test)', function(obj){
                var checkStatus = table.checkStatus(obj.config.id)
                    ,data = checkStatus.data; //获取选中的数据
                switch(obj.event){
                    case 'add':
                        layer.msg('添加');
                        break;
                    case 'update':
                        if(data.length === 0){
                            layer.msg('请选择一行');
                        } else if(data.length > 1){
                            layer.msg('只能同时编辑一个');
                        } else {
                            layer.alert('编辑 [id]：'+ checkStatus.data[0].id);
                        }
                        break;
                    case 'delete':
                        if(data.length === 0){
                            layer.msg('请选择一行');
                        } else {
                            layer.msg('删除');
                        }
                        break;
                };
            });

            //{ps} 监听行工具事件
            table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
                var data = obj.data //获得当前行数据
                    ,layEvent = obj.event; //获得 lay-event 对应的值
                if(layEvent === 'detail'){
                    layer.msg('查看操作');
                } else if(layEvent === 'del'){

                    layer.confirm('再次确认出行', function(index){
                        //obj.del(); //删除对应行 (tr) 的 DOM 结构
                        layer.close( index );
                        //{ps} 向服务端发送删除指令
                        doPullOut( data['no'] );
                    });

                } else if(layEvent === 'edit'){
                    //{1} 拿到用户的 id;
                    var id = data['id'];
                    //{2} 调用一个函数从数据库获取数据。
                    //    为什么不从当前行获取呢 ?
                    //    我想拿到 "最新的" 数据, 行中数据不能保证是最新的。
                    getUser( id );
                }

            });


            //分页
            laypage.render({
                elem: 'pageDemo' //分页容器的id
                ,count: 8        //总页数
                ,skin: '#1E9FFF' //自定义选中色值
                //,skip: true    //开启跳页
                ,jump: function(obj, first){
                    if(!first){
                        layer.msg('第'+ obj.curr +'页', {offset: 'b'});
                        alert( "TTTTTTTTT" );
                    }
                }
            });

            //上传
            upload.render({
                elem: '#uploadDemo'
                ,url: '' //上传接口
                ,done: function(res){
                    console.log(res)
                }
            });

            slider.render({
                elem: '#sliderDemo'
                ,input: true //输入框
            });

        });
</script>
</body>
</html>

