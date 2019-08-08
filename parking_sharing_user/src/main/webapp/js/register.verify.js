$("#u5_div").click(function(){
	var u_phone = $("#u14_input").val();
	var u_password = $("#u4_input").val();
	var u_realname = $("#u41_input").val();
	var u_idcard = $("#u47_input").val();
	var u_email = $("#u38_input").val();
	var u_address = $("#u55_input").val();
	var u_job = $("#u51_input").val();
	var u_username = $("#u65_input").val();
	//输入的验证码
	var code = $("#u16_input").val();
	//名字格式表达式
	var nameStyle = /^[\u4e00-\u9fa5 ]{2,10}$/;   
	//身份证格式表达式
	var idcardStyle = /^[1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
	//邮箱格式表达式
	var emailStyle = /^\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/;
	//是否同意协议
	var checkboxStatus = $("#agree").is(':checked');
	
	function go(){ 
		window.location.href="/login.html";
	} 

	/* 账户名不能为空 */
	if (u_username=="") {
		var nullPhone = $("#u21_state1").attr("style","visibility: visible");
		var tusi = $("#u21").attr("style","visibility: visible;");
		var tusi2 = $("#u21").attr("class","animated fadeIn");
		setTimeout("$('#u21').attr('class','animated fadeOut')",2000);
		setTimeout("$('#u21').attr('style','display:none')",3000);
		setTimeout("$('#u21_state1').attr('style','visibility: hidden')",3000);
	}
	/* 手机不能为空  */
	else if (u_phone=="") {
		var nullPhone = $("#u21_state3").attr("style","visibility: visible");
		var tusi = $("#u21").attr("style","visibility: visible;");
		var tusi2 = $("#u21").attr("class","animated fadeIn");
		setTimeout("$('#u21').attr('class','animated fadeOut')",2000);
		setTimeout("$('#u21').attr('style','display:none')",3000);
		setTimeout("$('#u21_state3').attr('style','visibility: hidden')",3000);
	}
	/* 手机格式  */
	else if (!(/^1[3456789]\d{9}$/.test(u_phone))) {
		var nullPhone = $("#u21_state2").attr("style","visibility: visible");
		var tusi = $("#u21").attr("style","visibility: visible;");
		var tusi2 = $("#u21").attr("class","animated fadeIn");
		setTimeout("$('#u21').attr('class','animated fadeOut')",2000);
		setTimeout("$('#u21').attr('style','display:none')",3000);
		setTimeout("$('#u21_state2').attr('style','visibility: hidden')",3000);
	}
	/* 密码长度  */
	else if (u_password.length<6||u_password.length>20) {
		var nullPhone = $("#u21_state5").attr("style","visibility: visible");
		var tusi = $("#u21").attr("style","visibility: visible;");
		var tusi2 = $("#u21").attr("class","animated fadeIn");
		setTimeout("$('#u21').attr('class','animated fadeOut')",2000);
		setTimeout("$('#u21').attr('style','display:none')",3000);
		setTimeout("$('#u21_state5').attr('style','visibility: hidden')",3000);
	}
	/* 姓名格式 */
    else if (!nameStyle.test(u_realname)) {
		var nullPhone = $("#u21_state6").attr("style","visibility: visible");
		var tusi = $("#u21").attr("style","visibility: visible;");
		var tusi2 = $("#u21").attr("class","animated fadeIn");
		setTimeout("$('#u21').attr('class','animated fadeOut')",2000);
		setTimeout("$('#u21').attr('style','display:none')",3000);
		setTimeout("$('#u21_state6').attr('style','visibility: hidden')",3000);
	}
	/* 身份证格式  */
	else if (!idcardStyle.test(u_idcard)) {
		var nullPhone = $("#u21_state7").attr("style","visibility: visible");
		var tusi = $("#u21").attr("style","visibility: visible;");
		var tusi2 = $("#u21").attr("class","animated fadeIn");
		setTimeout("$('#u21').attr('class','animated fadeOut')",2000);
		setTimeout("$('#u21').attr('style','display:none')",3000);
		setTimeout("$('#u21_state7').attr('style','visibility: hidden')",3000);
	}
	/* 邮箱格式 */
	else if (!emailStyle.test(u_email)) {
		var nullPhone = $("#u21_state8").attr("style","visibility: visible");
		var tusi = $("#u21").attr("style","visibility: visible;");
		var tusi2 = $("#u21").attr("class","animated fadeIn");
		setTimeout("$('#u21').attr('class','animated fadeOut')",2000);
		setTimeout("$('#u21').attr('style','display:none')",3000);
		setTimeout("$('#u21_state8').attr('style','visibility: hidden')",3000);
	}
	/* 地址不能为空 */
	else if (u_address=="") {
		var nullPhone = $("#u21_state0").attr("style","visibility: visible");
		var tusi = $("#u21").attr("style","visibility: visible;");
		var tusi2 = $("#u21").attr("class","animated fadeIn");
		setTimeout("$('#u21').attr('class','animated fadeOut')",2000);
		setTimeout("$('#u21').attr('style','display:none')",3000);
		setTimeout("$('#u21_state0').attr('style','visibility: hidden')",3000);
	}
	/* 地址不能为空 */
	else if (u_job=="") {
		var nullPhone = $("#u21_state4").attr("style","visibility: visible");
		var tusi = $("#u21").attr("style","visibility: visible;");
		var tusi2 = $("#u21").attr("class","animated fadeIn");
		setTimeout("$('#u21').attr('class','animated fadeOut')",2000);
		setTimeout("$('#u21').attr('style','display:none')",3000);
		setTimeout("$('#u21_state4').attr('style','visibility: hidden')",3000);
	}
	/* 同意用户协议 */
	else if (checkboxStatus==false) {
		var nullPhone = $("#u21_state10").attr("style","visibility: visible");
		var tusi = $("#u21").attr("style","visibility: visible;");
		var tusi2 = $("#u21").attr("class","animated fadeIn");
		setTimeout("$('#u21').attr('class','animated fadeOut')",2000);
		setTimeout("$('#u21').attr('style','display:none')",3000);
		setTimeout("$('#u21_state10').attr('style','visibility: hidden')",3000);
	}
	/* 注册成功 */
	else if (checkboxStatus==true) {
		$.ajax({
		    type: "get",
		    url: "/user/insertuser",
		    data:{
		    	"username":u_username,
		    	"password":u_password,
		    	"realname":u_realname,
		    	"address":u_address,
		    	"phone":u_phone,
		    	"idcard":u_idcard,
		    	"job":u_job,
		    	"email":u_email
		    },
		    dataType: "json",
		    success: function(mes){
		    	if (mes==0) {
		    		/* 用户已存在 */
		    		var nullPhone = $("#u21_state11").attr("style","visibility: visible");
		    		var tusi = $("#u21").attr("style","visibility: visible;");
		    		var tusi2 = $("#u21").attr("class","animated fadeIn");
		    		setTimeout("$('#u21').attr('class','animated fadeOut')",2000);
		    		setTimeout("$('#u21').attr('style','display:none')",3000);
		    		setTimeout("$('#u21_state11').attr('style','visibility: hidden')",3000);
				}
		    	else if (mes==1) {
		    		//注册成功弹框提示
		    		var nullPhone = $("#u21_state9").attr("style","visibility: visible");
		    		var tusi = $("#u21").attr("style","visibility: visible;");
		    		var tusi2 = $("#u21").attr("class","animated fadeIn");
		    		setTimeout("$('#u21').attr('class','animated fadeOut')",1500);
		    		setTimeout("$('#u21').attr('style','display:none')",1500);
		    		setTimeout("$('#u21_state9').attr('style','visibility: hidden')",1500);
		    		setTimeout("$('#u21_state9').attr('style','visibility: hidden')",1500);
		    		setTimeout(go, 1700);
		    		
				}
		    	else if (mes==2) {
		    		/* 其他原因注册失败  */
		    		var nullPhone = $("#u21_state12").attr("style","visibility: visible");
		    		var tusi = $("#u21").attr("style","visibility: visible;");
		    		var tusi2 = $("#u21").attr("class","animated fadeIn");
		    		setTimeout("$('#u21').attr('class','animated fadeOut')",2000);
		    		setTimeout("$('#u21').attr('style','display:none')",3000);
		    		setTimeout("$('#u21_state12').attr('style','visibility: hidden')",3000);
				}
		    },
		    error: function(mes){
		    	alert("系统繁忙");	    	
		    }
		});	
	}
});