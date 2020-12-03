<%--
  Created by IntelliJ IDEA.
  User: 偃笙
  Date: 2020/12/1
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        @import url("../css/search-news.css");
    </style>
    <script src="../js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/search-news.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>
    <div id="content">
        <img id="logo" src="../img/logo.png" /><br />
        <input type="text" id="ntitle" placeholder="请输入查询内容(新闻标题,描述,作者,内容)..." />
        <span id="send">查询</span>
    </div>
</body>
</html>
