<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息管理</title>
    <%@ include file="/static/common/common.jsp" %>
    <script type="text/javascript" src="/static/js/client.js"></script>
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
<table id="client_datagrid"></table>
<div id="client_tb">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" data-cmd="add">新增</a>
    状态:
    <select id="ss" class="easyui-combobox" name="status" data-options="width:110,panelHeight:'auto'">
        <option value="-1">全部</option>
        <option value="1">已关注</option>
        <option value="0">取消关注</option>
    </select>
    关注时间<input type="text" name="beginConcernTime" class="easyui-datebox"/>--><input
        type="text" name="endConcernTime" class="easyui-datebox"/><a class="easyui-linkbutton"
                                              data-options="iconCls:'icon-search',plain:true"
                                              data-cmd="searchContent">查询</a>
    <a id="clienttrack_search" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"
       data-cmd="showme">查看</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
       data-cmd="rload">刷新</a>
</body>
</html>

