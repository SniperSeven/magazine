/**
 * Created by 76585 on 2017/8/12.
 */
//初始化树组件
$(function () {
    $("#index_tree").tree({
        url: "/json/menu.json",
        // attributes:{"url":"/12_project/employee.html"},
        onClick: function (node) {
            //  console.log(node);
            //判断当前选项卡是否存在,不存在就添加,存在就选中
            if ($("#index_tabs").tabs("exists", node.text)) {
                $("#index_tabs").tabs("select", node.text);
            } else {
                $("#index_tabs").tabs("add", {
                    title: node.text,
                    closable: true,
                    content: "<iframe frameborder=0 height='100%' width='100%' src=" + node.attributes.url + "></iframe>",
                })
                //console.log(node.attributes.url);
            }
        }
    })
});