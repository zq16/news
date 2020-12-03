$(function(){
	initContent();
});

$(window).resize(function(){
	initContent();
})

function initContent(){
	var content = $("#content");
	var Width = document.documentElement.clientWidth;
	var H = content.outerWidth();
	var H2 = (Width - H) / 2 + "px";
	content.css("margin-left",H2);
}