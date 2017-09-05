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
        singleSelect: true,
        pagination: true,
        striped: true,
        selectOnCheck: true,
        checkOnSelect: true,
        columns: [[
            {field: "id", title: "编号", width: 100},
            {field: "openId", title: "openID", width: 100},
            {field: "name", title: "昵称", width: 100},
            {field: "address", title: "地址", width: 100},
            {field: "concernTime", title: "关注时间", width: 100},
            {field: "status", title: "关注状态", width: 100,formatter:staFormatter}
        ]],
        toolbar: "#client_tb"
    });
    function staFormatter(value) {
        if (value==1) {
            return "<font style='color: green'>已关注</font>";
        } else {
            return "<font style='color: red'>取消关注</font>";
        }
    }
    var clientMethod = {
        searchContent:function(){
            var status = $("[name='status']").val();
            var beginConcernTime = $("[name='beginConcernTime']").val();
            var endConcernTime = $("[name='endConcernTime']").val();
            if (status!=-1){
                $("#client_datagrid").datagrid("load", {
                    status: status,
                    beginConcernTime: beginConcernTime,
                    endConcernTime: endConcernTime
                })
            }else {
                $("#client_datagrid").datagrid("load", {
                })
            }
        },
        rload: function () {
            $("[name='status']").val("");
            $("[name='beginConcernTime']").val("");
            $("[name='endConcernTime']").val("");
           $("#client_datagrid").datagrid("load",{})
        },
    };

    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        clientMethod[cmd]();
    });
})






