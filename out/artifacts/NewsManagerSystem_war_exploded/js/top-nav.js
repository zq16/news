$(function(){
	// 获取所有span
	var list = $("#top .nav span");
	list[0].className = "header";
	
	list.click(function(){
		var nav = $(this);
		nav.parent("li").siblings("li").children("span").prop("className","");
		nav.prop("className","header");
		$("#currTopic").val(nav.data("tid"));
		jumpPage(1);
	});
});