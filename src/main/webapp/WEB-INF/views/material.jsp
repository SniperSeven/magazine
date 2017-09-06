<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息管理</title>
    <%@ include file="/static/common/common.jsp" %>
    <script type="text/javascript" src="/static/js/material.js"></script>
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
<table id="material_datagrid"></table>

<div title="添加特价商品" id="material_dialog">
    <form id="materialForm" class="easyui-form" method="post">
        <table align="center" style="margin-top: 15px" cellpadding="5">
            <tr>
                <td align="right">标题:</td>
                <td><input type="text" name="title"/></td>
            </tr>
            <tr style="height: 10px">
                <td align="right">产品:</td>
                <td><input class="easyui-combobox" name="product.id"
                           data-options="valueField:'id',textField:'name',url:'/product_listAll.do'"/></td>
            </tr>
            <tr>
                <td align="right">作者:</td>
                <td><input type="text" name="author"/></td>
            </tr>
            <tr>
                <td align="right">是否显示封面:</td>
                <td>
                    <select name="show_cover_pic" class="easyui-combobox" style="width: 160px" data-options="panelHeight:'auto'">
                        <option value="true">是</option>
                        <option value="false">否</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="right">优惠价:</td>
                <td><input type="text" name="salePrice"/></td>
            </tr>
            <tr>
                <td align="right">原文地址:</td>
                <td><input type="text" name="content_source_url"/></td>
            </tr>
        </table>
    </form>
</div>

<div id="material_tb">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" data-cmd="add">新增</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" data-cmd="apply">应用</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
       data-cmd="rload">刷新</a>
</div>

<div id="material_bt" align="center">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" data-cmd="save">确认</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" data-cmd="cancel">取消</a>
</div>
</body>
</html>

