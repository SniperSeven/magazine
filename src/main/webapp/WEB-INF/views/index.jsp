<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
   <%-- <script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
    <script type="text/javascript">
        wx.config({
            debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
            appId: 'wx0c5d7a2b65075463', // 必填，公众号的唯一标识
            timestamp: '454545545', // 必填，生成签名的时间戳
            nonceStr: 'zmh', // 必填，生成签名的随机串
            signature: '${signature}',// 必填，签名，见附录1
            jsApiList: ['onMenuShareTimeline','onMenuShareAppMessage','onMenuShareQQ','onMenuShareQZone'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
        });

        wx.ready(function(res){
            wx.onMenuShareTimeline({
                title: '心点芯蛋糕屋', // 分享标题
                link: 'http://zhou.nat100.top/index.jsp', // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
                imgUrl: 'http://mmbiz.qpic.cn/mmbiz_jpg/Dp5Cn2U86SWEic8gOtYiankbMRZwqb2DSUR9MEvmujpYBU36asHMElY7jkj7loTyFMtCFlU5Vfiae26ue7WlHfAOQ/0?wx_fmt=jpeg', // 分享图标
                success: function () {
                    // 用户确认分享后执行的回调函数
                    window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0c5d7a2b65075463&redirect_uri=http://zhou.natapp1.cc/product_index.do&response_type=code&scope=snsapi_base#wechat_redirect";
                },
                cancel: function () {
                    // 用户取消分享后执行的回调函数
                }
            });

            wx.onMenuShareAppMessage({
                title: '心点芯蛋糕屋', // 分享标题
                desc: '心点芯蛋糕屋', // 分享描述
                link: 'http://zhou.nat100.top/index.jsp', // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
                imgUrl: 'http://mmbiz.qpic.cn/mmbiz_jpg/Dp5Cn2U86SWEic8gOtYiankbMRZwqb2DSUR9MEvmujpYBU36asHMElY7jkj7loTyFMtCFlU5Vfiae26ue7WlHfAOQ/0?wx_fmt=jpeg', // 分享图标
                success: function () {
                    window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0c5d7a2b65075463&redirect_uri=http://zhou.natapp1.cc/product_index.do&response_type=code&scope=snsapi_base#wechat_redirect";
                },
                cancel: function () {
                    // 用户取消分享后执行的回调函数
                }
            });

            wx.onMenuShareQQ({
                title: '心点芯蛋糕屋', // 分享标题
                desc: '心点芯蛋糕屋', // 分享描述
                link: 'http://zhou.nat100.top/index.jsp', // 分享链接
                imgUrl: 'http://mmbiz.qpic.cn/mmbiz_jpg/Dp5Cn2U86SWEic8gOtYiankbMRZwqb2DSUR9MEvmujpYBU36asHMElY7jkj7loTyFMtCFlU5Vfiae26ue7WlHfAOQ/0?wx_fmt=jpeg', // 分享图标
                success: function () {
                    window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0c5d7a2b65075463&redirect_uri=http://zhou.natapp1.cc/product_index.do&response_type=code&scope=snsapi_base#wechat_redirect";
                },
                cancel: function () {
                    // 用户取消分享后执行的回调函数
                }
            });

            wx.onMenuShareQZone({
                title: '心点芯蛋糕屋', // 分享标题
                desc: '心点芯蛋糕屋', // 分享描述
                link: 'http://zhou.nat100.top/index.jsp', // 分享链接
                imgUrl: 'http://mmbiz.qpic.cn/mmbiz_jpg/Dp5Cn2U86SWEic8gOtYiankbMRZwqb2DSUR9MEvmujpYBU36asHMElY7jkj7loTyFMtCFlU5Vfiae26ue7WlHfAOQ/0?wx_fmt=jpeg', // 分享图标
                success: function () {
                    window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0c5d7a2b65075463&redirect_uri=http://zhou.natapp1.cc/product_index.do&response_type=code&scope=snsapi_base#wechat_redirect";
                },
                cancel: function () {
                    // 用户取消分享后执行的回调函数
                }
            });

        });

    </script>--%>
    <link rel="stylesheet" href="/static/css/style1.css">
    <title>Title</title>
    <style>
        body {
            color: #333;
            font-family: "微软雅黑", "宋体", Arial, Helvetica, sans-serif;
            font-size: 20px;
            line-height: 180%;
            margin: 0 auto !important;
            max-width: 640px;
            min-width: 320px;
        }

        .main_main {
            border-top: 8px solid #f0f0f0;
            height: 136px;
            padding-right: 2%;
        }

        li, img, label, input {
            border: medium none;
            vertical-align: middle;
        }

        ol, ul, li {
            list-style: outside none none;
        }

        .a_pass {
            color: #666;
            float: left;
            font-size: 0.6em;
            font-weight: bold;
            height: 30px;
            line-height: 30px;
            text-align: right;
            width: 100%;
        }

        .main_1 {
            border-radius: 6px;
            float: left;
            max-height: 128px;
            max-width: 128px;
            text-align: center;
            vertical-align: middle;
            width: 100%;
            margin-top: 15px;
        }

        .main_2 {
            float: left;
            max-height: 136px;
            max-width: 136px;
            overflow: hidden;
            width: 120%;
        }

        .main_3 {
            float: left;
            height: 136px;
            width: 100%;
        }

        .text_4 {
            float: right;
            font-size: 0.7em;
        }

        .text_1 {
            color: #67b6ba !important;
            float: right;
            font-size: 0.6em !important;
            font-weight: bold;
            white-space: nowrap;
        }

        a:link {
            color: #67b6ba;
            font-family: "微软雅黑", "宋体", Arial, Helvetica, sans-serif;
            font-size: 14px;
            text-decoration: none;
        }

        a, input, textarea {
            outline: 0 none;
            text-decoration: none;
        }

        .global-nav__nav-shop-cart-num {
            background: #f980b6 none repeat scroll 0 0;
            border-radius: 50%;
            color: #fff;
            font-size: 10px;
            font-weight: normal;
            height: 12px;
            line-height: 12px;
            position: absolute;
            text-align: center;
            top: 2px;
            width: 12px;
        }

        /*头部*/

        .v_nav {
            background-color: #fff;
            border-top: 1px solid #dcdcdc;
            box-shadow: 1px 1px 12px #ccc;
            height: 45px;
            margin: 0;
            max-width: 640px;
            padding: 4px 0;
            position: fixed;
            top: 0;
            width: 100%;
            z-index: 99999;
        }

        .vf_nav {
            height: 45px;
            margin: auto auto auto 10%;
            max-width: 640px;
            padding: 0;
            width: 80%;
        }

        .vf_nav ul li {
            float: left;
            height: 45px;
            margin: 0;
            text-align: center;
            width: 33%;
        }

        .vf_nav ul li i {
            display: block;
            height: 25px;
            margin: auto;
            width: 25px;
        }

        ol, ul, li {
            list-style: outside none none;
        }

        .vf_nav ul li span {
            display: block;
            height: 20px;
            line-height: 20px;
            width: 100%;
        }

        .vf_nav ul li a {
            color: #67b6ba;
            display: block;
            font-size: 12px;
            height: 45px;
            margin: auto;
            position: relative;
            text-align: center;
            width: 50px;
        }

        .vf_1 {
            background-position: 0 -1px;
        }

        .vf_5 {
            background-position: 0 -133px;
        }

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
            color: #3b2cff;
            display: none
        }

        .footer {
            background-color: #fff;
            border-top: 8px solid #f0f0f0;
            overflow: hidden;
            padding-bottom: 10px;
            padding-top: 10px;
            text-align: center;
            width: 100%;
        }
        html, body, div, p, ul, li, dl, dt, dd, h1, h2, h3, h4, h5, h6, form, input, select, button, textarea, iframe, table, th, td {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        html, body, div, p, ul, li, dl, dt, dd, h1, h2, h3, h4, h5, h6, form, input, select, button, textarea, iframe, table, th, td {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        li, img, label, input {
            border: medium none;
            vertical-align: middle;
        }
        fieldset, img {
            border: 0 none;
        }
        img {
            border: 0 none;
        }

        .footertext a:link {
            color: #132545;
            font-family: "微软雅黑","宋体",Arial,Helvetica,sans-serif;
            font-size: 24px;
            font-weight: bolder;
            text-decoration: none;
        }
        .footer a {
            display: inline-block;
        }
        a:link {
            color: #67b6ba;
            font-family: "微软雅黑","宋体",Arial,Helvetica,sans-serif;
            font-size: 14px;
            text-decoration: none;
        }
        a, input, textarea {
            outline: 0 none;
            text-decoration: none;
        }

        .footer .links {
            background: rgba(0, 0, 0, 0) none repeat scroll 0 0;
            margin: 0 auto;
            width: 75%;
        }
        html, body, div, p, ul, li, dl, dt, dd, h1, h2, h3, h4, h5, h6, form, input, select, button, textarea, iframe, table, th, td {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }
        .footer .links a {
            border-right: 1px solid #dcdcdc;
            font-size: 14px;
            height: 20px;
            line-height: 20px;
            padding-left: 10px;
            padding-right: 10px;
        }
        .footer a {
            display: inline-block;
        }
        a:link {
            color: #67b6ba;
            font-family: "微软雅黑","宋体",Arial,Helvetica,sans-serif;
            font-size: 14px;
            text-decoration: none;
        }
        a, input, textarea {
            outline: 0 none;
            text-decoration: none;
        }

        .footer span {
            color: #132545;
        }

        element.style {
            color: #132545;
        }
        .footer .links a:last-child {
            border-right: 0 none;
        }
        .footer .links a {
            border-right: 1px solid #dcdcdc;
            font-size: 14px;
            height: 20px;
            line-height: 20px;
            padding-left: 10px;
            padding-right: 10px;
        }
        .footer a {
            display: inline-block;
        }
        a:link {
            color: #67b6ba;
            font-family: "微软雅黑","宋体",Arial,Helvetica,sans-serif;
            font-size: 14px;
            text-decoration: none;
        }
        a, input, textarea {
            outline: 0 none;
            text-decoration: none;
        }

        .footer p {
            line-height: 20px;
            text-align: center;
        }
        .mf_o4 {
            color: #132545;
            font-size: 10px;
        }
    </style>
</head>
<body>
<%--头部--%>
<div class="v_nav">
    <div class="vf_nav">
        <ul>
            <li>
                <a href="/product_index.do">
                    <i class="vf_1"><img height="20px" src="/static/image/index.png"></i>
                    <span>首页</span></a>
            </li>
            <li>
                <a href="/indevidal.do">
                    <i class="vf_5"><img height="20px" src="/static/image/individual.png"></i>
                    <span>个人中心</span>
                </a>
            </li>
            <li>
                <a href="/shoppingCart.do">
                    <em id="ECS_CARTINFO" class="global-nav__nav-shop-cart-num" style="right:9px;"> ${sessionScope.productNum}
                    </em>
                    <i class="vf_4"><img height="20px" src="/static/image/shoppingCart.png"></i>
                    <span>购物车</span>
                </a>
            </li>
        </ul>
    </div>
</div>


<%--主页大图--%>
<div id="scrollimg" class="scrollimg">
    <div class="bd">
        <div class="tempWrap slider" style="overflow:hidden; position:relative;">
            <ul style="width: 2560px; position: relative; overflow: hidden; padding: 0px; margin: 0px;
            transition-duration: 0ms;">
                <c:forEach items="${headProducts}" var="h">
                    <li style="display: table-cell; vertical-align: top; width: 640px;">
                        <a href="/comment.do?id="+${h.id}>
                            <img width="100%" src="${h.detailImg}">
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<script type="text/javascript">

</script>


<c:forEach items="${result.rows}" var="product">
    <li class="main_main">
        <div style="width:28%;float: left;height: 136px;text-align: center;">
            <a target="_blank" href="/comment.do?id=${product.id}">
                <img class="main_1" alt="${product.name}" src="${product.imageURL}">
            </a>
        </div>
        <div style="width:38%;float: left;height: 136px;text-align: center;overflow: hidden;">
            <a target="_blank" href="/comment.do?id=${product.id}">
                <img class="main_2" alt="${product.name}" src="${product.secondImg}">
            </a>
        </div>
        <div style="width:34%;float: left;height: 136px;text-align: right;">
            <div class="main_3">
                <span class="a_title">
                     <a class="text_1" target="_blank" title="${product.name}"
                        href="/comment.do?id=${product.id}">${product.name}</a>
                </span>
                <span class="a_pass">${product.introduce}</span>
                <span class="a_pass">
                    <a class="show_cart" href="javascript:;" data-productid="${product.id}">
                        <img height="15px" src="/static/image/shoppingCart.png">
                    </a>
                </span>

                </div> <div class="a_money">
                    <span class="text_4">
                        <font class="shop" style="color: #666;">￥${product.salePrice}</font>
                        <font class="market" style="color: #666;font-size: 12px;">/ ${product.weight} 磅 </font>
                    <br>
                    </span>
                <span class="bug_car" onclick="addToCart()"> </span>
            </div>
        </div>
    </li>
</c:forEach>
<div id="msg">已成功加入购物车！</div>
<div class="footer" >
    <div class="footertext"><img src="/static/image/dianhua.png" width="24px" height="24px"><a href="tel:4006665988">400 666 888</a> </div>
    <div class="links"  id="ECS_MEMBERZONE">
       <span>关于我们</span>
    </div>
    <p class="mf_o4">&copy; 2017/9/3 - 2017/9/8 心点芯蛋糕 版权所有，并保留所有权利</p>
</div>

</body>
<script src="/static/plugins/jquery.min.js"></script>
<script src="/static/plugins/YuxiSlider.jQuery.min.js"></script>
<script src="/static/plugins/jquery.fly.min.js"></script>
<script src="/static/plugins/requestAnimationFrame.js"></script>
<script src="/static/js/index.js"></script>

<script>
    $(".slider").YuxiSlider({
        height: 450, //容器高度
        during: 4000, //间隔4秒自动滑动
        speed: 800, //移动速度0.8秒
        mousewheel: true //是否开启鼠标滚轮控制
    });
</script>
</html>

