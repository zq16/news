$(function () {
    var text = $("#newsText").val().split("\n");
    for (var i = 0; i < text.length; i++) {
        $("#content-text").append("<p>" + text[i] + "</p>");
    }
});

function putList(list) {
    $("#content #content-comment .comment-user ul").children("li").remove();
    for (var i = 0; i < list.length; i++) {
        var obj = {};
        obj.ccontent = list[i].ccontent;
        obj.cdate = list[i].cdate;
        obj.cauthor = list[i].cauthor;
        obj.cthumb = list[i].cthumb;
        //添加评论
        addComment(obj);
    }
}

function insertComment(metaComment) {
    var obj = {};
    obj.ccontent = metaComment.ccontent;
    //yyyy-MM-dd HH:mm:ss
    obj.cdate = dateFormat(metaComment.cdate, 'yyyy-MM-dd');
    obj.cauthor = metaComment.cauthor;
    obj.cthumb = metaComment.cthumb;
    var cBox = $("#comment-box").html();
    var commentData = Mustache.render(cBox, obj);
    $("#content #content-comment .comment-user ul").prepend(commentData);
}

function addComment(metaComment) {
    var cBox = $("#comment-box").html();
    var commentData = Mustache.render(cBox, metaComment);
    $("#content #content-comment .comment-user ul").append(commentData);
}

function submitComment() {
    var cnid = $("#nid").val();
    var content = $(".comment-send .comment-input").val();
    var author = $(".comment-send .comment-author").val();
    var host = $("#host").val();
    if(content == "" || author == ""){
        alert("请输入评论或昵称！");
        return;
    }
    $.ajax({
        "url": "NewsServlet",
        "type": "POST",
        "data": {
            "func": "submitComment",
            "cnid": cnid,
            "ccontent": content,
            "cip": host,
            "cauthor": author
        },
        "dataType": "json",
        "success": function (result) {
            insertComment(result);
            $(".comment-send .comment-input").val("");
            $(".comment-send .comment-author").val("");
            $(".comment-header .comment-size").html((getCommentSize()+1) + "条评论");
        },
        "error": function () {
            alert("内部服务器错误");
        }
    });
}

function getCommentSize() {
    var html = $(".comment-header .comment-size").html();
    return parseInt(html.substring(0, html.length - 3));
}

function dateFormat(date, format) {
    date = new Date(date);
    date.setHours(date.getHours() - 14);
    var o = {
        'M+': date.getMonth() + 1, //month
        'd+': date.getDate(), //day
        'H+': date.getHours(), //hour
        'm+': date.getMinutes(), //minute
        's+': date.getSeconds(), //second
        'q+': Math.floor((date.getMonth() + 3) / 3), //quarter
        'S': date.getMilliseconds() //millisecond
    };

    if (/(y+)/.test(format))
        format = format.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length));

    for (var k in o)
        if (new RegExp('(' + k + ')').test(format))
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ('00' + o[k]).substr(('' + o[k]).length));

    return format;
}