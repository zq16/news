$(function(){
	var title = $(".func h2");
	
	title.click(function(){
		var func_ul = $(this).next();
		var else_ul = $(this).parent(".func").siblings(".func").children("ul");
		var func_h2 = $(this).children(".char");
		var else_h2 = $(this).parent(".func").siblings(".func").children("h2").children(".char");
		if(func_ul.css("display") == "none"){
			else_ul.slideUp();
			func_ul.slideDown();
			func_h2.html("-");
			else_h2.html("+");
		}else{
			func_h2.html("+");
			func_ul.slideUp();
		}
	});
});