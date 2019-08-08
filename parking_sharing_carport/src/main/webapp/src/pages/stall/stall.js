function detail(obj){
	var rid = $(obj).attr("rid");
	router.load({ url: "pages/stall/detail/detail.html", param: {id:rid} });
}

//绑定按钮跳转
$("#bdumap").on("click",function(){
	router.load({ url: "pages/map/map.html", param: {} });
})
loader.define(function(){
	

    //静态渲染, 选中激活在列表的active样式
    var uiDoropdown2 = bui.dropdown({
        id: "#uiDoropdownClass",
        //设置relative为false,二级菜单继承父层宽度
        relative: false,
        value: "",
        callback: function(e) {

        }
    })
    
    
   /*  // 绑定按钮跳转
    $("#detail").on("click",function(){
      
    })*/

    
    //查询数据
    var url = "/carport/findAll/"
    axios.get(url).then(function(response) {
	   	 vm.message= response.data;
    })


	//vue绑定数据
	var vm=new Vue({
			el:"#stall2",
			data:{
				message:[]
			}
			
		})
})


