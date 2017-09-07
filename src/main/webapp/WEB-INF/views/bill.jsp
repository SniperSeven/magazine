<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单管理</title>
    <%@ include file="/static/common/common.jsp" %>
    <script type="text/javascript" src="/static/js/bill.js"></script>
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
<div class="easyui-layout" fit="true">
    <div data-options="region:'west',title:'订单目录'" style="width:600px;">
        <table id="bill_datagrid"></table>
        <div id="bill_tb">
            状态:
            <select id="state" class="easyui-combobox" name="state" data-options="width:110,panelHeight:'auto'">
                <option value="">全部</option>
                <option value="已发货">已发货</option>
                <option value="待发货">待发货</option>
            </select>
            时间范围<input id="beginSaleDate" type="text" name="beginSaleDate" class="easyui-datebox"/>--><input id="endSaleDate"
                type="text" name="endSaleDate" class="easyui-datebox"/><a class="easyui-linkbutton"
                                                                          data-options="iconCls:'icon-search',plain:true"
                                                                          data-cmd="searchContent">查询</a>
            <a class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
               data-cmd="rload">刷新</a>
            <a class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
               data-cmd="send">发货</a>
        </div>
    </div>
    <div data-options="region:'center',title:'订单目录明细'" style="width:1000px;">
        <table id="billitem_datagrid" style="width: 1000px">
            <thead>
            <tr>
                <th data-options="field:'billId',width:100,align:'center'">订单编号</th>
                <th data-options="field:'product',width:100,align:'center',formatter:productFormatter">商品名称</th>
                <th data-options="field:'number',width:100,align:'center'">商品数量</th>
                <th data-options="field:'smallAccount',width:100,align:'center'">小计</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
</body>
</html>

