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
    $("#saleChart_datagrid").datagrid({
        url: "/saleChart_list.do",
        fit: true,
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        striped: true,
        selectOnCheck: true,
        checkOnSelect: true,
        columns: [[
            {field: "id", title: "编号", width: 100},
            {field: "sn", title: "订单编号", width: 100},
            {field: "number", title: "数量", width: 100},
            {field: "costprice", title: "销售成本", width: 100},
            {field: "saleprice", title: "销售金额", width: 100},
            {field: "profit", title: "利润", width: 100},
            {field: "saletime", title: "销售时间", width: 100}
        ]],
        toolbar: "#saleChart_tb"
    });
    var saleChartMethod = {
        searchContent:function(){
            var keyword = $("[name='keyword']").val();
            var minValue = $("[name='minValue']").val();
            var maxValue = $("[name='maxValue']").val();
            $("#saleChart_datagrid").datagrid("load",{
                keyword:keyword,
                minValue:minValue,
                maxValue:maxValue
            })
        },
        rload: function () {
            $("[name='keyword']").val("");
            $("[name='minValue']").val("");
            $("[name='maxValue']").val("");
           $("#saleChart_datagrid").datagrid("load",{})
        },
    };

    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        saleChartMethod[cmd]();
    });
})






