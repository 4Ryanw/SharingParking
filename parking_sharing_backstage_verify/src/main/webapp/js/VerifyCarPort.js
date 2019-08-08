var tableVue = new Vue({
	el: "#verifyTable",
	data: {
		authority:[], // 权限
		carPortList: [],
		status:0,
		page:1,
		size:8,
		carPortNumber:0,
		pageNumber:0
	},
	methods:{
		prevPage:function(){
			if(this.page > 1){
				this.page -= 1;
				axios.get("/carport/status/"+this.status+"/page/"+this.page+"/size/"+this.size).then(response => {
					console.log(response.data);
					this.carPortList = response.data;
				}).catch(function (err) {
					console.log(err);
				});
			};
		},
		nextPage:function(){
			if(this.page < this.pageNumber){
				this.page += 1;
				axios.get("/carport/status/"+this.status+"/page/"+this.page+"/size/"+this.size).then(response => {
					console.log(response.data);
					this.carPortList = response.data;
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
			this.authority = response.data;
		}).catch(function (error) {
			console.log(error);
		});
		
		axios.get("/carport/status/"+this.status+"/page/"+this.page+"/size/"+this.size).then(response => {
				console.log(response.data);
				this.carPortList = response.data;
			}).catch(function (err) {
				console.log(err);
			});
		
		axios.get("/carport/count/0").then(response => {
			console.log(response.data);
			this.carPortNumber = response.data;
			this.pageNumber = Math.ceil(this.carPortNumber / this.size);
		}).catch(function (err) {
			console.log(err);
		});
	}
});
