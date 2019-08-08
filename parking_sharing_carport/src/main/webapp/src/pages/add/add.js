 loader.define(function(){
	 
	 	var vm = new Vue({
	 		el:"#zccw",
	 		methods:{
	 			zccwClick:function(){
	 				/*var shen = $("#shen").text();
	 				var shi = $("#shi").text();
	 				var qu =$("#qu").text();*/
	 				var describe = $("#describe").val();
	 				var address= $("#address").text();
	 				var community = $("#community").val();
	 				var number = $("#number").val();
	 				var certifacateNumber = $("#certifacateNumber").val();
	 				axios.get("/carport/insertcarport",{
	 					params:{
	 						describe:describe,
	 						address: address,
	 						community:community,
	 						number:number,
	 						certifacateNumber:certifacateNumber
	 					}
	 				}).then(function(response){
	 					router.load({ url: "pages/add/success/success.html", param: {} });
	 				})
	 			}
	 		}
	 	})
	 	
	 	
		/*//vue绑定
	 	var vm=new Vue({
	 		el:"#zccw",
	 		methods:{
	 			zccwClick:function(){
	 				var  address =$("#address").html();
	 				var community = $("#community").val();
	 				var number = $("#number").val();
	 				var certifacateNumber = $("#certifacateNumber").val();
	 				//var certifacate = $("certifacate").val;
	 				axios.get("/carport/addcarport/1",{
	 					params:{
	 						address: address,
	 						community:community,
	 						number:number,
	 						certifacateNumber:certifacateNumber
	 					}
	 				}).then(function(response){
	 					alert(response); 
	 					//router.load({ url: "pages/order/pay/pay.html", param: {} });
	 				})
	 			}
	 		}	
	 		})
*/

	 	//小区
     var userInput = bui.input({
         id: ".user-input",
         callback: function(e) {
             // 清空数据
             this.empty();
         }
     })

     //车位号
     var password = bui.input({
             id: "#passwordInput",
             onBlur: function(e) {
                 if (e.target.value == '') { return false; }
                 // 注册的时候校验只能4-18位密码
                 var rule = /^[a-zA-Z0-9]{4,10}$/;
                 if (!rule.test(e.target.value)) {
                     bui.hint("车位编号只能由4-10位字母或者数字组成");
                     return false;
                 }
                 return true;
             },
             callback: function(e) {
            	 this.empty();
             }
         })
    
     var citySelect = null;
     // 绑定数据
     loader.import("http://www.easybui.com/demo/js/plugins/citys.js", function() {

         // 普通初始化
         citySelect = bui.levelselect({
             data: citys,
             title: "所在地区",
             log: true,
             trigger: ".selected-val",
             level: 3,
             field: {
                 name: "n",
                 data: ["c", "a"],
             }
         })

     })

     
     $("#chooseCity").on("click", function() {
         citySelect.show();
     })


      // 评论字数
     var comment = bui.input({
         id: "#commentContent",
         showLength: true,
         showIcon: false,
         maxLength: 20
     })



     // 拍照上传
     var $facePhoto = $("#facePhoto");
     var uiUpload = bui.upload();

     $(".bui-upload .bui-btn").on("click", function() {
         uiUpload.add({
             "from": "camera",
             "onSuccess": function(val, data) {
                 // $output.text(val);
                 // 展示本地图片
                 this.toBase64({
                     onSuccess: function(url) {
                         $facePhoto.prepend(templatePhoto(url))
                     }
                 });

                 // 也可以直接调用start上传图片
             }
         })

     })

     function templatePhoto(url) {
         return "<div class='span1'><div class='bui-upload-thumbnail'><img src='${url}'  /></div></div>"
     }

 })
