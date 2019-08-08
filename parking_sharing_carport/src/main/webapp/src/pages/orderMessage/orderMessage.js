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
	
//初始化控件
    //查询数据
	var id = getQueryVariable("id");
    var url = "/carport/findOrderByid"
    axios.get(url,{
			params:{
					id:id
				}
			}).then(function(response) {
		 var uiStepbar = bui.stepbar({
		        id: "#step",
		        data: [{
		            title: "待确认",
		        },{
		            title: "进行中",
		        },{
		            title: "完成",
		        }],
		        direction: "x",
		        click: false,
		        lineCenter: true,
		        hasNumber: true
		    });
	   	 vm.message= response.data;
	   	 vm.user = response.data.userBean;
	   	 vm.status = response.data.o_status
	   	 vm.carportBean = response.data.rentalBean.carportBean;
	   	 console.info(vm.carportBean);
	   	vm.message.o_createtime = moment(vm.message.o_createtime).format('YYYY-MM-DD HH:mm');
	   	vm.message.o_etime = moment(vm.message.o_etime).format('YYYY-MM-DD HH:mm');
	   	vm.message.o_stime = moment(vm.message.o_stime).format('YYYY-MM-DD HH:mm');
	   	//激活
	     uiStepbar.value(vm.status);
    })


	//vue绑定数据
	var vm=new Vue({
			el:"#bui-page",
			data:{
				message:[],
				user:{},
				status:0,
				carportBean:{}
			},
			mounted:function(){
				// 绑定按钮跳转
			    $("#charge").on("click",function(){
			      router.load({ url: "pages/charge/charge.html", param: {orderid:vm.message.o_id,btid:vm.carportBean.owner.u_id} });
			    })
			}
			
		})
   
    
   
    

})
