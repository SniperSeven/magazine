<%--
  Created by IntelliJ IDEA.
  User: wall
  Date: 2017/9/7
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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


    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <link href="style.css" rel="stylesheet" type="text/css"/>
    <link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css"/>

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
        </div>
    </div>
</header>

<div class="weui-msg">
    <div class="weui-msg__icon-area"><i class="weui-icon-success weui-icon_msg"></i></div>
    <div class="weui-msg__text-area">
        <h2 class="weui-msg__title">购买成功成功</h2>
        <p class="weui-msg__desc">如果您还有更多的需要请联系:168888888</p>
    </div>
    <div class="weui-msg__opr-area">
        <p class="weui-btn-area">
            <a id="conform" href="javascript:;" class="weui-btn weui-btn_primary">
                <span style="color: #fafafa">
                    点击确定
                </span>
            </a>
            <a href="javascript:;" class="weui-btn weui-btn_default" onclick="operate()">
                点击取消
            </a>
        </p>
    </div>
</div>
</body>
<!-- body 最后 -->
<script src="//cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-weui/1.0.1/js/jquery-weui.min.js"></script>
<script>

    function operate() {
        alert("你觉得可能么……")
    }

    $("#conform").click(function () {
        window.location.href = "/product_index.do"
    });

</script>


</html>