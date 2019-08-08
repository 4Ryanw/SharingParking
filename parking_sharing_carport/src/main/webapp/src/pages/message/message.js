loader.define(function(){
	 axios.get("/carport/findMessage").then(function(response){
		 vm.list = response.data;
	 })
    	//vue绑定数据
	var vm=new Vue({
			el:"#bui-page",
			data:{
				list:[]
			},
			mounted:function(){
			}
		})
	
    //定时器
	 setTimeout(function() {
		    //实例初始化
			 var uiListview = bui.listview({
				 id: "#listview",
				 data: [{ "text": "置顶", "classname":"primary"},{ "text": "删除", "classname":"danger"}],
				 position:"right",   //默认就是右边,所以可以不用传
				 callback: function (e) {
					 // this 为滑动出来的操作按钮
					 var $this = $(e.target);
					 var text = $this.text();
					 var a =e.target.parentElement.parentElement
					 if( text == '删除' ){
						 bui.confirm("确定要删除吗",function (e) {
							 //this 是指点击的按钮
							 var text2 = $(e.target).text();
							 if( text2 == "确定"){
								 var mid = a.getAttribute("mid");
								 axios.get("/carport/deleteMessage",{
									 params:{
										 id:mid
									 }
								 })
								 // 执行删除整行操作
								 $(a).fadeOut(300,function () {
									 $(this).remove();
								 });
							 }
						 })
					 }
					 // 不管做什么操作,先关闭按钮,不然会导致第一次点击无效.
					 this.close();
				 }
			 });
		  },100)
})
