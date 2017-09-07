<%--
  Created by IntelliJ IDEA.
  User: wall
  Date: 2017/9/6
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <meta name="Generator" content="ECSHOP v2.7.3"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width">
    <title>用户中心_心点芯官网 </title>
    <meta name="Keywords" content=""/>
    <meta name="Description" content=""/>
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=0"/>


    <script type="text/javascript" src="../../comment/js/jquery-1.7.2.min.js"></script>
    <link href="../../comment/style.css" rel="stylesheet" type="text/css"/>

    <link href="../../comment/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css"/>
    <!--<link href="basic/css/demo.css" rel="stylesheet" type="text/css"/>-->

    <!-- head 中 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/weui/1.1.1/style/weui.min.css">
    <link rel="stylesheet" href="//cdn.bootcss.com/jquery-weui/1.0.1/css/jquery-weui.min.css">


</head>
<!--<script type="text/javascript" src="js/shopping_flow.js"></script>-->
<!-- 引入微信的js  sdk  接口 中 -->
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<!--通过config接口注入权限验证配置-->

<body>

<header>
    <div class="tab_nav">
        <div class="header">
            <div class="h-left">
                <a class="sb-back" href="javascript:history.back(-1)" title="返回"> < </a>
            </div>
            <div class="h-mid"></div>
            <div class="h-right">
                <aside class="top_bar">


                    <a id="mc-menu-hd" href="#" target="_top" style="color: #379cbe">
                        <i class="am-icon-shopping-cart  am-icon-fw"></i>
                        <!--<span>购物车</span>-->
                        <strong id="J_MiniCartNum" class="h">${sessionScope.productNum}</strong>
                    </a>


                    <!--<div onClick="show_menu();$('#close_btn').addClass('hid');" id="show_more">-->
                    <!--<a href="javascript:;">...</a>-->
                    <!--</div>-->

                </aside>
            </div>
        </div>
    </div>
</header>

<div class="weui-panel__hd">购物车清单</div>
<form id="cartForm" action="/product_dealBill.do">
    <div class="many">
        <input type="hidden" name="id" value="${bill.id}">
        <c:forEach items="${bill.items}" var="item" varStatus="ids">

            <input type="hidden" name="items[${ids.index}].id" value="${item.id}">
            <input type="hidden" name="items[${ids.index}].product.id" value="${item.product.id}">
            <input type="hidden" name="items[${ids.index}].product.salePrice" value="${item.product.salePrice}">
            <input type="hidden" name="items[${ids.index}].product.name" value="${item.product.name}">
            <input type="hidden" name="items[${ids.index}].product.imageURL" value="${item.product.imageURL}">
            <input type="hidden" name="items[${ids.index}].product.introduce" value="${item.product.introduce}">


            <div class="weui-panel weui-panel_access" id="fo${item.id}">
                <div class="weui-panel__hd" style="background-color: #afb8be">
                    <ui style="color: #fafafa">
                            ${item.product.name}
                    </ui>
                </div>
                <div class="weui-panel__bd">

                    <ui href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg">
                        <div class="weui-media-box__hd">
                            <img class="weui-media-box__thumb" src="${item.product.imageURL}">
                        </div>
                        <div class="weui-media-box__bd">
                            <ui class="weui-media-box__desc">${item.product.introduce}</ui>
                            <div class="theme-options">
                                <a href="javascript:;" id="min" class="weui-btn weui-btn_mini"
                                   onclick="min(${item.id})">-</a>

                                <a href="javascript:;" id="num${item.id}"
                                   class="weui-btn weui-btn_mini realNum">${item.number}</a>

                                <input type="hidden" id="num2${item.id}"  class="product_num"
                                       name="items[${ids.index}].number"
                                       value="${item.number}">

                                <a href="javascript:;" id="add" class="weui-btn weui-btn_mini"
                                   onclick="max(${item.id})">+</a>
                            </div>
                        </div>
                        <b class="sys_item_price">
                            <a href="#">
                                <span style="color: #ffffff">${item.number}</span>
                                <ui class="J_Price price-now" style="color: #379cbe">¥</ui>
                                <ui id="price${item.id}" class="J_Price price-now"
                                    style="color: #379cbe">${item.product.salePrice}</ui>
                            </a>
                        </b>
                        <a href="javascript:;">
                            <img src="../../comment/image1/re.png" style="height: 25px" onclick="del(${item.id})">
                        </a>
                    </ui>
                </div>
            </div>
            <pre></pre>
        </c:forEach>
    </div>


    <div class="weui-cell" style="height: 10px">
        <div class="weui-cell__hd">
            <label for="" class="weui-label">
                <span style="color:#379cbe">总计:</span>
                <span style="color:#379cbe" id="money">${bill.totalPrice}</span>
            </label>
        </div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="date" value="">
        </div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="date" value="">
        </div>
        <a href="#">
            <div id="btn_submit" class="weui-media-box__hd">
                <img class="weui-media-box__thumb" src="../../comment/image1/buy.png" style="height:71px">
            </div>
        </a>
    </div>
</form>
<!--<a href="javascript:;" class="weui-btn weui-btn_default">买单</a>-->

</body>
<!-- body 最后 -->
<script src="//cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-weui/1.0.1/js/jquery-weui.min.js"></script>

<script>
    function max(n) {
        var num = $("#num" + n).html();
        var pr = parseInt($("#price" + n).html());
        var mo = parseInt($("#money").html());
        num++;
        $("#num" + n).html(num);
        $("#num2" + n).val(num);

        console.log(pr)
        console.log(mo)

        $("#money").html(mo + pr);
    }
    function min(n) {
        var num = $("#num" + n).html();
        var pr = parseInt($("#price" + n).html());
        var mo = parseInt($("#money").html());
        if (num > 1) {
            num--;
            $("#num" + n).html(num);
            $("#num2" + n).val(num);
            $("#money").html(mo - pr);
        }
    }
    function del(n) {
        var mo = parseInt($("#money").html());
        var pr = parseInt($("#price" + n).html());
        var num = $("#num" + n).html();
        $("#money").html(mo - pr * num);
        $("#fo" + n).remove();
    }
    $(function () {
        $("#btn_submit").click(function () {
            $("#cartForm").submit();
        });
    })

</script>


</html>