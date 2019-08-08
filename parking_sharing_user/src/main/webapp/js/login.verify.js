$("#u10_text").click(function(){
	var u_username = $("#u9_input").val();
	var u_password = $("#u6_input").val();
	var code = $("#u2_input").val();
	var code2 = $("#checkCode").html();
	
	function go(){ 
		window.location.href="http://localhost:8020/src/index.html";
	} 
	//判断用户名是否为空	
	if (u_username=="") {
		var nullPhone = $("#u16_state2").attr("style","visibility: visible");
		var tusi = $("#u16").attr("style","visibility: visible;");
		var tusi2 = $("#u16").attr("class","animated fadeIn");
		setTimeout("$('#u16').attr('class','animated fadeOut')",2000);
		setTimeout("$('#u16').attr('style','display:none')",3000);
		setTimeout("$('#u16_state2').attr('style','visibility: hidden')",3000);
	}
	//判断密码格式
	else if (u_password.length<6||u_password.length>20) {
		var nullPhone = $("#u16_state3").attr("style","visibility: visible");
		var tusi = $("#u16").attr("style","visibility: visible;");
		var tusi2 = $("#u16").attr("class","animated fadeIn");
		setTimeout("$('#u16').attr('class','animated fadeOut')",2000);
		setTimeout("$('#u16').attr('style','display:none')",3000);
		setTimeout("$('#u16_state3').attr('style','visibility: hidden')",3000);
	}
	//判断验证码是否错误
	else if (code!=code2) {
		var nullPhone = $("#u16_state1").attr("style","visibility: visible");
		var tusi = $("#u16").attr("style","visibility: visible;");
		var tusi2 = $("#u16").attr("class","animated fadeIn");
		setTimeout("$('#u16').attr('class','animated fadeOut')",2000);
		setTimeout("$('#u16').attr('style','display:none')",3000);
		setTimeout("$('#u16_state1').attr('style','visibility: hidden')",3000);
	}
	else {
		$.ajax({
		    type: "post",
		    url: "/user/login",
		    data:"username="+u_username+"&password="+u_password,
		    dataType: "json",
		    success: function(mes){
		    	console.info(mes);
		    	if (mes==0) {
//		    		var nullPhone = $("#u16_state4").attr("style","visibility: visible");
//		    		var tusi = $("#u16").attr("style","visibility: visible;");
//		    		var tusi2 = $("#u16").attr("class","animated fadeIn");
//		    		setTimeout("$('#u16').attr('class','animated fadeOut')",2000);
//		    		setTimeout("$('#u16').attr('style','display:none')",3000);
//		    		setTimeout("$('#u16_state4').attr('style','visibility: hidden')",3000);
		    		go();
				}
		    	else if (mes==1||mes==2) {
		    		var nullPhone = $("#u16_state0").attr("style","visibility: visible");
		    		var tusi = $("#u16").attr("style","visibility: visible;");
		    		var tusi2 = $("#u16").attr("class","animated fadeIn");
		    		setTimeout("$('#u16').attr('class','animated fadeOut')",2000);
		    		setTimeout("$('#u16').attr('style','display:none')",3000);
		    		setTimeout("$('#u16_state0').attr('style','visibility: hidden')",3000);
				}
		    },
			error: function(mes){
		    	console.info(mes);
		    	alert("no");
		    }
		});
	}
});
