<%--
  Created by IntelliJ IDEA.
  User: 偃笙
  Date: 2020/11/25
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>点点新闻管理系统 - 首页</title>
    <link rel="icon" type="image/x-icon" href="img/logo.ico" />
    <style>
        @import url("../css/manager-index.css");
    </style>
    <script type="text/javascript" src="../js/jquery.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="../js/left-list.js" charset="UTF-8"></script>
    <script src="../js/manager-index.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
    <div id="page">
        <div id="top">
            <a href="index.jsp"><img src="../img/manager-logo.png" height="64px"></a>
            <span class="tp"><a href="../index.jsp">返回新闻主页</a></span>
        </div>
        <div id="left-list">
            <a href="javascript:void(0);" onclick="$('#content iframe').prop('src','data-info.jsp')"><h2>&emsp;首页</h2></a>
            <div class="func">
                <h2>新闻管理<span class="char">+</span></h2>
                <ul>
                    <li><a href="javascript:void(0);" onclick="$('#content iframe').prop('src','list-news.jsp')">全部新闻</a></li>
                    <li><a href="javascript:void(0);" onclick="$('#content iframe').prop('src','add-news.jsp')">添加新闻</a></li>
                    <li><a href="javascript:void(0);" onclick="$('#content iframe').prop('src','search-news.jsp')">查询新闻</a></li>
                </ul>
            </div>
            <div class="func">
                <h2>主题管理<span class="char">+</span></h2>
                <ul>
                    <li><a href="javascript:void(0);">全部主题</a></li>
                    <li><a href="javascript:void(0);" onclick="$('#content iframe').prop('src','add-topic.jsp')">添加主题</a></li>
                    <li><a href="javascript:void(0);">查询主题</a></li>
                </ul>
            </div>
            <div class="func">
                <h2>用户管理<span class="char">+</span></h2>
                <ul>
                    <li><a href="javascript:void(0);">全部用户</a></li>
                    <li><a href="javascript:void(0);">添加用户</a></li>
                    <li><a href="javascript:void(0);">查询用户</a></li>
                </ul>
            </div>
        </div>
        <div id="content">
            <iframe src="data-info.jsp" frameborder="no" noresize scrolling="no"></iframe>
        </div>
        <div id="footer">
            <span class="copy">Copyright 2020 - 2020 DianDianNews. All Rights Reserved</span>
        </div>
    </div>
</body>
</html>
