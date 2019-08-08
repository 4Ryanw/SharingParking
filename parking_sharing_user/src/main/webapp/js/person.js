$(function(){
	//进入页面发送请求获取用户信息
	$.ajax({
		type:"get",
		url:"http://user.com:9001/user/showPerson",
		dataType:"json",
		success:function(mes){
			var phone = "&gt;";
			if (mes.u_phone!=null) {
				phone = geTel(mes.u_phone)+"&gt;";
			} 
			
			$(".show_phone").html(phone);
		}
	})
	
	//获取操作选项
	var lis = $(".content li")
	lis.each(function(i){
		$(this).click(function(){
			if (i==0) {
				location.href="person_info.html";
			} else if(i==1){
				location.href="person_phone_update.html"
			}else{
				location.href="person_password_update.html"
			}
		})
		$(this).mousedown(function(){
			$(this).attr("class","show_down");
		})
		$(this).mouseup(function(){
			$(this).removeAttr("class","show_down");
		})
	})
	var back = $(".back_page")[0];
	back.click(function(){
		location.href="me.html";
	})
})
	function geTel(tel){
		var reg = /^(\d{3})\d{4}(\d{4})$/;  
		return tel.replace(reg, "$1****$2");
	}
	//******************************//
	
	
	
	//发送验证码
	var clock = '';
	var nums = "60";
	var btn = $(".sendCode")
	var inPhone = $(".inPhone")
	var inCode = $(".inCode")
	
	
	$(".get_code").click(function() {
		if (inPhone.val()==null) {
			inPhone.attr("placeholder","请输入手机号");
		} else{
			var regx1 = /^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/;
			
			if (!yanzheng()) {
				inPhone.attr("placeholder","手机号格式有误！！");
			}
		}
		$(this).attr("class", "code_point");
		sendCode($(this));
	})
	function yanzheng(){
		var regx1 = /^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/;
		
		if (!regx1.test(inPhone.val())) {
			return false;
		}
		return true;
	}
	
	$(".phone_submit").click(function(){
		if (inPhone.val()=="") {
			inPhone.attr("placeholder","请输入手机号");
			return;
		} else if(inCode.val()==""){
			inCode.attr("placeholder","请输入验证码");
			return;
		}else if(!yanzheng()){
			inPhone.val("")
			inPhone.attr("placeholder","手机号格式有误");
			return;
		}
		$.ajax({
			type:"post",
			url:"http://user.com:9001/user/updateInfo",
			data:"u_phone="+$(".inPhone").val(),
			success:function(mes){
				if (mes==true) {
					alert("修改成功")
				} else{
					alert("修改失败")
				}
			}
		})
	})
	
	function sendCode(thisBtn) {
		btn = thisBtn;
		btn.attr("disabled",true) ; //将按钮置为不可点击
		btn.val(nums + '秒后获取') ;
		clock = setInterval(doLoop, 1000); //一秒执行一次
	}
	function doLoop() {
		nums--;
		if (nums > 0) {
			btn.val(nums + '秒后获取') ;
		} else {
			clearInterval(clock); //清除js定时器
			btn.attr("disabled",false);
			btn.val('获取验证码') ;
			nums = "60"; //重置时间
		}
	}
	//*************************************//
	var password = $(".password")
	var rePassword = $(".rePassword")
	$(".pwd_submit").click(function(){
		
		//判断密码
		if (password.val()=="") {
			password.attr("placeholder","请输入密码");
			return;
		} else if(rePassword.val()==""){
			rePassword.attr("placeholder","请输入确认密码");
			return;
		} else if(!isSame(password.val(),rePassword.val())){
			rePassword.val("");
			rePassword.attr("placeholder","两次密码不相同");
			return;
		}//需要添加密码匹配格式
		$.ajax({
			type:"post",
			url:"http://user.com:9001/user/updateInfo?u_password="+$(".password").val(),
			success:function(mes){
				if (mes==true) {
					alert("修改成功")
				} else{
					alert("修改失败")
				}
			}
		})
	})
	//判断两次密码是否一致
	function isSame(pwd,rePwd){
		if (pwd==rePwd) {
			return true;
		}
			return false;
	}
	
	
	//*****************//
	
	
	
	$(".info_submit").click(function(){
		$.ajax({
			type:"post",
			url:"http://user.com:9001/user/updateInfo",
			data:$("#myform").serialize(),
			success:function(mes){
				if (mes==true) {
					alert("修改成功")
				} else{
					alert("修改失败")
				}
			}
		})
	})
	