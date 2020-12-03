$(function(){
    $("#send").on("click",function(){
        var tname = $("#tname").val();
        if(tname == ""){
            alert("请输入新闻主题名");
            return;
        }
        $.ajax({
            "url": "../TopicServlet",
            "type": "GET",
            "data": {
                "func": "addTopic",
                "tname": tname
            },
            "dataType": "text",
            "success": function () {
                alert("添加成功！");
            },
            "error": function () {
                alert("内部服务器错误");
            }
        });
    });
});