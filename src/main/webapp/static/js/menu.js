/*function preview(file)
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
}*/

$(function () {
    $("#menu_datagrid").datagrid({
        url: "/menu_list.do",
        fit: true,
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        striped: true,
        columns: [[
            {field: "id", title: "编号", width: 100},
            {field: "name", title: "菜单名称", width: 100},
            {field: "type", title: "菜单类型", width: 100},
            {field: "key", title: "关键字", width: 100},
            {field: "url", title: "链接", width: 100},
            {field: "parent", title: "父级菜单", width: 100,formatter:function (value) {
                if(value){
                    return value.name;
                }
            }},
            {field: "media_id", title: "素材码", width: 100},
            {field: "state", title: "状态", width: 100,formatter:function (value) {
                if(value){
                    return "启用中";
                }else{
                    return "禁用中";
                }
            }}
        ]],
        toolbar: '#menu_tb'
    });

    $("#menu_dialog").dialog({
        width: 380,
        height: 400,
        closed: true,
        buttons: "#menu_bt"
    });

    var menuMethod = {
        /*add: function () {
            $("#editForm").form("clear");
            $("#menu_dialog").dialog("setTitle", "增加菜单");
            $("#menu_dialog").dialog("open");
        },*/

        edit: function () {
            var row = $("#menu_datagrid").datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择要编辑的菜单", "info");
                return;
            } else {
                if(row.parent){
                    row["parent.id"] = row.parent.id;
                }
                row.state = row.state + "";
                $("#editForm").form("clear");
                $("#editForm").form("load", row);
               /* $("#preview").html('<img src="' + row.headimgpath + '" /> ');*/
                $("#menu_dialog").dialog("setTitle", "编辑菜单");
                $("#menu_dialog").dialog("open");
            }
        },

        save: function () {
            $("#editForm").form("submit", {
                url: "/menu_edit.do",
               /* onSubmit: function (param) {
                    var rows = $("#selfPermissions").datagrid("getRows");
                    for (i = 0; i < rows.length; i++) {
                        param["permissions[" + i + "].id"] = rows[i].id;
                    }
                },*/
                success: function (data) {
                    data = $.parseJSON(data);
                    if (data.success) {
                        $("#menu_dialog").dialog("close");
                        $.messager.alert("温馨提示", data.msg, "info", function () {
                            $("#menu_datagrid").datagrid("reload");
                        });
                    } else {
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                }
            });
        },

        enable : function () {
            var row = $("#menu_datagrid").datagrid("getSelected");
            if (!row.id) {
                $.messager.alert("温馨提示", "请选择要启用的菜单", "info");
                return;
            } else {
                $.messager.confirm("温馨提示", "确定要启用该菜单吗", function (r) {
                    if (r) {
                        $.post("/menu_enable.do", {id: row.id}, function (data) {
                            if (data.success) {
                                $.messager.alert("温馨提示", data.msg, "info", function () {
                                    $("#menu_datagrid").datagrid("reload");
                                });
                            } else {
                                $.messager.alert("温馨提示", data.msg, "info");
                            }
                        });
                    }
                });
            }
        },

        disable: function () {
            var row = $("#menu_datagrid").datagrid("getSelected");
            if (!row.id) {
                $.messager.alert("温馨提示", "请选择要禁用的菜单", "info");
                return;
            } else {
                $.messager.confirm("温馨提示", "确定要禁用该菜单吗", function (r) {
                    if (r) {
                        $.post("/menu_disable.do", {id: row.id}, function (data) {
                            if (data.success) {
                                $.messager.alert("温馨提示", data.msg, "info", function () {
                                    $("#menu_datagrid").datagrid("reload");
                                });
                            } else {
                                $.messager.alert("温馨提示", data.msg, "info");
                            }
                        });
                    }
                });
            }
        },

        createMenu : function () {
            $.post("/menu_create.do", function (data) {
                if (data.success) {
                    $.messager.alert("温馨提示", data.msg, "info", function () {
                        $("#menu_datagrid").datagrid("reload");
                    });
                } else {
                    $.messager.alert("温馨提示", data.msg, "info");
                }
            });
        },

        cancel: function () {
            $("#menu_dialog").dialog("close");
        },

        reload: function () {
            $('#menu_datagrid').datagrid('load', {});
        }

    };

    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        menuMethod[cmd]();
    });

})






