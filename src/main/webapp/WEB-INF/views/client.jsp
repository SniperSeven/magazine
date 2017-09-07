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

<div id="mass_dialog">
    <form action="" method="post" id="editForm">
        请输入素材ID:<input id="media_id" type="text" name="media_id">
    </form>
</div>
<div id="masstext_dialog">
    <form action="" method="post" id="teditForm">
        请输入文本:<input id="content" type="text" name="content">
    </form>
</div>
<table id="client_datagrid"></table>
<div id="client_tb">
    状态:
    <select id="ss" class="easyui-combobox" name="status" data-options="width:110,panelHeight:'auto'">
        <option value="">全部</option>
        <option value="1">已关注</option>
        <option value="0">取消关注</option>
    </select>
    关注时间<input type="text" name="beginConcernTime" class="easyui-datebox"/>--><input
        type="text" name="endConcernTime" class="easyui-datebox"/><a class="easyui-linkbutton"
                                              data-options="iconCls:'icon-search',plain:true"
                                              data-cmd="searchContent">查询</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"
       data-cmd="massMessage">群发图文消息</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"
       data-cmd="massTextMessage">群发文本消息</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
       data-cmd="rload">刷新</a>
</div>
<div id="mass_bt">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" data-cmd="save">确认</a>
</div>
<div id="masstext_bt">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" data-cmd="tsave">确认</a>
</div>
</body>
</html>

