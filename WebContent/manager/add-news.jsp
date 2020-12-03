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
    <script src="../js/add-news.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
    <div id="content">
        <form action="" method="post" id="newsData">
            <table border="0" cellspacing="" cellpadding="">
                <tr>
                    <td><span>新闻标题：</span></td>
                    <td><input type="text" name="ntitle" /></td>
                </tr>
                <tr>
                    <td><span>新闻主题：</span></td>
                    <td>
                        <select name="ntid">
                            <option value="1">国内</option>
                            <option value="2" >国内</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><span>新闻作者：</span></td>
                    <td><input type="text" name="nauthor" /></td>
                </tr>
                <tr>
                    <td><span>新闻描述：</span></td>
                    <td><input class="nsummary" type="text" name="nsummary" /></td>
                </tr>
                <tr>
                    <td><span>新闻内容：</span></td>
                    <td>
                        <input type="hidden" id="ncontent" name="ncontent" />
                        <textarea></textarea>
                    </td>
                </tr>
                <tr>
                    <td><span>图片地址：</span></td>
                    <td>
                        <input class="npicpath" type="text" name="npicpath" />
                    </td>
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
