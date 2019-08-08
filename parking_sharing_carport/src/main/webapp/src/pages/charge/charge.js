/**
 * 发布评论模块
 * 默认模块名: pages/comment/comment
 * @return {[object]}  [ 返回一个对象 ]
 */
//正则法获取参数
	function getQueryVariable(variable)
	{
	       var query = window.location.hash;
	       var query1 = query.split("?");
	       var vars = query1[1].split("&");
	       for (var i=0;i<vars.length;i++) {
	               var pair = vars[i].split("=");
	               if(pair[0] == variable){return pair[1];}
	       }
	       return(false);
	}
	
	

	var chargeClick = function(){
		var orderid = getQueryVariable("orderid");
		var btid = getQueryVariable("btid");
		var content= $("#content").val();
		axios.get("/carport/insertcharge",{
			params:{
				orderid:orderid,
				btid:btid,
				content:content
			}
		}).then(function(response){
			router.load({ url: "pages/add/success/success.html", param: {} });
		});
	}
	
	
loader.define(function(){
    var pageview = {};
    // 模块初始化定义
    pageview.init = function() {
        // 长度限制
        var comment = bui.input({
            id: "#feedback",
            target: "textarea",
            showIcon: false,
            maxLength: 500,
            showLength: true
        })
        // 上传初始化
        this.upload();
    };
    
    

    // 上传
    pageview.upload = function() {
        // 拍照上传
        var photos = $("#buiPhoto");
        var uiUpload = bui.upload();


        // 上拉菜单 js 初始化:
        var uiActionsheet = bui.actionsheet({
            trigger: "#btnUpload",
            buttons: [{ name: "拍照上传", value: "camera" }, { name: "从相册选取", value: "photo" }],
            callback: function(e) {
                var ui = this;
                var val = $(e.target).attr("value");
                switch (val) {
                    case "camera":
                        ui.hide();
                        uiUpload.add({
                            "from": "camera",
                            "onSuccess": function(val, data) {
                                // 展示本地图片
                                this.toBase64({
                                    onSuccess: function(url) {
                                        photos.prepend(templatePhoto(url))

                                    }
                                });

                                // 也可以直接调用start上传图片
                            }
                        })

                        break;
                    case "photo":
                        ui.hide();
                        uiUpload.add({
                            "from": "",
                            "onSuccess": function(val, data) {
                                // 展示本地图片
                                this.toBase64({
                                    onSuccess: function(url) {
                                        photos.prepend(templatePhoto(url))
                                    }
                                });
                                // 也可以直接调用start上传图片
                            }
                        })

                        break;
                    case "cancel":
                        ui.hide();
                        break;
                }
            }
        })

        function templatePhoto(url) {
            return `<div class="span1">
                    <div class="bui-upload-thumbnail"><img src="${url}" alt="" /></div>
                </div>`
        }

    }

    // 初始化
    pageview.init();

    // 输出模块
    return pageview;
})
