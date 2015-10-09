// JavaScript Document
function getTime(){
	var now= new Date();
	var year=now.getYear()+1900;
	var month=now.getMonth()+1;
	var day=now.getDate();
	var hour=now.getHours();
	var minute=now.getMinutes();
	var second=now.getSeconds();
	var weekday=now.getDay();
	if(weekday==0)          weekday="星期日"
	if(weekday==1)          weekday="星期一"
	if(weekday==2)          weekday="星期二"
	if(weekday==3)          weekday="星期三"
	if(weekday==4)          weekday="星期四"
	if(weekday==5)          weekday="星期五"
	if(weekday==6)          weekday="星期六"

	if (month < 10) month = "0" + month;
	if (day < 10) day = "0" + day;
	if (hour < 10) hour = "0" + hour;
	if (minute < 10) minute = "0" + minute;
	if (second < 10) second = "0" + second;
	var nowdate="登陆时间："+year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second+" "+weekday;
	$('.nav-topright').find('p').text(nowdate);

	var role_warn = $('#role_warn').val();
	if(role_warn==1){
		$('#hi_role').text("您好：员工");
	}
	else if(role_warn==2){
		$('#hi_role').text("您好：管理员");
	}
	else if(role_warn==3){
		$('#hi_role').text("您好：项目经理");
	}
};
/**更新时间*/
$(function(){
	setInterval(getTime,1000);
});
$(function(){
	//完整菜单效果1
		$(".menu_list").hide();
		$(".menu_list_first").show();
		$(".a_list").click(function(){
			var len = $('.a_list').length;
			var index = $(".a_list").index(this);
			for(var i=0;i<len;i++){
				if(i == index){
					$('.menu_list').eq(i).slideToggle(300);
					}else{
						$('.menu_list').eq(i).slideUp(300);
					}
				}
			});
		//完整菜单效果2
		/*$(".a_list").each(function(l){
			$(this).click(function(){
				var len = $('.a_list').length;
				for(var i=0;i<len;i++){
					if(i == l){
						$('.menu_list').eq(i).slideToggle(100);
					}else
					{
						$('.menu_list').eq(i).slideUp(100);
					}
				}
			})	
		})*/
	})
	
	//点击显示隐藏完成菜单和简洁菜
	$(function(){
		$(".menu-oc").click(function(){
			$(".leftmenu1").animate({left:"-292px"})	;
			$(".leftmenu2").animate({left:"0px"})
			$(".rightcon").css("margin-left","52px")
		})
		$(".menu-oc1").click(function(){
			$(".leftmenu1").animate({left:"0px"})	;
			$(".leftmenu2").animate({left:"-192px"});
			$(".rightcon").css("margin-left","240px");
		})		
	})
	
	//洁菜单点击效
	/*
	$(function(){
		$(".j_menu_list").hide();
		$(".j_a_list").click(function(){
			var len = $('.j_a_list').length;
			var index = $(".j_a_list").index(this);
			for(var i=0;i<len;i++){
				if(i == index){
					$('.j_menu_list').eq(i).slideToggle(300);
					}else{
						$('.j_menu_list').eq(i).slideUp(300);
					}
				}
		});
		$(".j_menu_list>span>i").click(function(){
			$(".j_menu_list").slideUp(300)	
		})
	})*/
	//洁菜单移动效
	$(function(){
		$(".j_menu_list").hide();
		$(".j_a_list").hover(function(){
			$(".leftmenu2 ul li").hover(function(){
				$(this).find('.j_menu_list').show();	
			},function(){
				$(this).find('.j_menu_list').hide();
			});
		})
	})
	
	