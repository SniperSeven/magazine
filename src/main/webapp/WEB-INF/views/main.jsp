<%--
  Created by IntelliJ IDEA.
  User: zmh
  Date: 2017/9/3
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <%@ include file="/static/common/common.jsp" %>
    <script type="text/javascript" src="/static/js/index.js"></script>
    <style type="text/css">
        .border_right_none {
            border-right: none;
        }
    </style>
</head>
<body>
<div class="demo-info">
    <div class="demo-tip icon-tip"></div>
</div>
<div style="margin:10px 0;"></div>
<div id="cc" data-options="fit:true,border:false" class="easyui-layout">
    <div data-options="border:false,region:'north'" style="height:70px;background:url('../../image/banner-pic.gif') no-repeat;background-size:cover">
        <center><h1>心点芯管理系统</h1></center>
    </div>
    <div data-options="region:'south',split:true" style="height:30px;background: url('../../image/banner-pic.gif') no-repeat;background-size:cover">
        <center>版权所有:广州心点芯糕点有限公司</center>
    </div>
    <div data-options="region:'west',border:false,split:true,headerCls:'border_right_none',bodyCls:'border_right_none'" title="系统菜单" style="width:100px;">
        <ul id="index_tree"></ul>
    </div>
    <div data-options="region:'center'" style="padding: 3px;">
        <div id="index_tabs" class="easyui-tabs" data-options="fit:true,border:false">
            <div title="系统首页">
                欢迎登录~~
            </div>
        </div>
    </div>
</div>
</body>
</html>
