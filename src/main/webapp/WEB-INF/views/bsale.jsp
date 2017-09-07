<%--
  Created by IntelliJ IDEA.
  User: wall
  Date: 2017/9/7
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <style>
        #msg {
            position: fixed;
            top: 300px;
            right: 35px;
            z-index: 10000;
            width: 1px;
            height: 52px;
            line-height: 52px;
            font-size: 20px;
            text-align: center;
            color: #fff;
            background: #7bd1ff;
            display: none
        }
    </style>


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
        </div>
    </div>
</header>

<div class="weui-form-preview">
    <div class="weui-form-preview__hd">
        <label class="weui-form-preview__label">付款金额</label>
        <span class="weui-form-preview__value">¥ ${sessionScope.bill.totalPrice}</span>
    </div>


    <div class="weui-form-preview__bd">
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">收货人</label>
            <span class="weui-form-preview__value">${sessionScope.CLIENT_IN_SESSION.name}</span>
        </div>
       <%-- <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">电话</label>
            <span class="weui-form-preview__value">${sessionScope.CLIENT_IN_SESSION.tel}</span>
        </div>
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">收货地址</label>
            <span class="weui-form-preview__value">${sessionScope.CLIENT_IN_SESSION.address}</span>
        </div>--%>
            <div class="weui-form-preview__item">
                <label class="weui-form-preview__label">商品</label>
            </div>
        <c:forEach items="${sessionScope.bill.items}" var="item">
            <div class="weui-form-preview__item">
                <label class="weui-form-preview__label">${item.product.name}</label>
                <span class="weui-form-preview__value">¥${item.product.salePrice} * ${item.number}</span>
            </div>
        </c:forEach>
    </div>

    <div class="weui-cell weui-cell_vcode">
        <div class="weui-cell__hd">
            <label class="weui-label">手机号</label>
        </div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="tel" type="tel" placeholder="请输入手机号"
                   value="${sessionScope.CLIENT_IN_SESSION.tel}">
        </div>
        <div class="weui-cell__ft">
            <p></p>
        </div>
    </div>

    <div class="weui-cell weui-cell_vcode">
        <div class="weui-cell__hd">
            <label class="weui-label">地址:</label>
        </div>
        <div class="weui-cell__bd">
            <input id="province" class="weui-input" placeholder="请输入收货地址" value="${sessionScope.CLIENT_IN_SESSION.address}">
        </div>
        <div class="weui-cell__ft">
            <button id="edit_address" class="weui-vcode-btn" style="color: #649bc3">详细地址管理</button>
        </div>
    </div>


    <div class="weui-form-preview__ft">
        <a class="weui-form-preview__btn weui-form-preview__btn_default" href="javascript:"
           onclick="payment()">确定付款</a>
    </div>
</div>
</body>
<!-- body 最后 -->
<script src="//cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-weui/1.0.1/js/jquery-weui.min.js"></script>
<script>

    $(function () {
        $("#edit_address").click(function () {
            window.location.href="/edit_address.do"
        });
    });
    function payment() {
        var tel = $("#tel").val();
        var address=$("#province").val();
        $.post("/pay.do", {address: address,tel:tel},function(){
            window.location.href="/success.do"
        });
    }

</script>


</html>