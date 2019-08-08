
loader.define(function(require,exports,module){
	
 	axios.get("/carport/findUser").then(function(response) {
	vm.user=response.data
	console.info(vm.user)
	 // 绑定按钮跳转
    $("#record").on("click",function(){
      router.load({ url: "pages/order/order.html", param: {} });
    })
     $("#chewei").on("click",function(){
      router.load({ url: "pages/personl/mycarport/mycarport.html", param: {} });
    })
    $("#personMes").on("click",function(){
    	window.location="http://127.0.0.1:9001/html/personal.html";
    })
     $("#money").on("click",function(){
      router.load({ url: "pages/money/money.html", param: {} });
    })
	});
	var vm = new Vue({
		el : "#personpage",
		data : {
			user :{}
		}
	})

})

	
	
	