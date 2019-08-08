//正则法获取参数
function getQueryVariable(variable) {
	var query = window.location.hash;
	var query1 = query.split("?");
	var vars = query1[1].split("&");
	for (var i = 0; i < vars.length; i++) {
		var pair = vars[i].split("=");
		if (pair[0] == variable) {
			return pair[1];
		}
	}
	return (false);
}
var sstime;
var eetime;
loader.define(function() {
	
	
	
	var id = getQueryVariable("id");
	//vue绑定数据
	var vm = new Vue({
		el : "#cpxiangqing",
		data : {
			list:[],
			rentalBean : {},
			carportBean : {},
			status : {}
		},
		created : function() {
			let
			$this = this;
			//查询数据
			var url = "/carport/findByCpId/" + id;
			axios.get(url).then(
					function(response) {
						var arr = response.data.list;
						for(var i=0;i<arr.length;i++){
							arr[i].o_stime = moment(arr[i].o_stime).format('YYYY-MM-DD HH:mm');
							arr[i].o_etime = moment(arr[i].o_etime).format('YYYY-MM-DD HH:mm');
						}
						vm.list = arr;
						console.info(arr);
						vm.rentalBean = response.data.rentalBean;
						vm.carportBean = response.data.carportBean;
						vm.status = response.data.status;
						var stime;
						var etime;
						if (vm.rentalBean != null) {
							stime = moment(vm.rentalBean.r_stime).format(
									'YYYY-MM-DD HH:mm:ss');
							etime = moment(vm.rentalBean.r_etime).format(
									'YYYY-MM-DD HH:mm:ss');
						}
						$this.$nextTick(function() {
							
							// 定义结束日期
							var input2 = $("#etimepicker");
							var uiPickerdate2 = bui.pickerdate({
								handle : "#etimepicker",
								// input 显示的日期格式
								formatValue : "yyyy-MM-dd hh:mm",
								onChange : function(value2) {
									input2.val(value2);
									eetime = value2;
								}
							});

							// 日期按钮
							var input1 = $("#stimepicker");
							var uiPickerdate = bui.pickerdate({
								handle : "#stimepicker",
								// 显示的日期格式
								formatValue : "yyyy-MM-dd hh:mm",
								onChange : function(value1) {
									input1.val(value1);
									sstime = value1;
								},
								callback : function(e) {
									uiPickerdate2.value(input1.val());
									uiPickerdate2.min(input1.val());
								}
							});

							// 底部出来对话框
							var uiDialogDown = bui.dialog({
								id : "#dialogDown",
								effect : "fadeInUp",
								position : "bottom",
								fullscreen : false,
								buttons : []
							});
							//回显时间
							uiPickerdate.value(stime);
							uiPickerdate2.value(etime);
							$('#btnOpenDown').on("click", function() {
								uiDialogDown.open();
							});
							
						});
					})
		},
		methods:{
			fabuClick:function(){
				var price = $("#fabuprice").val();
				axios.get("/carport/insertRental",{
					params:{
						start:sstime,
						end:eetime,
						cpid:id,
						price:price
					}
				}).then(function(response){
					 router.load({ url: "pages/order/pay/pay.html", param: {} });
				})
			},
			cancelClick: function(){
				axios.get("/carport/updateRental",{
					params:{
						id:id
					}
				}).then(function(){
					 router.load({ url: "pages/order/pay/pay.html", param: {} });

				})
			},
			handle: function (e) {
                // this 为滑动出来的操作按钮
				var a =e.target.parentElement.parentElement;
				var status = e.target.getAttribute("had");
				var oid = e.target.getAttribute("oid");
				console.info(oid);
                //var orderId = 
                    //执行删除操作
                $(a).fadeOut(400,function () {
                	
                	axios.get("/carport/updateOrder",{
    					params:{
    						orderId:oid,
    						status:status
    					}
    				});
                	
                	vm.list.length -= 1;
                	if(vm.list.length!=0){
                		$("#bui-badges").text(vm.list.length);
                	}else{
                		$("#bui-badges").remove();
                	}
                });
            }
		}
	})
})
