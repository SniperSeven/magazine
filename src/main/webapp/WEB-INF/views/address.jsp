<%--
  Created by IntelliJ IDEA.
  User: wall
  Date: 2017/9/7
  Time: 9:23
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
        </div>
    </div>
</header>


<h1>
    <span style="color: #ffffff">x</span>
    收货地址管理 :
</h1>


<div class="weui-cell weui-cell_vcode">
    <div class="weui-cell__hd">
        <label class="weui-label">省份:</label>
    </div>
    <div class="weui-cell__bd">
        <input id="province" class="weui-input" placeholder="请输入……">
    </div>
    <div class="weui-cell__ft" onclick="city('province','广东')">
        <button class="weui-vcode-btn">获取省份</button>
    </div>
</div>
<div class="weui-cell weui-cell_vcode">
    <div class="weui-cell__hd">
        <label class="weui-label">城市:</label>
    </div>
    <div class="weui-cell__bd">
        <input id="city" class="weui-input" placeholder="请输入……">
    </div>
    <div class="weui-cell__ft" onclick="city('city','广州')">
        <button class="weui-vcode-btn">获取城市</button>
    </div>
</div>
<div class="weui-cell weui-cell_vcode">
    <div class="weui-cell__hd">
        <label class="weui-label">地区:</label>
    </div>
    <div class="weui-cell__bd">
        <input id="area" class="weui-input" placeholder="请输入……">
    </div>
    <div class="weui-cell__ft" onclick="city('area','天河')">
        <button class="weui-vcode-btn">获取地区</button>
    </div>
</div>


<h3>
    <span style="color: #ffffff">x</span>
    详情地址
</h3>
<div class="weui-cells weui-cells_form">
    <div class="weui-cell">
        <div class="weui-cell__bd">
            <textarea id="detaiArea" class="weui-textarea" placeholder="……" rows="13"></textarea>
            <div class="weui-textarea-counter"><span>0</span>/200</div>
        </div>
    </div>
</div>

<a href="javascript:;" id="gogo" class="weui-btn weui-btn_plain-xxx" onclick="gogo()">提交</a>

</body>
<!-- body 最后 -->
<script src="//cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-weui/1.0.1/js/jquery-weui.min.js"></script>
<script>

    function city(idName, name) {
        $("#" + idName).attr("value", name);
    }

    function gogo() {
        var address = ""+$("#province").val() + $("#city").val() + $("#area").val() + $("#detaiArea").val();
        $.post( "/back_dealBill.do",{address:address},function () {
            window.location.href = "/dealBill.do";
        })
    }


</script>


</html>