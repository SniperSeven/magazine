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
    $("#bill_datagrid").datagrid({
        url: "/bill_list.do",
        fit: true,
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        striped: true,
        selectOnCheck: true,
        checkOnSelect: true,
        columns: [[
            /*{field: "id", title: "编号", width: 100},*/
            {field: "sn", title: "订单编号", width: 100},
            {field: "client", title: "客户", width: 100, formatter: clientFormatter},
            {field: "saleDate", title: "时间", width: 100},
            {field: "state", title: "订单状态", width: 100, formatter: staFormatter}
        ]],
        toolbar: "#bill_tb",
        onClickRow: function () {
            var rowData = $("#bill_datagrid").datagrid("getSelected");
            $("#billitem_datagrid").datagrid("options").url = "/billItem_list.do?id=" + rowData.id;
            $("#billitem_datagrid").datagrid("load");
        }
    });

    $("#billitem_datagrid").datagrid({
        //width:1000,
        fit: true,
        pagination: true,
        rownumbers: true,
        singleSelect: true,
        striped: true,
        fitColumns: true,
    });
    function clientFormatter(value) {
        return value ? value.name : "";
    }


    function staFormatter(value) {
        if (value == "已发货") {
            return "已发货";
        } else if (value == "待发货") {
            return "待发货";
        } else if (value == "待付款") {
            return "待付款";
        } else if (value == "已付款") {
            return "已付款";
        }
    }

    var billMethod = {
        searchContent: function () {
            /* var state = $("[name='state']").val();
             var beginSaleDate = $("[name='beginSaleDate']").val();
             var endSaleDate = $("[name='endSaleDate']").val();*/
            var state = $("#state").val();
            var beginSaleDate = $("#beginSaleDate").val();
            var endSaleDate = $("#endSaleDate").val();

            $("#bill_datagrid").datagrid("load", {
                state: state,
                beginSaleDate: beginSaleDate,
                endSaleDate: endSaleDate
            })

        },
        rload: function () {
            /* $("[name='state']").val("");
             $("[name='beginSaleDate']").val("");
             $("[name='endSaleDate']").val("");*/
            $("#state").combo("setText", '全部');
            $("#beginSaleDate").combo('setText', '');
            $("#endSaleDate").combo('setText', '');
            $("#bill_datagrid").datagrid("load", {})
        },
        send: function () {
            var row = $("#bill_datagrid").datagrid("getSelected");
            $.messager.confirm("温馨提示:", "确定要发货么?", function (r) {
                if (r) {
                    $.post('/bill_delivery.do', {id: row.id}, function (data) {
                        if (data.success) {
                            $.messager.alert("温馨提示", data.msg, "info");
                            $("#bill_datagrid").datagrid("reload");
                        } else {
                            $.messager.alert("温馨提示", data.msg, "info");
                        }
                    });
                }
            });

        },
    };

    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        billMethod[cmd]();
    });
})

function productFormatter(value) {
    return value ? value.name : "";
}







