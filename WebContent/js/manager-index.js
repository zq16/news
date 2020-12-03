$(function(){
	var frame = $("#content iframe")[0].contentWindow;
	initContent();
});

$(window).resize(function(){
	initContent();
})

function initContent(){
	var conWidth = $(window).width() - 289;
	 $("#content iframe").width(conWidth);
	 $("#content iframe").height(1290) ;
}