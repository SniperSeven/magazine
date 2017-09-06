/*function preview(file) {
    var prevDiv = document.getElementById('preview');
    if (file.files && file.files[0]) {
        var reader = new FileReader();
        reader.onload = function (evt) {
            prevDiv.innerHTML = '<img src="' + evt.target.result + '" /> ';
        }
        reader.readAsDataURL(file.files[0]);
    }
    else {
        prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';
    }
}*/


$(function () {
    $("#material_datagrid").datagrid({
        url: "/material_list.do",
        fit: true,
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        striped: true,
        selectOnCheck: true,
        checkOnSelect: true,
        columns: [[
            {field: "id", title: "编号", width: 100},
            {field: "title", title: "标题", width: 100},
            {field: "thumb_media_id", title: "封面图片", width: 100},
            {field: "author", title: "作者", width: 100},
            {field: "digest", title: "摘要", width: 100},
            {field: "show_cover_pic", title: "是否显示封面", width: 100,formatter:staFormatter},
            {field: "content_source_url", title: "阅读原文链接", width: 100},
        ]],
        toolbar: "#material_tb"
    });

    $("#material_dialog").dialog({
        width: 400,
        height: 500,
        closed: true,
        buttons : "#material_bt"
    });

    function staFormatter(value) {
        if (value==1) {
            return "<font style='color: green'>是</font>";
        } else {
            return "<font style='color: red'>否</font>";
        }
    }
    var materialMethod = {

        add:function () {
            $("#materialForm").form("clear");
            $("#material_dialog").dialog("open");
        },

        save : function () {
            $("#materialForm").form("submit",{
                url : "/material_save.do",
                success:function(data){
                    data = $.parseJSON(data);
                    if(data.success){
                        $("#material_dialog").dialog("close");
                        $.messager.alert("温馨提示",data.msg,"info",function () {
                            $("#studentloss_datagrid").datagrid("reload");
                        });
                    }else{
                        $.messager.alert("温馨提示",data.msg,"info");
                    }
                }
            });
        },

        cancel : function () {
            $("#material_dialog").dialog("close");
        },

        apply:function () {
            var row = $("#material_datagrid").datagrid("getSelected");
            if (!row.id) {
                $.messager.alert("温馨提示", "请选择要应用的特价商品", "info");
                return;
            } else {
                $.messager.confirm("温馨提示", "确定要应用该特价商品吗", function (r) {
                    if (r) {
                        $.post("/material_apply.do", {id: row.id}, function (data) {
                            if (data.success) {
                                $.messager.alert("温馨提示", data.msg, "info", function () {
                                    $("#material_datagrid").datagrid("reload");
                                });
                            } else {
                                $.messager.alert("温馨提示", data.msg, "info");
                            }
                        });
                    }
                });
            }
        },

        rload: function () {
           $("#material_datagrid").datagrid("load",{})
        },
    };

    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        materialMethod[cmd]();
    });
})






