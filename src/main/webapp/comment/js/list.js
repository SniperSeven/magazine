// JavaScript Document

//商品规格选择
$(function() {
    var mo = $("#money");
    var price = mo.html();
    var one = $("#one");
    var two = $("#two");
	var num=1;

	$(".theme-options").each(function() {
		var i = $(this);
		var p = i.find("ul>li");
		p.click(function() {
			if (!!$(this).hasClass("selected")) {
				$(this).removeClass("selected");

			} else {
				var s = $(this).addClass("selected");
				s.siblings("li").removeClass("selected");
				if(s.html()==one.html()){
					mo.html(price);
					num=1;
				}else if(s.html()==two.html()){
					num=2;
					mo.html(price*num);
				}

			}

		})
	})

})


// //弹出规格选择
// $(document).ready(function() {
// 	var $ww = $(window).width();
// 	if ($ww <1025) {
// 		$('.theme-login').click(function() {
// 			$(document.body).css("position", "fixed");
// 			$('.theme-popover-mask').show();
// 			$('.theme-popover').slideDown(200);
//
// 		})
//
// 		$('.theme-poptit .close,.btn-op .close').click(function() {
// 			$(document.body).css("position", "static");
// 			//					滚动条复位
// 			$('.theme-signin-left').scrollTop(0);
//
// 			$('.theme-popover-mask').hide();
// 			$('.theme-popover').slideUp(200);
// 		})
//
// 	}
// })

//导航固定
$(document).ready(function() {
	var $ww = $(window).width();
	var dv = $('ul.am-tabs-nav.am-nav.am-nav-tabs'),
		st;

	if ($ww < 623) {

				var tp =$ww+363;
				$(window).scroll(function() {
					st = Math.max(document.body.scrollTop || document.documentElement.scrollTop);
					if (st >= tp) {
						if (dv.css('position') != 'fixed') dv.css({
							'position': 'fixed',
							top: 53,
							'z-index': 1000009
						});

					} else if (dv.css('position') != 'static') dv.css({
						'position': 'static'
					});
				});
				//滚动条复位（需要减去固定导航的高度）

				$('.introduceMain ul li').click(function() {
					sts = tp;
					$(document).scrollTop(sts);
				});
       } else {

		dv.attr('otop', dv.offset().top); //存储原来的距离顶部的距离
		var tp = parseInt(dv.attr('otop'))+36;
		$(window).scroll(function() {
			st = Math.max(document.body.scrollTop || document.documentElement.scrollTop);
			if (st >= tp) {
             
					if (dv.css('position') != 'fixed') dv.css({
						'position': 'fixed',
						top: 0,
						'z-index': 998
					});

				//滚动条复位	
				$('.introduceMain ul li').click(function() {
					sts = tp-35;
					$(document).scrollTop(sts);
				});

			} else if (dv.css('position') != 'static') dv.css({
				'position': 'static'
			});
		});



	}
});



$(document).ready(function() {
	// //优惠券
	// $(".hot span").click(function() {
	// 	$(".shopPromotion.gold .coupon").toggle();
	// })

	var price=0;

	//获得文本框对象
	var t = $("#text_box");
	var mo = $("#money");
	//初始化数量为1,并失效减
	$('#min').attr('disabled', true);
	//数量增加操作
	$("#add").click(function() {
        var mon = parseInt(mo.html());
        var num = mon/t.val();
		t.val(parseInt(t.val()) + 1)
		if (parseInt(t.val()) != 1) {
			$('#min').attr('disabled', false);
		}
		mo.html(mon+num);
	})
		//数量减少操作
	$("#min").click(function() {
		var num = mo.html()/t.val();
		mo.html(mo.html()-num);
		t.val(parseInt(t.val()) - 1);
		if (parseInt(t.val()) == 1) {
			$('#min').attr('disabled', true);
		}
	})
	t.blur(function(){
        var zerot = t.val();
        if(zerot!=0){
			mo.html(price*zerot);
		}
    });
    t.focus(function(){
        price=mo.html()/t.val();
    });
})