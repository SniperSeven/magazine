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
    $("#client_datagrid").datagrid({
        url: "/client_list.do",
        fit: true,
        fitColumns: true,
        pagination: true,
        striped: true,
        /*selectOnCheck: true,
         checkOnSelect: true,*/
        columns: [[
            /*  {checkbox: true, width: 100, field: 'ck'},*/
            {field: "id", title: "编号", width: 100},
            {field: "openId", title: "openID", width: 100},
            {field: "name", title: "昵称", width: 100},
            {field: "address", title: "地址", width: 100},
            {field: "concernTime", title: "关注时间", width: 100},
            {field: "status", title: "关注状态", width: 100, formatter: staFormatter}
        ]],
        toolbar: "#client_tb"
    });

    $("#mass_dialog").dialog({
        width: 300,
        height: 200,
        closed: true,
        buttons: "#mass_bt"
    });
    $("#masstext_dialog").dialog({
        width: 300,
        height: 200,
        closed: true,
        buttons: "#masstext_bt"
    });
    function staFormatter(value) {
        if (value == 1) {
            return "<font style='color: green'>已关注</font>";
        } else {
            return "<font style='color: red'>取消关注</font>";
        }
    }

    var clientMethod = {
        searchContent: function () {
            var status = $("[name='status']").combo("getText");
            var beginConcernTime = $("[name='beginConcernTime']").combo("getText");
            var endConcernTime = $("[name='endConcernTime']").combo("getText");
            if (status != -1) {
                $("#client_datagrid").datagrid("load", {
                    status: status,
                    beginConcernTime: beginConcernTime,
                    endConcernTime: endConcernTime
                })
            } else {
                $("[name='status']").combo("setText", '');
                $("[name='beginConcernTime']").combo("setText", '');
                $("[name='endConcernTime']").combo("setText", '');
                $("#client_datagrid").datagrid("load", {})
            }
        },
        rload: function () {
            $("[name='status']").combo("setText", '');
            $("[name='beginConcernTime']").combo("setText", '');
            $("[name='endConcernTime']").combo("setText", '');
            $("#client_datagrid").datagrid("load", {})
        },
        massMessage: function () {
            $("#mass_dialog").dialog("open");
            /*var arr = new Array;
             var rows = $("#client_datagrid").datagrid("getSelections");
             for(i=0;i<rows.length;i++) {
             /!*console.log(rows[i].openId);*!/
             arr[i]=rows[i].openId;
             }
             */
            //console.log(arr);
        },
        massTextMessage:function () {
            $("#masstext_dialog").dialog("open");
        },
        tsave:function () {
            var rows = $("#client_datagrid").datagrid("getSelections");
            $.messager.confirm("温馨提示:", "确定要群发么?", function (r) {
                if (r) {
                    var openId = new Array;
                    for (i = 0; i < rows.length; i++) {
                        openId.push(rows[i].openId);
                    }
                    $.post('/client_masstext.do', {openId: openId, content: $("#content").val()}, function (data) {
                        if (data.success) {
                            $.messager.alert("温馨提示", data.msg, "info");
                            /* $("#bill_datagrid").datagrid("reload");*/
                        } else {
                            $.messager.alert("温馨提示", data.msg, "info");
                        }
                    });
                }
                $("#masstext_dialog").dialog("close");
            });
        },

        save: function () {
            var rows = $("#client_datagrid").datagrid("getSelections");
            /*$("#editForm").form("submit", {
             url: "/client_mass.do",
             onSubmit: function (param) {
             for(i=0;i<rows.length;i++){
             param["openId["+i+"]"] = rows[i].openId;
             }
             param[media_id] = $("#media_id").val();
             console.log(param);
             },

             });*/
            $.messager.confirm("温馨提示:", "确定要群发么?", function (r) {
                if (r) {
                    var openId = new Array;
                    for (i = 0; i < rows.length; i++) {
                        openId.push(rows[i].openId);
                    }
                    $.post('/client_mass.do', {openId: openId, mediaId: $("#media_id").val()}, function (data) {
                        if (data.success) {
                            $.messager.alert("温馨提示", data.msg, "info");
                            /* $("#bill_datagrid").datagrid("reload");*/
                        } else {
                            $.messager.alert("温馨提示", data.msg, "info");
                        }
                    });
                }
                $("#mass_dialog").dialog("close");
            });
        }
    };

    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        clientMethod[cmd]();
    });
})






