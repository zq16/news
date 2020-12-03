<%@ page import="com.hnjdzy.news.entity.NewsPage" %>
<%@ page import="com.hnjdzy.news.entity.Topic" %>
<%@ page import="com.hnjdzy.news.dao.impl.TopicsDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hnjdzy.news.entity.News" %>
<%@ page import="com.alibaba.fastjson.JSON" %><%--
  Created by IntelliJ IDEA.
  User: 偃笙
  Date: 2020/12/1
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        @import url("../css/list-news.css");
    </style>
    <input type="hidden" value="1" id="currTopic" />
    <script src="../js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/mustache.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/list-news.js" type="text/javascript" charset="utf-8"></script>
    <%
        String result = request.getParameter("result");
        List<News> newsList = JSON.parseArray(result,News.class);
    %>
    <script type="text/javascript" charset="UTF-8">
        $(function () {
            putList(<%= newsList%>);
        });
    </script>
</head>
<body>
<div id="content">
    <input type="button" name="" id="delSelect" value="删除选中" />
    <select>
        <%List<Topic> topicList = new TopicsDaoImpl().findAllTopics();%>
        <c:forEach items="<%=topicList%>" var="topic" varStatus="status">
            <option value="${topic.tid}">${topic.tname}</option>
        </c:forEach>
    </select>
    <table border="0" cellspacing="0" cellpadding="0" id="newsList">
        <tr>
            <th><input type="checkbox" id="select-all" /></th>
            <th>新闻ID</th>
            <th>所属主题</th>
            <th style="width: 150px;">新闻标题</th>
            <th>新闻作者</th>
            <th>新闻描述</th>
            <th style="width: 250px;">新闻内容</th>
            <th>图片地址</th>
            <th>创建时间</th>
            <th>修改时间</th>
            <th>修改项</th>
            <th>删除项</th>
        </tr>
    </table>
</div>
</body>
<script type="text/template" id="news-box">
    <tr>
        <td><input type="checkbox" name="select"/></td>
        <td>{{nid}}</td>
        <td>{{ntid}}</td>
        <td><textarea class="ntitle" readonly>{{ntitle}}</textarea></td>
        <td>{{nauthor}}</td>
        <td><textarea class="nsummary" readonly>{{nsummary}}</textarea></td>
        <td><textarea class="ncontent" readonly>{{ncontent}}</textarea></td>
        <td><textarea class="npicpath" readonly>{{npicpath}}</textarea></td>
        <td>{{ncreatedate}}</td>
        <td>{{nmodifydate}}</td>
        <td><div class="modify" onclick="{{modify}}">修改</div></td>
        <td><div class="del" onclick="{{del}}">删除</div></td>
    </tr>
</script>
</html>