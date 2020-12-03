<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.hnjdzy.news.dao.impl.NewsDaoImpl" %>
<%@ page import="net.sf.json.JSONArray" %>
<%@ page import="java.net.InetAddress" %>
<%@ page import="com.hnjdzy.service.impl.NewsServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: 偃笙
  Date: 2020/11/25
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${news.ntitle}</title>
    <link rel="icon" type="image/x-icon" href="img/logo.ico" />
    <style>
        @import url("css/show-news.css");
    </style>
    <script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/mustache.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/set-window-width.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/show-news.js" type="text/javascript" charset="UTF-8"></script>
    <input type="hidden" value="<%= InetAddress.getLocalHost().getHostAddress()%>" id="host" />
    <input type="hidden" value="<%= request.getParameter("nid")%>" id="nid" />
    <% int commentsCount = new NewsDaoImpl().findNewsCommentsCount(Integer.parseInt(request.getParameter("nid"))); %>
    <% JSONArray comments = new NewsServiceImpl().getNewsCommentsToJSON(request.getParameter("nid")); %>
    <script type="text/javascript" charset="UTF-8">
        $(function () {
            var comments = <%= comments%>;
            putList(comments);
        });
    </script>
</head>
<body>
    <div id="page">
        <div id="top">
            <a href="index.jsp"><img src="img/logo.png" height="64px"></a>
        </div>
        <div id="content">
            <h2>${news.ntitle}</h2>
            <input type="hidden" value="${news.ncontent}" id="newsText">
            <div id="content-text"></div>
            <span class="content-tip">免责声明：本文来自点点新闻客户端自媒体，不代表点点新闻的观点和立场。</span>
            <div id="content-comment">

                <div class="comment-header">
                    <h1>网友评论</h1>
                    <span class="comment-tip">文明上网 理性发言</span>
                    <span class="comment-size"><%= commentsCount%>条评论</span>
                </div>

                <div class="comment-send">
                    <img class="comment-head" src="img/avatar-default.jpg" >
                    <textarea class="comment-input" placeholder="说两句吧..."></textarea>
                    <span class="comment-submit" onclick="submitComment()">回复</span>
                    <input class="comment-author" placeholder="请输入您的昵称..." />
                    <span class="comment-warning"></span>
                </div>

                <div class="comment-nav">
                    <span class="comment-title">全部评论</span>
                    / <span class="comment-type">最新</span>
                </div>

                <div class="comment-user">
                    <ul>

                    </ul>
                </div>
            </div>
            <div id="footer">
                <span class="copy">Copyright 2020 - 2020 DianDianNews. All Rights Reserved</span>
            </div>
        </div>
    </div>
</body>
<script type="text/template" id="comment-box">
    <li>
        <img class="comment-head" src="img/avatar-default.jpg" >
        <div class="comment-box">
            <span class="comment-username">{{cauthor}}</span>
            <span class="comment-time">{{cdate}}</span>
            <br />
            <span class="comment-content">{{ccontent}}</span>
            <br />
            <span class="comment-thumb">赞 {{cthumb}}</span>
        </div>
    </li>
</script>
</html>
