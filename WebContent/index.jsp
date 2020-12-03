
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hnjdzy.news.entity.Topic" %>
<%@ page import="com.hnjdzy.news.dao.impl.TopicsDaoImpl" %>
<%@ page import="com.hnjdzy.news.entity.NewsPage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="img/logo.ico" />
    <title>点点新闻 - 首页</title>
    <style>
        @import "./css/index.css";
    </style>
    <input type="hidden" value="${pageContext.request.contextPath}" id="srcPath" />
    <input type="hidden" value="1" id="currTopic" />
    <script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/mustache.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/set-window-width.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/index.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/title-time.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/top-nav.js" type="text/javascript" charset="UTF-8"></script>
    <% NewsPage np = new NewsPage(1,1,10); %>
    <script type="text/javascript" charset="UTF-8">
        $(function () {
            putList(<%= np.getPageList()%>);
        });
    </script>
</head>
<body>
    <div id="page">
        <div id="top">
            <a href="index.jsp"><img src="img/logo.png" height="64px"></a>
            <span class="tp"><a href="manager/index.jsp">进入管理后台</a></span>
            <div class="nav">
                <ul>
                	<%List<Topic> topicList = new TopicsDaoImpl().findAllTopics();%>
                	<c:forEach items="<%=topicList%>" var="topic" end="17">
                		<li><span data-tid="${topic.tid}">${topic.tname}</span></li>
                	</c:forEach>
                </ul>
            </div>
        </div>
        <div id="content">
            <div class="title">
                <h2>热点新闻</h2>
                <span id="title-inform">2020年11月12日 星期四 上午好</span>
            </div>
            <div id="newsContent">
	            <ul>
	            </ul>
            </div>
            
            <div id="pageChoice">
				<span class="func"><a href="index.jsp">首页</a></span>
				<span class="func"><a href="javascript:void(0)" onclick="prevPage()" >上一页</a></span>
				<ul>
                    <c:forEach begin="1" end="<%= np.getTotalPage()%>" var="pageNum">
                        <li><a href="javascript:void(0)" onclick="jumpPage(${pageNum})">${pageNum}</a></li>
                    </c:forEach>
				</ul>
				<span class="func"><a href="javascript:void(0)" onclick="nextPage()">下一页</a></span>
				<span class="func"><a href="javascript:void(0)" onclick="lastPage()">尾页</a></span>
                <span class="tag">当前页: 1</span>
                <span class="tag">总页数: <%= np.getTotalPage()%></span>
				<span class="tag">单页记录数:</span>
				<select>
					<option value="10">10</option>
					<option value="20">20</option>
					<option value="30">30</option>
				</select>
			</div>
            <div id="footer">
                <span class="copy">Copyright 2020 - 2020 DianDianNews. All Rights Reserved</span>
            </div>
        </div>
    </div>
</body>
<script type="text/template" id="news-box">
    <li>
        <a href="{{nurl}}"><div class="c-img"><img src="img/default_image.png" /></div></a>
        <div class="text">
            <a href="{{nurl}}"><span class="content-title">{{ntitle}}</span></a>
            <span class="content-summary">{{nsummary}}</span>
            <span class="content-tag"><a href="{{nurl}}">{{nauthor}}</a> {{ncreatedate}}</span>
            <a href="{{nurl}}#content-comment"><span class="content-comment">{{ncommentcount}}</span></a>
            <a href="javascript:void(0)" onclick="copyToClipBoard('{{ntitle}}','{{nurl}}')"><span class="content-share">分享</span></a>
        </div>
    </li>
</script>
<script type="text/template" id="page-box">
    <li><a href="javascript:void(0)" onclick="jumpPage('{{pageNum}}')">{{pageNum}}</a></li>
</script>
</html>
