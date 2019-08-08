
function cpdetail(obj){
	var cpid = $(obj).attr("cpid");
	router.load({ url: "pages/cpdetail/cpdetail.html", param: {id:cpid} });
} 



loader.define(function(require,exports,module){
	 
    //查询数据
    var url = "/carport/findMycp"
    axios.get(url).then(function(response) {
	   	 vm.message= response.data;
	   	 console.info(vm.message)
    })


	//vue绑定数据
	var vm=new Vue({
			el:"#bui-page",
			data:{
				message:[]
			}
			
		})

 // 绑定按钮跳转
    
     $("#tianjia").on("click",function(){
      router.load({ url: "pages/add/add.html", param: {} });
    })
   
})