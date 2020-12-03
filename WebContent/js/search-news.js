$(function () {

    $("#send").on("click",function () {
        var keyWords = $("#ntitle").val();
        $.ajax({
            "url": "../NewsServlet",
            "type": "POST",
            "data": {
                "func": "searchNews",
                "keyWords": keyWords
            },
            "dataType": "text",
            "success": function () {

            },
            "error": function () {
                alert("内部服务器错误");
            }
        });
    });
});