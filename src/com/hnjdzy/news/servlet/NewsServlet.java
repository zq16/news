package com.hnjdzy.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnjdzy.news.dao.NewsDao;
import com.hnjdzy.news.dao.TopicsDao;
import com.hnjdzy.news.dao.impl.CommentsDaoImpl;
import com.hnjdzy.news.dao.impl.NewsDaoImpl;
import com.hnjdzy.news.dao.impl.TopicsDaoImpl;
import com.hnjdzy.news.entity.Comment;
import com.hnjdzy.news.entity.News;
import com.hnjdzy.news.entity.NewsPage;
import com.hnjdzy.news.util.CommonUtil;

public class NewsServlet extends HttpServlet {

    public NewsServlet() {
        System.out.println("NewsServlet创建");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("NewsServlet初始化");
    }

    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
        System.out.println("NewsServlet服务中");
        super.service(arg0, arg1);
    }

    @Override
    public void destroy() {
        System.out.println("NewsServlet销毁");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewsDao ndi = new NewsDaoImpl();
        TopicsDao tdi = new TopicsDaoImpl();
        PrintWriter out = response.getWriter();
        //获取参数
        String func = request.getParameter("func");
        if ("delNews".equals(func)) {    //删除指定新闻
            try {
                ndi.delNews(Integer.parseInt(request.getParameter("nid")));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //弹出提示窗口
            out.print("<script type=\"text/javascript\">");
            out.print("alert(\"删除成功!，点击确认返回全部新闻页面\");");
            out.print("location.href=\"NewsServlet?func=allNews&currpage=1\";");
            out.print("</script>");
        } else if ("setNews".equals(func)) {    //设置指定新闻
            if (request.getParameter("nid") != null) {
                int nid = Integer.parseInt(request.getParameter("nid"));
                News n = null;
                try {
                    n = ndi.findNews(nid);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.setAttribute("news", n);
                try {
                    request.setAttribute("topicList", tdi.findAllTopics());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.getRequestDispatcher("SetNews.jsp").forward(request, response);
            }
        } else if ("showNews".equals(func)) {    //展示新闻
            try {
                request.setAttribute("news", ndi.findNews(Integer.parseInt(request.getParameter("nid"))));
            } catch (NumberFormatException | SQLException e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("show-news.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewsDao ndi = new NewsDaoImpl();
        CommentsDaoImpl cdi = new CommentsDaoImpl();
        PrintWriter out = response.getWriter();
        //获取功能参数
        String func = request.getParameter("func");
        if ("addNews".equals(func)) {    //添加新闻
            //设置对象数据
            News news = new News();
            news.setNtid(Integer.parseInt(request.getParameter("ntid")));
            news.setNtitle(request.getParameter("ntitle"));
            news.setNauthor(request.getParameter("nauthor"));
            news.setNcreatedate(new Date());
            news.setNpicpath(request.getParameter("npicPath"));
            news.setNcontent(request.getParameter("ncontent"));
            news.setNmodifydate(new Date());
            news.setNsummary(request.getParameter("nsummary"));
            //向数据库添加数据
            try {
                ndi.addNews(news);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //弹出提示窗口
            out.print("<script type=\"text/javascript\">");
            out.print("alert(\"添加成功!，点击确认返回全部新闻页面\");");
            out.print("location.href=\"NewsServlet?func=allNews&currpage=1\";");
            out.print("</script>");
        } else if ("delNews".equals(func)) {    //删除多个新闻
            for (String nid : request.getParameterValues("nids")) {
                try {
                    ndi.delNews(Integer.parseInt(nid));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            //弹出提示窗口
            out.print("<script type=\"text/javascript\">");
            out.print("alert(\"删除成功!，点击确认返回全部新闻页面\");");
            out.print("location.href=\"NewsServlet?func=allNews&currpage=1\";");
            out.print("</script>");
        } else if ("setNews".equals(func)) {    //修改新闻
            News news = new News();
            news.setNid(Integer.valueOf(request.getParameter("nid")));
            news.setNtid(Integer.valueOf(request.getParameter("ntid")));
            news.setNtitle(request.getParameter("ntitle"));
            news.setNauthor(request.getParameter("nauthor"));
            Calendar c = Calendar.getInstance();
            try {
                news.setNcreatedate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ncreateDate")));
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            news.setNpicpath(request.getParameter("npicPath"));
            news.setNcontent(request.getParameter("ncontent"));
            news.setNmodifydate(new Date());
            news.setNsummary(request.getParameter("nsummary"));
            try {
                ndi.setNews(news);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //弹出提示窗口
            out.print("<script type=\"text/javascript\">");
            out.print("alert(\"修改成功!，点击确认返回全部新闻页面\");");
//            out.print("location.href=\"NewsServlet?func=allNews&currpage=1\";");
            out.print("</script>");
        }else if("searchNews".equals(func)){
            String keyWords = request.getParameter("keyWords");
            String result = null;
            try {
                result = CommonUtil.convertListToJSONArray(ndi.findNewsByCondition(keyWords)).toString();
            } catch (SQLException | IllegalAccessException throwables) {
                throwables.printStackTrace();
            }
            request.setAttribute("result",result);
            request.getRequestDispatcher("manager/result-news.jsp").forward(request,response);
        }else if ("page".equals(func)) {    //新闻换页功能
            int currTopic = Integer.parseInt(request.getParameter("currTopic"));
            int pageNum = Integer.parseInt(request.getParameter("pageNum"));
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            String result = null;
            try {
                result = CommonUtil.convertBeanToJSONObject(new NewsPage(currTopic, pageNum, pageSize)).toString();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            //返回该页的json数据
            out.append(result);
        } else if ("submitComment".equals(func)) {    //提交评论
            int cnid = Integer.parseInt(request.getParameter("cnid"));
            String ccontent = request.getParameter("ccontent");
            Date cdate = new Date();
            String cip = request.getParameter("cip");
            String cauthor = request.getParameter("cauthor");
            Comment c = new Comment();
            c.setCnid(cnid);
            c.setCcontent(ccontent);
            c.setCdate(cdate);
            c.setCip(cip);
            c.setCauthor(cauthor);
            c.setCthumb(0);
            try {
                cdi.addComment(c);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            String result = null;
            try {
                result = CommonUtil.convertBeanToJSONObject(c).toString();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            out.append(result);

        } else if ("showComments".equals(func)) {    //显示该新闻的所有评论
            int nid = Integer.parseInt(request.getParameter("nid"));
            String result = null;
            try {
                result = CommonUtil.convertListToJSONArray(cdi.findCommentsByNid(nid)).toString();
            } catch (IllegalAccessException | SQLException e) {
                e.printStackTrace();
            }
            //返回该页的json数据
            out.append(result);
        }
    }

}
