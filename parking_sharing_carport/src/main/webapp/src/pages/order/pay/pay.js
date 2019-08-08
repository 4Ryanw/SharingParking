
loader.define(function(){
	 // 绑定按钮跳转
    $("#homepage").on("click",function(){
    	router.back({
    		name:"main",
    		 callback: function(module){
    			  }
    	});
    })
})


