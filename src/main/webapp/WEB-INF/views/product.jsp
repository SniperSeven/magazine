<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/static/common/common.jsp" %>
    <script type="text/javascript" src="/static/js/product.js"></script>
</head>
<body>
<table id="product_datagrid"></table>

<div id="product_dialog">
    <form action="" method="post" id="editForm" enctype="multipart/form-data">
        <table align="center" style="border-collapse:separate; border-spacing:0px 10px;">
            <tr>
                <td id="preview11" align="center" width="25px">
                    主页第一张图<input type="file" name="file" onchange="preview(this)"/>
                </td>
                <td id="preview21" align="center" width="25px">
                    主页第二张图<input type="file" name="file2" onchange="preview(this)"/>
                </td>
            </tr>
            <tr>
                <%--<td width="10"></td>--%>
                <td align="right">重量:</td>
                <td><input type="text" name="weight" placeholder="磅" size="35"></td>
            </tr>
            <tr>
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
<div id="headProduct_dialog">
    <form action="" method="post" id="addHeadProductForm" enctype="multipart/form-data">
        <table align="center" style="border-collapse:separate; border-spacing:0px 10px;">
            <tr>
                <td id="preview1" align="center" width="25px">
                    主页第一张图<input type="file" name="file" onchange="preview(this)"/>
                </td>
                <td id="preview2" align="center" width="25px">
                    主页第二张图<input type="file" name="file2" onchange="preview(this)"/>
                </td>
                <td id="preview3" align="center" width="25px">
                    主页第二张图<input type="file" name="file3" onchange="preview(this)"/>
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


<div id="product_tb">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" data-cmd="add">增加</a>
    <a id="product_editbtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true"
       data-cmd="edit">编辑</a>
    <a id="product_chagestatebtn" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"
       data-cmd="del">删除</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" data-cmd="reload">刷新</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" data-cmd="addHead">增加主题商品</a>
</div>

<div id="product_bt">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" data-cmd="save">确认</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" data-cmd="cancel">取消</a>
</div>
<div id="headProduct_bt">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" data-cmd="saveHead">确认</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" data-cmd="cancel">取消</a>
</div>
</body>
</html>
