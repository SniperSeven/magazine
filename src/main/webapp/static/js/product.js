function preview(file)
{
    var prevDiv = document.getElementById('preview');
    if (file.files && file.files[0])
    {
        var reader = new FileReader();
        reader.onload = function(evt){
            prevDiv.innerHTML = '<img src="' + evt.target.result + '" /> ';
        }
        reader.readAsDataURL(file.files[0]);
    }
    else
    {
        prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';
    }
}

$(function () {
    $("#product_datagrid").datagrid({
        url: "/product_list.do",
        fit: true,
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        striped: true,
        columns: [[
            {field: "id", title: "编号", width: 100},
            {field: "name", title: "商品名称", width: 100},
            {field: "salePrice", title: "售价", width: 100},
            {field: "imageURL", title: "商品图片", width: 100},
            {field: "introduce", title: "简介", width: 100}
        ]],
        toolbar: '#product_tb'
    });

    $("#product_dialog").dialog({
        width: 500,
        height: 300,
        closed: true,
        buttons: "#product_bt"
    });

    var productMethod = {
        add: function () {
            $("#selfPermissions").datagrid("loadData", {rows: []});
            $("#editForm").form("clear");
            $("#product_dialog").dialog("setTitle", "增加商品");
            $("#product_dialog").dialog("open");
        },

        edit: function () {
            var row = $("#product_datagrid").datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择要编辑的商品", "info");
                return;
            } else {
                $("#editForm").form("clear");
                $("#editForm").form("load", row);
               /* $("#preview").html('<img src="' + row.headimgpath + '" /> ');*/
                $("#product_dialog").dialog("setTitle", "编辑商品");
                $("#product_dialog").dialog("open");
            }
        },

        del: function () {
            var row = $("#product_datagrid").datagrid("getSelected");
            if (!row.id) {
                $.messager.alert("温馨提示", "请选择要删除的商品", "info");
                return;
            } else {
                $.messager.confirm("温馨提示", "确定要删除该商品吗", function (r) {
                    if (r) {
                        $.post("/product_delete.do", {id: row.id}, function (data) {
                            if (data.success) {
                                $.messager.alert("温馨提示", data.msg, "info", function () {
                                    $("#product_datagrid").datagrid("reload");
                                });
                            } else {
                                $.messager.alert("温馨提示", data.msg, "info");
                            }
                        });
                    }
                });
            }
        },

        save: function () {
            var url = "/product_save.do";
            if ($("[name='id']").val()) {
                url = "/product_edit.do";
            }
            $("#editForm").form("submit", {
                url: url,
               /* onSubmit: function (param) {
                    var rows = $("#selfPermissions").datagrid("getRows");
                    for (i = 0; i < rows.length; i++) {
                        param["permissions[" + i + "].id"] = rows[i].id;
                    }
                },*/
                success: function (data) {
                    data = $.parseJSON(data);
                    if (data.success) {
                        $("#product_dialog").dialog("close");
                        $.messager.alert("温馨提示", data.msg, "info", function () {
                            $("#product_datagrid").datagrid("reload");
                        });
                    } else {
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                }
            });
        },

        cancel: function () {
            $("#product_dialog").dialog("close");
        },

        reload: function () {
            $('#product_datagrid').datagrid('load', {});
        }

    };

    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        productMethod[cmd]();
    });

})






