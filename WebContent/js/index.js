$(function () {
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
    $("#content #newsContent ul").children("li").remove();
    for (var i = 0; i < list.length; i++) {
        var obj = {};
        obj.nurl = $("#srcPath").val() + "/NewsServlet?func=showNews&nid=" + list[i].nid;
        obj.ntitle = list[i].ntitle;
        obj.nsummary = list[i].nsummary;
        obj.nauthor = list[i].nauthor;
        obj.ncreatedate = list[i].ncreatedate;
        obj.ncommentcount = list[i].ncommentcount;
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
    $("#content #newsContent ul").append(newsData);
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
        "url": "NewsServlet",
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
* 将分享的内容复制到剪切板
*
 * @param null
* @return:
* @Author: BloodArea
* @Date: 2020-11-29 16:38:33
*/
function copyToClipBoard(title, url) {
    var host = window.location.href;
    host = host.substring(0, host.lastIndexOf("/"));
    host = host.substring(0, host.lastIndexOf("/"));
    content = title + "\n" + host + url;
    copyOrderId(content);

}

/**
 * 置文本到剪切板
 *
 * @param toBeCopy 欲复制的字符串
 * @return:
 * @Author: BloodArea
 * @Date: 2020-11-29 15:48:12
 */
function copyOrderId(toBeCopy) {

    var tag = document.createElement('input');
    tag.setAttribute('id', 'cp_zdy_input');
    tag.value = toBeCopy;

    document.getElementsByTagName('body')[0].appendChild(tag);
    document.getElementById('cp_zdy_input').select();
    document.execCommand('copy');
    document.getElementById('cp_zdy_input').remove();
    alert("复制成功,你可以利用快捷方式Ctrl+V粘贴到QQ或MSN里");

}