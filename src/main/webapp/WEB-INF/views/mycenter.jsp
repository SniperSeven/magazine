<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html >
<html>
<head>
    <meta name="Generator" content="ECSHOP v2.7.3"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width">
    <title>用户中心_心点芯蛋糕官网_24小时在线订购_当日新鲜送达 </title>
    <meta name="Keywords" content=""/>
    <meta name="Description" content=""/>
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=0"/>
    <link rel="stylesheet" type="text/css" href="themesmobile/68ecshopcom_mobile/css/user.css"/>
    <link rel="stylesheet" type="text/css" href="themesmobile/68ecshopcom_mobile/css/public.css"/>
    <script src="themesmobile/68ecshopcom_mobile/js/modernizr.js"></script>
    <script type="text/javascript" src="themesmobile/68ecshopcom_mobile/js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.json.js"></script>
    <script type="text/javascript" src="js/transport.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/utils.js"></script>
</head>
<link href="/static/css/mycenter.css" rel="stylesheet" type="text/css"/>
<body>

<!-- 引入微信的js  sdk  接口 中 -->
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<!--通过config接口注入权限验证配置-->
<%--<script type="text/javascript">
    wx.config({
        debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。

        appId: 'wxef42e3388dc5b26d', // 必填，公众号的唯一标识

        timestamp: '3333', // 必填，生成签名的时间戳

        nonceStr: '333', // 必填，生成签名的随机串

        signature: '654a99c64e6560f0d0e857533ec118f80437b202',// 必填，签名，见附录1

        jsApiList: ['onMenuShareTimeline'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2

    });
</script>--%>
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
                    <em id="ECS_CARTINFO" class="global-nav__nav-shop-cart-num"
                        style="right:9px;"> ${sessionScope.productNum}
                    </em>
                    <i class="vf_4"><img height="20px" src="/static/image/shoppingCart.png"></i>
                    <span>购物车</span>
                </a>
            </li>
        </ul>
    </div>
</div>

<div class="v_nav_1" style="background: #67b6ba;position: fixed;top: 0;width: 100%;height: 45px;background-color: #67b6ba;
z-index: 97;padding: 0px;margin: 0px;padding-bottom: 4px;padding-top: 4px;max-width: 640px;display:none;">
    <div style="width: 100%;height: 45px;margin: auto;padding: 0px;margin: 0px;max-width: 640px;">
        <ul>
            <li style="width:10%;float:left;text-align: center;" class="close1">
                <img src="themesmobile/68ecshopcom_mobile/images/flow/c_cancel_1.png"
                     style=" width: 16px;height: 16px;margin-top: 16px;">
            </li>
            <li style="width:15%;float:left;text-align: center;" class="close1">
                <img src="themesmobile/68ecshopcom_mobile/images/flow/weixin.png"
                     style=" width: 36px;height: 36px;margin-top: 5px;border-radius: 10px;">
            </li>

            <li style="width:75%; float:left;">
                <h4 style="font-size:10px;color:#fff;margin-top: 8px;line-height: 12px;">微信关注“心点芯”公众号</h4>
                <h4 style="font-size:12px;color:#fff;margin-top: 8px;line-height: 12px;">更流畅的购物体验</h4>

            </li>
        </ul>
        <script type="text/javascript">
            function checkPlatform() {
                if (/android/i.test(navigator.userAgent)) {
                    if (/MicroMessenger/i.test(navigator.userAgent)) {
                        $(".v_nav_1").css("display", "none");
                    }
                    else {
                        $(".v_nav_1").css("display", "block");
                        $(".v_nav").css("top", "52px");
                        $(".showpage").css("margin-top", "114px");
                        $(".com_top").css("top", "54px");
                        $(".border-bt").css("margin-top", "50px");
                        $(".close1").click(function () {
                            $(".v_nav_1").css("display", "none");
                            $(".border-bt").css("margin-top", "0px");
                            $(".v_nav").css("top", "0px");
                            $(".com_top").css("top", "0px");
                            $(".showpage").css("margin-top", "62px");
                        })
                    }
                }
                else {
                    if (/(iPhone|iPad|iPod|iOS)/i.test(navigator.userAgent)) {
                        if (/MicroMessenger/i.test(navigator.userAgent)) {
                            $(".v_nav_1").css("display", "none");
                        }
                        else {
                            $(".v_nav_1").css("display", "block");
                            $(".v_nav").css("top", "52px");
                            $(".showpage").css("margin-top", "114px");
                            $(".com_top").css("top", "54px");
                            $(".border-bt").css("margin-top", "50px");
                            $(".close1").click(function () {
                                $(".v_nav_1").css("display", "none");
                                $(".border-bt").css("margin-top", "0px");
                                $(".v_nav").css("top", "0px");
                                $(".com_top").css("top", "0px");
                                $(".showpage").css("margin-top", "62px");
                            })
                        }
                    }
                }
            }
            $(document).ready(function () {
                checkPlatform();
            });
        </script>
    </div>
</div>
<div id="tbh5v0">
    <div class="user_com">

        <div class="com_top">
            <!--<h2 style="display:none;"><a href="user.php?act=profile">设置</a></h2>-->
            <dl>
                <dt><img src="/static/image/user68.jpg"> <span>${sessionScope.CLIENT_IN_SESSION.name}</span>

                    <span><a href="security.php"
                             style="color:#fff;background: #67b6ba;padding: 1% 5%;border-radius: 6px;">账户管理</a></span>

                </dt>

            </dl>
        </div>

        <div class="Wallet">
            <ul>
                <li class="bain1"><strong>￥0.00</strong><span>余额</span></li>
                <li class="bain2"><strong>0</strong><span>卡券</span></li>
                <!--<li><strong>0第郎</strong><span>第郎</span></li>--></ul>
        </div>


        <div class="Wallet">
            <a href=""><em class="Icon Icon2"></em>
                <dl class="b">
                    <dt>全部订单</dt>
                    <dd>查看订单</dd>
                </dl>
            </a>
            <%-- <a href=""><em class="Icon Icon3"></em><dl class="b"><dt>我的卡券</dt><dd>查看卡券</dd></dl></a>--%>
            <a href="/"><em class="Icon Icon5"></em>
                <dl class="b">
                    <dt>地址管理</dt>
                    <dd>查看地址</dd>
                </dl>
            </a>
            <%-- <a href=""><em class="Icon Icon4"></em><dl class="b"><dt>我的评价</dt><dd>查看评价</dd></dl></a>--%>
            <!--<a onClick="bindPhone()" href="javascript:return false;"><em class="Icon Icon10"></em><dl class="b"><dt>生日提醒</dt><dd>生日提醒</dd></dl></a>-->
            <!--<a href="user.php?act=profile" style='display:none;opacity:0;'><em class="Icon Icon11"></em><dl class="b"><dt>修改资料</dt><dd>修改资料</dd></dl></a>-->
        </div>
        <div class="Wallet" style="display:none;opacity:0;">
            <!--<a href="user.php?act=affiliate"><em class="Icon Icon6"></em><dl class="b"><dt>我的推荐</dt><dd>&nbsp;</dd></dl></a>-->
            <a href="user.php?act=message_list"><em class="Icon Icon7"></em>
                <dl class="b">
                    <dt>我的留言</dt>
                    <dd>&nbsp;</dd>
                </dl>
            </a>
            <a href="user.php?act=my_comment"><em class="Icon Icon4"></em>
                <dl class="b">
                    <dt>我的评价</dt>
                    <dd>查看评价</dd>
                </dl>
            </a>
            <a href="user.php?act=collection_list"><em class="Icon Icon10"></em>
                <dl>
                    <dt>我的收藏</dt>
                    <dd>&nbsp;</dd>
                </dl>
            </a>
        </div>
        <div class="Wallet" style="display:none;opacity:0;">
            <a href="javascript:void(0)" onClick="window.location.href='user.php?act=logout'"><em
                    class="Icon Icon8"></em>
                <dl>
                    <dt>注销登录</dt>
                </dl>
            </a>
        </div>
    </div>
    <div id="bindPhonebg"
         style="width:100%;height:100%;position:fixed;top:0px;left:0px;background-color:rgba(0,0,0,0.4);z-index:100000;display:none;"></div>
    <div id="bindPhone"
         style="position:fixed;top:10%;left:0%;z-index:100000;background-color:rgba(19, 38, 69,0.9);width:280px;height:260px;border-radius:8px;overflow:hidden;font-size:16px;line-height:20px;display:none;">
        <div style="width:100%;height:100%;position:relative;">
            <div id='close_bindPhone'
                 style='width:16px;line-height:22px;font-size:18px;color:#ddd;position:absolute;top:0px;right:3px;cursor:pointer;'>
                ×
            </div>
            <div style="font-size:14px;line-height:18px;color:#dfdfdf;text-align:center;padding-top:30px;"
                 id="bindtitle">您还没有绑定您的手机号</br>请您绑定后设置生日提醒
            </div>
            <form style="width:100%;margin-top:10px;" id="eventBox">
                <div style="width:65%;margin:0 auto;">
                    <div>
                        <div style="font-size:12px;color:#dfdfdf;">手机号码：</div>
                        <div><input type="text" name="bindphone"
                                    style="width:100%;border:none;height:24px;border-radius:6px;font-size:14px;text-align:center;"
                                    placeholder="请输入手机号码"/></div>
                    </div>
                    <div>
                        <div style="font-size:12px;color:#dfdfdf;">滑块验证：</div>
                        <div style="width:100%;height:26px;border-radius:6px;background-color:#c6ff00;position:relative;line-height:26px;color:#666;font-size:14px;text-align:center;"
                             id="sliderBox">

                            <span>拖动滑块验证</span>
                            <div style="position:absolute;left:1px;top:2px;height:22px;border-radius:6px;width:40px;background-color:#3ea13d;color:#c6ff00;text-align:center;line-height:22px;"
                                 id="bindslider">>
                            </div>
                        </div>
                    </div>
                    <div id="yzmBox" style="position:relative;display:none;">
                        <div style="font-size:12px;color:#dfdfdf;">获取验证码：</div>
                        <div>
                            <input type="text" name="bindphoneyzm" id="bindphoneyzm"
                                   style="width:40%;border:none;text-align:center;height:24px;border-radius:6px;font-size:12px;"
                                   placeholder="验证码"/>
                            <input id="yzmBtn" type="button"
                                   style="border: none; display:block;width:55%;background-color:#c6ff00;color:#666;font-size:12px;border-radius:6px;position:absolute;left:45%;top:20px;height:24px;line-height:24px;text-align:center;"
                                   value="获取验证码">
                        </div>
                    </div>
                    <div style="margin-top:20px;">
                        <span style="display:block;width:55%;background-color:#c6ff00;color:#666;font-size:12px;border-radius:6px;height:24px;line-height:24px;text-align:center;margin:0 auto;"
                              id="bindbtn">绑定手机号</span>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <script>

        var wait = 60;
        function countdown(obj, msg) {
            obj = $(obj);

            if (wait == 0) {
                obj.removeAttr("disabled");
                obj.val(msg);
                wait = 60;
            } else {
                if (msg == undefined || msg == null) {
                    msg = obj.val();
                }
                obj.attr("disabled", "disabled");
                obj.val(wait + "秒");
                wait--;
                setTimeout(function () {
                    countdown(obj, msg)
                }, 1000)
            }
        }

        $("#yzmBtn").bind('click', function () {
            var mobile_phone = $("#bindphone").val();
            if (!/^1\d{10}/.test(mobile_phone)) {
                alert("手机号格式不正确");
                return false;
            }
            var url = 'user.php?act=send_mobile_code';
            $.post(url, {
                mobile_phone: mobile_phone,
            }, function (result) {
                if (result == 'ok') {
                    // 倒计时
                    countdown($('#yzmBtn'));
                } else {
                    alert(result);
                }
            }, 'text');

        })

        function bindPhone() {
            var time = new Date().getTime();
            $.ajax({
                url: 'user.php?act=ajax_check_bind',
                data: {
                    time: time
                },
                type: 'POST',
                dataType: 'JSON',
                success: function (data) {
                    console.log(data);
                    if (data.status) {
                        location.href = "user.php?act=birthday_reminder";
                        return false;
                    } else {
                        //位置定位
                        $("#bindPhone").css({
                            top: parseInt(($(window).height() - 300) / 2) + "px",
                            left: parseInt(($(window).width() - 280) / 2) + "px",
                        });
                        $("#bindPhone").fadeIn(200);
                        $("#bindPhonebg").fadeIn(200);
                    }
                }
            });
        }
        (function (e) {
            var iscomplete = true;
            var sliderIsOpen = false;
            var startPosX = 0, movePosX = 0;
            $("#close_bindPhone").bind("click", function () {
                $("#bindPhone").fadeOut(100);
                $("#bindPhonebg").fadeOut(100);
                $("#bindslider").css({left: "1px"});
                $("#sliderBox").find("span").html("拖动滑块验证");
                $("#bindslider").html(">");
                $("#yzmBox").hide();
                iscomplete = true;
            })
            $("#bindslider").bind("touchstart", function () {
                if (iscomplete) {
                    sliderIsOpen = true;
                }

            })
            $("#eventBox").bind("touchend", function () {
                if (sliderIsOpen) {
                    var length = movePosX - startPosX;
                    if (length < ($("#sliderBox").width() - $("#bindslider").width() - 3)) {
                        $("#bindslider").css({left: "1px"});

                    }
                }
                sliderIsOpen = false;
            })
            $("#eventBox").bind("touchstart", function () {
                var event = window.event;
                startPosX = event.touches[0].pageX;
            })
            $("#eventBox").bind("touchmove", function () {
                var event = window.event;
                event.preventDefault();
                movePosX = event.touches[0].pageX;
                if (sliderIsOpen) {
                    var length = movePosX - startPosX;
                    if (length > 0) {
                        if (length < ($("#sliderBox").width() - $("#bindslider").width() - 3)) {
                            $("#bindslider").css({left: (1 + length) + "px"});
                        } else if (length >= ($("#sliderBox").width() - $("#bindslider").width() - 3)) {
                            $("#bindslider").css({left: ($("#sliderBox").width() - $("#bindslider").width() - 2) + "px"});
                            $("#sliderBox").find("span").html("验证成功");
                            $("#bindslider").html("√");
                            $("#bindtitle").css("padding-top", "10px");
                            $("#yzmBox").show();
                            iscomplete = false;
                        }
                    }
                }
            })
            $("#bindbtn").bind("click", function () {
                var event = window.event;
                event.preventDefault();
                // $(this).css({backgroundColor:"#5F7B00",color:"#333"});
                var mobile_phone = $("#bindphone").val();
                var mobile_code = $("#bindphoneyzm").val();
                if (!/^1\d{10}/.test(mobile_phone)) {
                    alert("手机号格式不正确");
                    return false;
                }
                if (mobile_code.length == 0) {
                    alert("验证码不能为空");
                    return false;
                }
                var url = 'user.php?act=ajax_bing_phone';
                $.post(url, {
                    mobile_phone: mobile_phone,
                    mobile_code: mobile_code
                }, function (data) {
                    if (data.status) {
                        alert(data.info);
                        location.href = "user.php?act=birthday_reminder";
                        return false;
                    } else {
                        alert(data.info);
                    }
                }, 'JSON');
            })
            // $("#bindbtn").bind("touchend",function(){
            // 	$(this).css({backgroundColor:"#c6ff00",color:"#666"});
            // })
            $("input[name='bindphone']").bind("blur", function () {
                if (!$(this).val().match(/^1[3|4|5|7|8][0-9]{9}$/g) || $(this).val() == "") {
                    alert("请输入正确的手机号码！")
                }
            })
        })();
    </script>


    <div class="footer">
        <div class="footertext"><img src="/static/image/dianhua.png" width="24px" height="24px"><a
                href="tel:4006585776">400 800 110</a></div>
        <div class="links" id="ECS_MEMBERZONE">
            <a href="user.php">
                <span>${sessionScope.CLIENT_IN_SESSION.name}
                </span></a>
            <a href="http://www.dijoncake.com/mobile/article.php?id=119" style="color:#132545;">关于我们</a>
        </div>
        <p class="mf_o4">&copy; 2017/9/3 - 2017/9/8 心点芯蛋糕 版权所有，并保留所有权利</p>
    </div>
    <script>
        var _hmt = _hmt || [];
        (function () {
            var hm = document.createElement("script");
            hm.src = "//hm.baidu.com/hm.js?389ca79cd8d5a1e62eb22a02b68fbfa7";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>
</div>

</body>
</html>
