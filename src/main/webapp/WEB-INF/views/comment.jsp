<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html >
<!DOCTYPE html>
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
    <link href="../../comment/basic/css/demo.css" rel="stylesheet" type="text/css"/>
    <link type="text/css" href="../../comment/css/optstyle.css" rel="stylesheet"/>
    <script type="text/javascript" src="../../comment/basic/js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="../../comment/js/list.js"></script>

    <style type="text/css">
        *{ padding:0; margin:0; list-style:none; border:0;}
        .all{ width: 380px; height: 300px; padding: 7px; position: relative; }
        .screen{
            width:380px;
            height:300px;
            overflow:hidden;
            position:relative;
        }
        .screen li{ width:380px; height:300px; overflow:hidden; float:left;}
        .screen ul{ position:absolute; left:0; top:0px; width:6000px;}
        .all ol{ position:absolute; right:10px; bottom:10px; line-height:20px; text-align:center;}
        .all ol li{ float: left; width: 15px; height: 10px; background: #fff;  margin-left: 5px;
            cursor: pointer; font-size: 0px; font-family: Verdana; line-height: 15px; border-radius: 15px; }
        .all ol li.current{ background:#2bb4e8;}
    </style>
    <script type="text/javascript" src="../../comment/picRun/picRun.js"></script>

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
    <input id="productId" type="hidden" value="${product.id}">
    <div class="tab_nav">
        <div class="header">
            <div class="h-left">
                <a class="sb-back" href="javascript:history.back(-1)" title="返回"> < </a>
            </div>
            <div class="h-mid"> </div>
            <div class="h-right">
                <aside class="top_bar">


                    <a id="mc-menu-hd" href="#" target="_top">
                        <i class="am-icon-shopping-cart  am-icon-fw"></i>
                        <!--<span>购物车</span>-->
                        <strong id="J_MiniCartNum" class="h">0</strong>
                    </a>


                    <!--<div onClick="show_menu();$('#close_btn').addClass('hid');" id="show_more">-->
                    <!--<a href="javascript:;">...</a>-->
                    <!--</div>-->

                </aside>
            </div>
        </div>
    </div>
</header>


<p style="height: 20px"></p>
<div class="all" id='all' style="left: -7px;top:-27px;">
    <div class="screen">
        <ul>
            <li><a href="#"><img src="${product.imageURL}" width="380" height="300" /></a></li>
            <li><a href="#"><img src="${product.secondImg}" width="380" height="300" /></a></li>
            <li><a href="#"><img src="${product.imageURL}" width="380" height="300" /></a></li>
        </ul>
    </div>
    <ol>
    </ol>
</div>

<div id="tbh5v0">
</div>

<div class="item-inform">

    <div class="clearfixRight" style="clear:both;">

        <!--规格属性-->
        <!--名称-->
        <div class="tb-detail-hd">
            <hr style="height:1px;border:none;border-top:1px dashed rgba(202,202,202,0.36);"/>
            <h1 style="color: #379cbe">
                <span style="color: #fafafa">xx</span>
                ${product.name}
            </h1>
            <span style="color: #fafafa">xx</span>
            <input type="text" style="color:#cacaca;" value="产品类型:&nbsp;奶油类">
        </div>
        <div class="tb-detail-list">
            <!--价格-->
            <div class="price">
                <dd>
                    <b class="sys_item_price">
                        <h1 style="color: #379cbe">
                            <span style="color: #fafafa">xx</span>
                            <span class="J_Price price-now">¥</span>
                            <span id="money" class="J_Price price-now">${product.salePrice}</span>
                            <span style="color: #fafafa">xx</span>
                            重量:${product.weight}磅
                            <span style="color: #fafafa">xx</span>
                        </h1>
                    </b>
                </dd>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
            <div class="theme-popbod dform">
                <form class="theme-signin" name="loginform" action="" method="post">
                    <div class="theme-signin-left">
                        <div class="theme-options">
                            <%--<ul>
                                <li class="sku-line selected" id="one">
                                    <span style="color: #fafafa">xx</span>
                                    1.0磅
                                    <span style="color: #fafafa">xx</span>
                                    <i></i></li>
                                <li class="sku-line " id="two">
                                    <span style="color: #fafafa">xx</span>
                                    2.0磅
                                    <span style="color: #fafafa">xx</span>
                                    <i></i></li>
                            </ul>--%>
                        </div>
                        <div class="theme-options">
                            <dd>
                                <span style="color: #fafafa">x</span>
                                <input id="min" class="am-btn am-btn-default" name="" type="button" value="-"/>
                                <input id="text_box" name="" type="text" value="1" style="width:20px;left:80px"/>
                                <input id="add" class="am-btn am-btn-default" name="" type="button" value="+"/>
                            </dd>

                        </div>
                        <div class="clear"></div>
                    </div>
                    <!--<div class="theme-signin-right">-->
                    <!--<div class="img-info">-->
                    <!--<img src="../images/songzi.jpg"/>-->
                    <!--</div>-->
                    <!--<div class="text-info">-->
                    <!--<span class="J_Price price-now">¥39.00</span>-->
                    <!--</div>-->
                    <!--</div>-->

                </form>
            </div>

            <div style="clear:both;">
                <span style="color: #fafafa">x</span>
                <spen style="color: #aba8a8;"></spen>
            </div>
            <div class="clear"></div>
            <!--活动	-->
        </div>
    </div>
    <div class="clear"></div>
</div>

<div class="weui-cells weui-cells_form">
    <div class="weui-cell">
        <div class="weui-cell__bd">
            <textarea class="weui-textarea" placeholder="${product.introduce}" rows="3"></textarea>
            <div class="weui-textarea-counter"><span>0</span>/200</div>
        </div>
    </div>
</div>



<div class="introduce">
    <div class="introduceMain">
        <div class="am-tabs" data-am-tabs>
            <ul class="am-avg-sm-3 am-tabs-nav am-nav am-nav-tabs"></ul>
            <div class="am-tabs-bd">
                <div class="am-tab-panel am-fade am-in am-active">


                    <div class="details">
                        <div class="twlistNews">
                            <img src="../../comment/image2/0.png" width="280" height="100"/>
                            <!--<img src="image2/3.png"/>-->
                        </div>
                    </div>
                    <div class="clear"></div>

                </div>

            </div>

        </div>
        <div class="clear"></div>
    </div>
</div>



<script language="javascript">
    $(function () {
        $('input[type=text],input[type=password]').bind({
            focus: function () {
                $(".global-nav").css("display", 'none');
            },
            blur: function () {
                $(".global-nav").css("display", 'flex');
            }
        });
    })
</script>

<a href="javascript:;" class="weui-btn weui-btn_default" onclick="addCart()">加入购物车</a>



</body>
<!-- body 最后 -->
<script src="//cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-weui/1.0.1/js/jquery-weui.min.js"></script>
<script type="text/javascript">
    function addCart() {
        var amount = $("#text_box").val();
        var productId = $("#productId").val();
        $.post("/product_addCart.do", {productId: productId,amount:amount}, function (data) {
            $.messager.alert("温馨提示", data.msg, "info");
        });
    }
</script>
</html>