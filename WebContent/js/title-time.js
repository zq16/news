$(function(){
	var ti = $("#title-inform");
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var day = date.getDate();
	var week = ["天","一","二","三","四","五","六"];
	var currWeek = date.getDay();
	var half = "";
	if(date.getHours()>18){
		half = "晚上";
	}else if(date.getHours()>12){
		half = "下午";
	}else if(date.getHours()>8){
		half = "上午";
	}else{
		half = "早上";
	}
	ti.html(
	year + "年" + 
	month + "月" +
	day + "日 星期" +
	week[currWeek] + " " +
	half + "好!"
	);
	
});
