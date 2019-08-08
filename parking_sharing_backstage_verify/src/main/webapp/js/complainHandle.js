var complainId = window.location.search.split("=")[1];

function getUrlData() {
    console.log("全路径 :" + this.location.href);
    console.log("参数：" + this.location.search);
    console.log("协议：" + this.location.protocol);
    console.log("IP和端口：" + this.location.host);
    console.log("IP：" + this.location.hostname);
    console.log("端口：" + this.location.port);
    console.log("路径部分：" + this.location.pathname);
}

// getUrlData();

var vueApp = new Vue({
    el: ".vueApp",
    data: {
    	authority:{}, // 权限
        complainBean: {},
        orderBean: {},
        carPortBean:{},
        tuUser:{},
        btuUser:{}
    },
    methods: {
        updateStatus: function (status) {
			let result = document.getElementById("complainResult").value;
            if (result == "") {
                alert("请输入处理意见！");
                return;
            }
			let formData = new FormData();
            formData.append("id", this.complainBean.id);
            formData.append("status", status);
            formData.append("result", result);
            axios.put("/complain/update", formData).then(
                response => {
                    // console.log("Result Test: " + response.data)
                    window.location.href = "/page/complain.html";
                }
            ).catch(function (error) {
                console.log(error);
            });
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
    	
        axios.get("/complain/" + complainId).then(response => {
            console.log(response.data)
            this.complainBean = response.data;
            this.tuUser = response.data.tuUser;
            this.btuUser = response.data.btuUser;
        }).then(() => {
            return axios.get("/order/" + this.complainBean.orderId);
        }).then(response => {
            console.log(response.data)
            this.orderBean = response.data;
            this.carPortBean = response.data.carPortBean;
        }).catch(function (error) {
            console.log(error);
        });
    }
})

//查看大图
window.onload = function () {
    $(".imgs").on("click", function () {
		let str = $(this).attr("src")
        $("#meng").css("display", "block");
        $("#img").attr("src", str);

    });
    $(".close").click(function () {
        $("#meng").css("display", "none");
        $("#img").css({
            height: "100%",
            width: "100%",
            top: 0,
            left: 0
        });
    });

    //	图片放大缩小事件
    var scrollFunc = function (e) {
		let Oimg = document.getElementById("img");
        e = e || window.event || document.event;
        if (e.wheelDelta) { //判断浏览器IE，谷歌滑轮事件
            if (e.wheelDelta > 0) { //当滑轮向上滚动时
				let hei = Oimg.height;
				let wid = Oimg.width;
                $("#img").css({
                    height: hei + 100 + "px",
                    width: wid + 100 + "px"
                })
            }
            if (e.wheelDelta < 0) { //当滑轮向下滚动时
                var hei = Oimg.height;
                var wid = Oimg.width;
                $("#img").css({
                    height: hei - 100 + "px",
                    width: wid - 100 + "px"
                })
            }
        } else if (e.detail) { //Firefox滑轮事件
            if (e.detail > 0) { //当滑轮向滚动时
				let hei = Oimg.height;
				let wid = Oimg.width;
                $("#img").css({
                    height: hei - 100 + "px",
                    width: wid - 100 + "px"
                })
            }
            if (e.detail < 0) { //当滑轮向上滚动时
				let hei = Oimg.height;
				let wid = Oimg.width;
                $("#img").css({
                    height: hei + 100 + "px",
                    width: wid + 100 + "px"
                })
            }
        }
    }

    //给页面绑定滑轮滚动事件
    var Oimg = document.getElementById("img");
    if (Oimg.addEventListener) { //firefox
        Oimg.addEventListener('DOMMouseScroll', scrollFunc, false);
    } //滚动滑轮触发scrollFunc方法  //ie 谷歌
    Oimg.onmousewheel = Oimg.onmousewheel = scrollFunc; //

    //图片拖拽
    var imgobx = document.getElementsByClassName("img-box");
    var disX = 0;
    var disY = 0;

    Oimg.onmousedown = function (ev) {
        var oEvent = ev || event;

        disX = oEvent.clientX - Oimg.offsetLeft;
        disY = oEvent.clientY - Oimg.offsetTop;

        document.onmousemove = function (ev) {
            let oEvent = ev || event;
			let l = oEvent.clientX - disX;
			let t = oEvent.clientY - disY;
            if (l > imgobx.offsetWidth - Oimg.offsetWidth) {
                l = imgobx.offsetWidth - Oimg.offsetWidth;
            }
            if (t > imgobx.offsetHeight - Oimg.offsetHeight) {
                t = imgobx.offsetHeight - Oimg.offsetHeight;
            }

            Oimg.style.left = l + 'px';
            Oimg.style.top = t + 'px';
        };
        document.onmouseup = function () {
            document.onmousemove = null;
            document.onmouseup = null;
        };
        return false;
    }
};