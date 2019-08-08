loader.define(function(){

    var pageview = {};


    pageview.init = function () {

        var uiSlide = bui.slide({
            id:"#slide",
            height:360,
            autopage: true,
            data: [{
              image: "http://www.easybui.com/demo/images/banner01.png"
            },{
              image: "http://www.easybui.com/demo/images/banner02.png"
            },{
              image: "http://www.easybui.com/demo/images/banner03.png"
            }]
            // autoplay:true
        });
        var uiDoropdown = bui.dropdown({
            id: "#uiDoropdownArea",
            data: [{
                name: "广州",
                value: "gz"
            }, {
                name: "深圳",
                value: "gd"
            }],
            showArrow: true,
            relative: false,
            value: "广东",
            callback: function(e) {
            }
        })

    }

    // 初始化
    pageview.init();

    // 输出模块
    return pageview;
})
