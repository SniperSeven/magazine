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
                <td align="right">菜单名称:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td align="right">菜单类型:</td>
                <td><input type="text" name="type"></td>
            </tr>
            <tr>
                <td align="right">关键字:</td>
                <td><input type="text" name="key"/></td>
            </tr>
            <tr>
                <td align="right">链接:</td>
                <td><input type="text" name="url"/></td>
            </tr>
            <tr>
                <td align="right">父级菜单:</td>
                <td><input class="easyui-combobox" name="parent.id"
                           data-options="valueField:'id',textField:'name',url:'/menu_getbuttons.do'"/></td>
            </tr>
            <tr>
                <td align="right">素材码:</td>
                <td><input type="text" name="media_id"/></td>
            </tr>
            <tr>
                <td align="right">状态:</td>
                <td><select name="state" class="easyui-combobox" style="width: 160px" data-options="panelHeight:'auto'">
                    <option value="true">是</option>
                    <option value="false">否</option>
                </select></td>
            </tr>
        </table>
    </form>
</div>


<div id="menu_tb">
    <a id="menu_editbtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true"
       data-cmd="edit">编辑</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"
       data-cmd="enable">启用</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"
       data-cmd="disable">禁用</a>
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
