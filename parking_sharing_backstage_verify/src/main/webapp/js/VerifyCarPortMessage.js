var carPortId = window.location.href.split("=")[1];
var vueApp = new Vue({
	el:"#vueApp",
	data:{
		authority:0, // 权限
		carPort:{}
	},
	methods:{
		/* 更新车位审核状态 */
		updateStatus:function(status){
			var result = document.getElementById("resultMessage").value;
			if(result == "") {
				alert("请输入处理意见！"); 
				return;
			}
			var formData=new FormData();
			formData.append('id',this.carPort.id);
			formData.append('status',status);
			axios.put("/carport/update/",formData).then(
				response => {
					console.log("Result Test: " + response.data)
					// if(response.data > 0) this.carPort.status = status;
					window.location.href = "/page/VerifyCarPort.html";
				}
			).catch(function(error){
				console.log(error); 
			});
		}
	},
	created(){
		//获取权限数据
		axios.get("/complain/getAuthority").then(response => {
			console.log(response.data);
			this.authority = response.data.a_cpa;
		}).catch(function (error) {
			console.log(error);
		});
		
		
		/* 获取车位和业主数据 */
		axios.get("/carport/" + carPortId).then(
			response => {
				console.log(response.data)
				this.carPort = response.data;
			}
		).catch(function(error){
			console.log(error);
		});
	}
})

// 查看大图
window.onload = function() {
	$(".imgs").on("click", function() {
		var str = $(this).attr("src")
		$("#meng").css("display", "block");
		$("#img").attr("src", str);

	});
	$(".close").click(function() {
		$("#meng").css("display", "none");
		$("#img").css({
			// height: "300px",
			width: "800px",
			top: 0,
			left: 0
		});
	});
	
	// 图片放大缩小事件
	var scrollFunc = function(e) {
		var Oimg = document.getElementById("img");
		e = e || window.event || document.event;
		if (e.wheelDelta) { // 判断浏览器IE，谷歌滑轮事件
			if (e.wheelDelta > 0) { // 当滑轮向上滚动时
				var hei = Oimg.height;
				var wid = Oimg.width;
				$("#img").css({
					height: hei + 100 + "px",
					width: wid + 100 + "px"
				})
			}
			if (e.wheelDelta < 0) { // 当滑轮向下滚动时
				var hei = Oimg.height;
				var wid = Oimg.width;
				$("#img").css({
					height: hei - 100 + "px",
					width: wid - 100 + "px"
				})
			}
		} else if (e.detail) { // Firefox滑轮事件
			if (e.detail > 0) { // 当滑轮向滚动时
				var hei = Oimg.height;
				var wid = Oimg.width;
				$("#img").css({
					height: hei - 100 + "px",
					width: wid - 100 + "px"
				})
			}
			if (e.detail < 0) { // 当滑轮向上滚动时
				var hei = Oimg.height;
				var wid = Oimg.width;
				$("#img").css({
					height: hei + 100 + "px",
					width: wid + 100 + "px"
				})
			}
		}
	}

	// 给页面绑定滑轮滚动事件
	var Oimg = document.getElementById("img");
	if (Oimg.addEventListener) { // firefox
		Oimg.addEventListener('DOMMouseScroll', scrollFunc, false);
	} // 滚动滑轮触发scrollFunc方法 //ie 谷歌
	Oimg.onmousewheel = Oimg.onmousewheel = scrollFunc; //

	// 图片拖拽
	var imgobx = document.getElementsByClassName("img-box");
	var disX = 0;
	var disY = 0;

	Oimg.onmousedown = function(ev) {
		var oEvent = ev || event;

		disX = oEvent.clientX - Oimg.offsetLeft;
		disY = oEvent.clientY - Oimg.offsetTop;

		document.onmousemove = function(ev) {
			var oEvent = ev || event;
			var l = oEvent.clientX - disX;
			var t = oEvent.clientY - disY;
			if (l > imgobx.offsetWidth - Oimg.offsetWidth) {
				l = imgobx.offsetWidth - Oimg.offsetWidth;
			}
			if (t > imgobx.offsetHeight - Oimg.offsetHeight) {
				t = imgobx.offsetHeight - Oimg.offsetHeight;
			}

			Oimg.style.left = l + 'px';
			Oimg.style.top = t + 'px';
		};
		document.onmouseup = function() {
			document.onmousemove = null;
			document.onmouseup = null;
		};
		return false;
	}
};