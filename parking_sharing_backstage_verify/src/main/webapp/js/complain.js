var tableVue = new Vue({
	el: "#complainTable",
	data: {
		authority:0, // 权限
		complainList: [],
		status:0,
		page:1,
		size:12,
		complainNumber:0,
		pageNumber:0
	},
	methods:{
		prevPage:function(){
			if(this.page > 1){
				this.page -= 1;
				axios.get("/complain/status/"+this.status+"/page/"+this.page+"/size/"+this.size).then(response => {
					console.log(response.data);
					this.complainList = response.data;
				}).catch(function (err) {
					console.log(err);
				});
			};
		},
		nextPage:function(){
			if(this.page < this.pageNumber){
				this.page += 1;
				axios.get("/complain/status/"+this.status+"/page/"+this.page+"/size/"+this.size).then(response => {
					//console.log(response.data);
					this.complainList = response.data;
				}).catch(function (err) {
					console.log(err);
				});
			}
		}
	},
	created() {
		//获取权限数据
		axios.get("/complain/getAuthority").then(response => {
			console.log(response.data);
			this.authority = response.data.a_coa;
		}).catch(function (error) {
			console.log(error);
		});
		
		axios.get("/complain/status/"+this.status+"/page/"+this.page+"/size/"+this.size).then(response => {
				//console.log(response.data);
				this.complainList = response.data;
			}).catch(function (error) {
				console.log(error);
			});
		

		
		axios.get("/complain/count/0").then(response => {
			//console.log(response.data);
			this.complainNumber = response.data;
			this.pageNumber = Math.ceil(this.complainNumber / this.size);
		}).catch(function (error) {
			console.log(error);
		});
	}
});
