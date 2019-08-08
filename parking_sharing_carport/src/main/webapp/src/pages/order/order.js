function om(obj){
	var oid = $(obj).attr("oid");
	router.load({ url: "pages/orderMessage/orderMessage.html", param: {id:oid} });
}

loader.define(function(){
	//超时判断
	axios.get("/carport/updateoutoftime");
   
	
	//查询数据
    var url = "/carport/finduserOrder"
    axios.get(url).then(function(response) {
	   	 vm.message= response.data;
    })


	//vue绑定数据
	var vm=new Vue({
			el:"#dingdan",
			data:{
				message:[]
			}
			
		})
    
})


