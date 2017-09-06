<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/static/common/common.jsp" %>
    <script type="text/javascript" src="/static/js/menu.js"></script>
</head>
<body>
<table id="menu_datagrid"></table>

<div id="menu_dialog">
    <form action="" method="post" id="editForm">
        <table align="center" style="border-collapse:separate; border-spacing:0px 10px;">
            <tr>
                <td rowspan="3" align="center" width="25px">
                    <div id="preview"></div>
                    <input type="file" name="file" onchange="preview(this)"/>
                </td>
                <%--<td width="10"></td>--%>
                <td align="right">商品名称:</td>
                <td><input type="text" name="name" size="35"></td>
            </tr>
            <tr>
                <%--<td width="10"></td>--%>
                <td align="right">售价:</td>
                <td><input type="number" name="salePrice" size="35"></td>
            </tr>
            <tr>
                <%--<td width="10"></td>--%>
                <td align="right">成本:</td>
                <td><input type="number" name="costPrice" size="35"></td>
            </tr>
            <tr>
                <%--<td width="10"></td>--%>
                <td align="right">简介:</td>
                <td><input type="text" name="introduce"/></td>
            </tr>
        </table>
    </form>
</div>


<div id="menu_tb">
    <a id="menu_editbtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true"
       data-cmd="edit">编辑</a>
    <a id="menu_chagestatebtn" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"
       data-cmd="changeState">删除</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"
       data-cmd="createMenu">生成菜单</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" data-cmd="reload">刷新</a>
</div>

<div id="menu_bt">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" data-cmd="save">确认</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" data-cmd="cancel">取消</a>
</div>
</body>
</html>
