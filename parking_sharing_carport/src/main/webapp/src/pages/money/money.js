loader.define(function() {

	axios.get("/carport/findUser").then(function(response) {
		vm.money=response.data.u_money 
		
	});
	var vm = new Vue({
		el : "#bui-page",
		data : {
			money :0.0
		}
	})
})