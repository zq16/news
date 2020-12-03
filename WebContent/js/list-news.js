$(function(){

	// 当单页记录数修改时触发
	$("#content select").on("change", function () {
		$("#currTopic").val($(this).children("option:selected").val());
		jumpPage(1);
	});

	$("#newsList th").css({
		"background-color":"#555",
		"color":"white",
		"font-size":"15px"
	});
	$("#newsList tr:even").css("background-color","#f6f4f0");
	$("#newsList tr:even textarea").css("background-color","#f6f4f0");
	
	$("#select-all").on("click",function(){
		$(" :checkbox").prop("checked",$(this).prop("checked"));
	});
	
	$(" :checkbox").not("#select-all").on("click",function(){
		if($(" :checkbox").not("#select-all").length != $(" :checkbox:checked").not("#select-all").length){
			$("#select-all").prop("checked",false);
		}else{
			$("#select-all").prop("checked",true);
		}
	});

	// 当单页记录数修改时触发
	$("#pageChoice select").on("change", function () {
		jumpPage(1);
	});


});


/**
 * 往首页放置新闻列表
 *
 * @param list 欲放置的新闻列表
 * @return:
 * @Author: BloodArea
 * @Date: 2020-11-29 16:16:01
 */
function putList(list) {
	$("#newsList").children("tr").remove();
	for (var i = 0; i < list.length; i++) {
		var obj = {};
		obj.nid = list[i].nid;
		obj.ntid = list[i].ntid;
		obj.ntitle = list[i].ntitle;
		obj.nauthor = list[i].nauthor;
		obj.nsummary = list[i].nsummary;
		obj.ncontent = list[i].ncontent;
		obj.npicpath = list[i].npicpath;
		obj.ncreatedate = list[i].ncreatedate;
		obj.nmodifydate = list[i].nmodifydate;
		obj.modify = "delNews(" + list[i].nid + ")";
		obj.del = "delNews(" + list[i].nid + ")";
		//添加新闻
		addNews(obj);
	}
}

/**
 * 往首页添加一个新闻
 *
 * @param metaNews 新闻数据(js对象)
 * @return:
 * @Author: BloodArea
 * @Date: 2020-11-29 16:19:11
 */
function addNews(metaNews) {
	var nBox = $("#news-box").html();
	var newsData = Mustache.render(nBox, metaNews);
	$("#newsList").append(newsData);
}

/**
 * 往首页添加页码选择器
 *
 * @param pageSize 页码最大值
 * @return:
 * @Author: BloodArea
 * @Date: 2020-11-29 16:22:35
 */
function putPage(pageSize) {
	$("#pageChoice ul").children("li").remove();
	var pBox = $("#page-box").html();
	for (var i = 1; i <= pageSize; i++) {
		var obj = {};
		obj.pageNum = i;
		var pageData = Mustache.render(pBox, obj);
		$("#pageChoice ul").append(pageData);
	}
}

/**
 * 设置页面数据
 *
 * @param currPage 当前页
 * @param totalPage 总页数
 * @return:
 * @Author: BloodArea
 * @Date: 2020-11-29 16:23:26
 */
function setPageData(currPage, totalPage) {
	$("#pageChoice .tag:eq(0)").html("当前页: " + currPage);
	$("#pageChoice .tag:eq(1)").html("总页数: " + totalPage);
}

/**
 * 获取当前页数
 *
 * @param null
 * @return:
 * @Author: BloodArea
 * @Date: 2020-11-29 16:23:57
 */
function getCurrPage() {
	var currPage = $("#pageChoice .tag:eq(0)").html();
	return parseInt(currPage.substring(5, currPage.length));
}

/**
 * 获取总页数
 *
 * @param null
 * @return:
 * @Author: BloodArea
 * @Date: 2020-11-29 16:25:19
 */
function getLastPage() {
	var currPage = $("#pageChoice .tag:eq(1)").html();
	return parseInt(currPage.substring(5, currPage.length));
}

/**
 * Ajax形式跳转到指定页码
 *
 * @param pageNum 欲跳转的页码
 * @return:
 * @Author: BloodArea
 * @Date: 2020-11-29 16:26:22
 */
function jumpPage(pageNum) {
	var currTopic = $("#currTopic").val();
	var pageSize = $("#pageChoice option:selected").val();
	$.ajax({
		"url": "../NewsServlet",
		"type": "POST",
		"data": {
			"func": "page",
			"currTopic": currTopic,
			"pageNum": pageNum,
			"pageSize": pageSize
		},
		"dataType": "json",
		"success": function (result) {
			putList(result.pageList);
			window.location.href = "#";
			putPage(result.totalPage);
			setPageData(result.currPage, result.totalPage);
		},
		"error": function () {
			alert("内部服务器错误");
		}
	});
}

/**
 * 跳转到前一页
 *
 * @param null
 * @return:
 * @Author: BloodArea
 * @Date: 2020-11-29 16:33:12
 */
function prevPage() {
	var currPage = getCurrPage();
	if (currPage > 1) {
		jumpPage(currPage - 1);
	}
}

/**
 * 跳转到下一页
 *
 * @param null
 * @return:
 * @Author: BloodArea
 * @Date: 2020-11-29 16:38:05
 */
function nextPage() {
	var lastPage = getLastPage();
	var currPage = getCurrPage();
	if (currPage < lastPage) {
		jumpPage(currPage + 1);
	}
}

/**
 * 跳转到最后一页
 *
 * @param null
 * @return:
 * @Author: BloodArea
 * @Date: 2020-11-29 16:38:17
 */
function lastPage() {
	jumpPage(getLastPage());
}

/**
 * ajax方式删除新闻
 *
 * @param nid 新闻id
 * @return:
 * @Author: BloodArea
 * @Date: 2020-12-02 22:55:56
 */
function delNews(nid){
	$.ajax({
		"url": "../NewsServlet",
		"type": "GET",
		"data": {
			"func": "delNews",
			"nid": nid
		},
		"dataType": "text",
		"success": function (result) {
			jumpPage(getCurrPage());
			alert("删除成功！");
		},
		"error": function () {
			alert("内部服务器错误");
		}
	});
}
