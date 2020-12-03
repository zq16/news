package com.hnjdzy.news.servlet;

import com.hnjdzy.news.dao.NewsDao;
import com.hnjdzy.news.dao.TopicsDao;
import com.hnjdzy.news.dao.impl.NewsDaoImpl;
import com.hnjdzy.news.dao.impl.TopicsDaoImpl;
import com.hnjdzy.news.entity.Topic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class TopicServlet extends HttpServlet {
    public TopicServlet() {
        System.out.println("TopicServlet创建");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("TopicServlet初始化");
    }

    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
        System.out.println("TopicServlet服务中");
        super.service(arg0, arg1);
    }

    @Override
    public void destroy() {
        System.out.println("TopicServlet销毁");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewsDao ndi = new NewsDaoImpl();
        TopicsDao tdi = new TopicsDaoImpl();
        PrintWriter out = response.getWriter();
        //获取参数
        String func = request.getParameter("func");
        if("addTopic".equals(func)){
            String tname = request.getParameter("tname");
            Topic t = new Topic();
            t.setTname(tname);
            try {
                tdi.addTopic(t);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
