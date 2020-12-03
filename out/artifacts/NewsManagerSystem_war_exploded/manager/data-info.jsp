<%@ page import="com.hnjdzy.news.dao.impl.NewsDaoImpl" %>
<%@ page import="com.hnjdzy.news.dao.impl.TopicsDaoImpl" %>
<%@ page import="com.hnjdzy.news.dao.impl.UsersDaoImpl" %>
<%@ page import="com.hnjdzy.news.dao.NewsDao" %><%--
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
    <style>
        @import url("../css/data-info.css");
    </style>
    <%
        NewsDao ndi = new NewsDaoImpl();
        int newsCount = ndi.findAllNewsCount();
        int topicCount = new TopicsDaoImpl().findAllTopicsCount();
        int userCount = new UsersDaoImpl().findAllUserCount();
        String newestNews = ndi.findAllNews().get(0).getNtitle();
    %>
</head>
<body>
<h1>欢迎使用点点新闻管理系统</h1>
<div id="info">
    <p><b>总新闻条数：</b><%= newsCount%>条
    </p>
    <p><b>总主题个数：</b><%= topicCount%>个
    </p>
    <p><b>总用户人数：</b><%= userCount%>人
    </p>
    <p><b>新发布的新闻：</b><%= newestNews%>
    </p>
</div>
</body>
</html>
