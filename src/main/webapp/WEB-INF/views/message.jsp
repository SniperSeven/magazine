<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>消息记录管理</title>
    <%@ include file="/static/common/common.jsp" %>
    <script type="text/javascript" src="/static/js/message.js"></script>
    <style type="text/css">
        .btn_01 {
            background-color: transparent;
            border: none
        }
    </style>
    <style type="text/css">
        #preview, .img, img {
            width: 160px;
            height: 160px;
        }

        #preview {
            border: 1px solid #000;
        }
    </style>
</head>
<body>
<table id="message_datagrid"></table>
<div id="message_tb">
    用户:<input type="text" name="name">录入时间<input type="text" name="beginTime" class="easyui-datebox"/>--><input
        type="text" name="endTime" class="easyui-datebox"/><a class="easyui-linkbutton"
                                        data-options="iconCls:'icon-reload',plain:true"
                                        data-cmd="searchContent">查询</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"
       data-cmd="rload">刷新</a>
</body>
</html>

