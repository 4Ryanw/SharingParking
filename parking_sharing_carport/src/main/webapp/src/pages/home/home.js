function detail(obj){
	var rid = $(obj).attr("rid");
	router.load({ url: "pages/stall/detail/detail.html", param: {id:rid} });
}

bui.ready(function() {
          // 焦点图控件初始化
            var uiSlide = bui.slide({
                id: "#uiSlide",
                height: 380,
                autoplay:true,
                autopage: true,
                data: [{
                  image: "images/banner01.png",
                  url: "pages/ui_controls/bui.slide_title.html",
                },{
                  image: "images/banner02.png",
                  url: "pages/ui_controls/bui.slide_title.html",
                },{
                  image: "images/banner03.png",
                  url: "pages/ui_controls/bui.slide_title.html",
                },{
                  image: "images/banner04.png",
                  url: "pages/ui_controls/bui.slide_title.html",
                }]
            })
            // 监听跳转以后触发
            uiSlide.on("to",function(index){
            })
            // 跳转到第2个,索引值从0开始
            // uiSlide.to(1);
            
            loader.define(function(){
            
            //动态渲染
    var uiDoropdown = bui.dropdown({
        id: "#uiDoropdownArea",
        data: [{
            name: "广州",
            value: "gz"
        }, {
            name: "广东",
            value: "gd"
        }],
        //设置relative为false,二级菜单继承父层宽度
        relative: false,
        value: "广东",
        callback: function(e) {
        }
    })
    
    //点击的搜索条
    var uiList;
    var uiDialog = bui.dialog({
        id: "#uiDialog",
        fullscreen: true,
        mask: false,
        effect: "fadeInLeft"
    });
    
    // var n = 0;
    //搜索条的初始化
    var uiSearchbar = bui.searchbar({
        id:"#searchbar",
        onInput: function(ui,keyword) {
            //实时搜索
            // console.log(++n)
        },
        onRemove: function(ui,keyword) {
            //删除关键词需要做什么其它处理
            // console.log(keyword);
        },
        callback: function (ui,keyword) {
            if( uiList ){
                //点击搜索清空数据
                uiList.empty();
                // 重新初始化数据
                uiList.init({
                    page: 1,
                    data: {
                        "keyword":keyword
                    },
                    onRefresh: onRefresh,
                    onLoad: onLoad
                });
            }else{
                // 列表初始化
                uiList = bui.list({
                    id: "#scrollSearch",
                    url: "http://www.easybui.com/demo/json/shop.json",
                    field: {
                        data:"data"
                    },
                    data: {
                        "keyword":keyword
                    },
                    page:1,
                    pageSize:5,
                    onRefresh: onRefresh,
                    onLoad: onLoad,
                    template: function (data) {
                            var html = "";
                            data.map(function(el, index) {

                                // 处理角标状态
                                var sub = '' , subClass = '' ;
                                switch(el.status){
                                    case 1:
                                    sub = '新品';
                                    subClass = 'bui-sub';
                                    break;
                                    case 2:
                                    sub = '热门';
                                    subClass = 'bui-sub danger';
                                    break;
                                    default: 
                                    sub = '';
                                    subClass = '';
                                    break;
                                }
                                html +=`<li class="bui-btn bui-box">
                                    <div class="bui-thumbnail ${subClass}" data-sub="${sub}"><img src="${el.image}" alt=""></div>
                                    <div class="span1">
                                        <h3 class="item-title">${el.name}</h3>
                                        <p class="item-text">${el.address}</p>
                                        <p class="item-text">${el.distance}公里</p>
                                    </div>
                                    <span class="price"><i>￥</i>${el.price}</span>
                                </li>`
                            });
                            return html;
                    },
                    callback: function(argument) {
                        console.log($(this).text()
                        )
                    }
                });
            }
           
            // 下拉刷新
            function onRefresh() {
            }
            // 上拉加载
            function onLoad() {
            }
        }
    });
    $("#btnSearchDialog").on("click",function (argument) {
        uiDialog.open();
    })
    $("#btnBack").on("click",function (argument) {
        uiDialog.close();
    })
    $("#btnSearch").on("click",function (argument) {
        uiSearchbar.search();
    })
})
        })