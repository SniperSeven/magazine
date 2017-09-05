<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<!-- head 中 -->
<%--<link rel="stylesheet" href="//cdn.bootcss.com/weui/1.1.1/style/weui.min.css">
<link rel="stylesheet" href="//cdn.bootcss.com/jquery-weui/1.0.1/css/jquery-weui.min.css">--%>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script type="text/javascript">
    wx.config({
        debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
        appId: 'wx0c5d7a2b65075463', // 必填，公众号的唯一标识
        timestamp: '454545545', // 必填，生成签名的时间戳
        nonceStr: 'zmh', // 必填，生成签名的随机串
        signature: 'e2c725622df639672b776bf41b6ce898d47ad72c',// 必填，签名，见附录1
        jsApiList: ['onMenuShareTimeline'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
    });

    wx.ready(function(res){
        wx.onMenuShareTimeline({
            title: '标题', // 分享标题
            link: 'http://zhou.nat100.top/index.jsp', // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
            imgUrl: 'http://zhou.nat100.top/1.jpg', // 分享图标
            success: function () {
                // 用户确认分享后执行的回调函数
                window.location.href="http://zhou.nat100.top/main.do";
            },
            cancel: function () {
                // 用户取消分享后执行的回调函数
            }
        });
    });
</script>
</head>
<body>

<!-- body 最后 -->
<%--<script src="//cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-weui/1.0.1/js/jquery-weui.min.js"></script>--%>
</body>
</html>