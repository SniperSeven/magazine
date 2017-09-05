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
    $("#message_datagrid").datagrid({
        url: "/message_list.do",
        fit: true,
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        striped: true,
        selectOnCheck: true,
        checkOnSelect: true,
        columns: [[
            {field: "id", title: "编号", width: 100},
            {field: "client.id", title: "用户", width: 100},
            {field: "receivecontent", title: "接收内容", width: 100},
            {field: "replycontent", title: "回复内容", width: 100},
            {field: "type", title: "消息类型", width: 100},
            {field: "inputtime", title: "消息记录时间", width: 100}
        ]],
        toolbar: "#message_tb"
    });
    var saleChartMethod = {
        searchContent:function(){
            var name = $("[name='name']").val();
            var beginTime = $("[name='beginTime']").val();
            var endTime = $("[name='endTime']").val();
            $("#message_datagrid").datagrid("load",{
                name:name,
                beginTime:beginTime,
                endTime:endTime
            })
        },
        reload: function () {
            $("[name='name']").val("");
            $("[name='beginTime']").val("");
            $("[name='endTime']").val("");
           $("#message_datagrid").datagrid("load",{})
        },
    };

    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        saleChartMethod[cmd]();
    });
})






