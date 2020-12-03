$(function(){
	$("#send").on("click",function(){
		$("#ncontent").val($("textarea").val());
		var data = $("#newsData").serializeArray();
		var json = JSON.stringify(data);
		console.log(json);
	});
});