$(function () {
    var cartLeft = $('#ECS_CARTINFO').offset().left - $(document).scrollLeft();
    var cartTop = $('#ECS_CARTINFO').offset().top;
    $("a.show_cart").click(function (event) {
        var productId = $(this).data("productid");
        $.get("/product_addCart.do", {productId:productId,amount:1});
        var addcar = $(this);
        var img = addcar.parent().find('img').attr('src');
        var flyer = $('<img class="u-flyer" src="' + img + '">');
        flyer.fly({
            start: {
                left: event.pageX,
                top: event.pageY
            },
            end: {
                left: cartLeft,
                top: cartTop,
                width: 0,
                height: 0
            },
            onEnd: function () {
                $("#msg").show().animate({width: '250px'}, 600).fadeOut(2000);
                this.destory();
                $("#ECS_CARTINFO").html(parseInt($("#ECS_CARTINFO").html()) + 1);
            }
        });
    });

});