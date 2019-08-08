
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
	
   
loader.define(function(){
	 
		//查询数据
		var id = getQueryVariable("id");
	    var url = "/carport/findById/"+id
	    axios.get(url).then(function(response) {
		   	 vm.message= response.data;
		   	 console.info(vm.message);
	    })
	    axios.get("/carport/findXinyu",{
	    	params:{
	    		rentalid:id
	    }}).then(function(response) {
		   	 vm.xinyu= response.data;
		   	 console.info(vm.xinyu);
	    })
	 //vue绑定数据
	    var vm=new Vue({
	 		el:"#xiangqing",
	 		data:{
	 			message:[],
	 			xinyu:{}
	 		}
	 		
	 	})
    
   
})
  // 绑定按钮跳转
function wrc(){
	var id = getQueryVariable("id");
	router.load({ url: "pages/stall/reserve/reserve.html", param: {id:id} });
}
