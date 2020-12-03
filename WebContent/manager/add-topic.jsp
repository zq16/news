<%--
  Created by IntelliJ IDEA.
  User: 偃笙
  Date: 2020/11/25
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        @import url("../css/add-news.css");
    </style>
    <script src="../js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/add-topic.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
    <div id="content">
        <form action="" method="post" id="newsData">
            <table border="0" cellspacing="" cellpadding="">
                <tr>
                    <td><span>新闻主题名：</span></td>
                    <td><input type="text" id="tname" /></td>
                </tr>
            </table>
            <div id="func">
                <span id="send">提交</span>
                <input type="reset" value="重置"/>
            </div>
        </form>
    </div>
</body>
</html>
