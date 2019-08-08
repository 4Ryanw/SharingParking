var starttime;
var endtime;

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


loader.define(function() {
	//vue绑定
	var vm=new Vue({
	 		el:"#yuding",
	 		data:{
				message:[],
				input:''
			},
			methods:{
				reserveClick:function(){
					var  price =$("#totalprice").html();
					var words = $("#words").val();
					axios.get("/carport/insertOrder",{
						params:{
							start: starttime,
							end:endtime,
							id:id,
							day:vm.input,
							price:price,
							words:words
						}
					}).then(function(response){
						 router.load({ url: "pages/order/pay/pay.html", param: {} });
					})
				}
			}	
	})
	var id = getQueryVariable("id");
	//查询租车价格
	axios.get("/carport/findById/"+id).then(function(response){
		vm.message=response.data;
		console.info(vm.message)
	})
	
	//获取禁用时间
	var bantime;
	axios.get("/carport/findBanTime/"+id).then(function(response){
		var maxtime = moment(response.data.max);
	 	var mintime = moment(response.data.min);
		bantime = response.data.listtime;
		bantime.forEach(function(item,index){
			item.start=moment(item.start);
			item.end=moment(item.end);
		})
		$('input[name="datetimes"]').daterangepicker({
		    timePicker: true,
		    maxDate:maxtime,
		    minDate:mintime,
		    startDate: moment().startOf('hour'),
		    endDate: moment().startOf('hour').add(1, 'hour'),
		    opens: "left",
		    isInvalidDate: function(date) {
		                    var dateRanges =bantime ;
		                    return dateRanges.reduce(function(bool, range) {
		                            return bool || (date >= range.start && date <= range.end);
		                    }, false);
		        },
		    locale: {
		        applyLabel: '确定',
		        format: ' YYYY/M/D',
		        cancelLabel: '取消',
		        fromLabel: '起始时间',
		        toLabel: '结束时间',
		        separator : ' 至' ,
		        daysOfWeek: ['日', '一', '二', '三', '四', '五', '六'],
		        monthNames: ['一月', '二月', '三月', '四月', '五月', '六月','七月', '八月', '九月', '十月', '十一月', '十二月'],
		        firstDay: 1
		    }
		  }, function(start,end,label){
		      vm.input = (parseInt((end-start)/(1000*3600*24))+1);
		      starttime = start;
		      endtime = end;
		  });
		  
	})
  
});
