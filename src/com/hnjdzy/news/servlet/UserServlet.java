package com.hnjdzy.news.servlet;

import com.hnjdzy.news.dao.CommentsDao;
import com.hnjdzy.news.dao.impl.CommentsDaoImpl;
import com.hnjdzy.news.entity.Comment;
import com.hnjdzy.news.util.CommonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

public class UserServlet extends HttpServlet {

    public UserServlet() {
        System.out.println("CommentServlet创建");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("CommentServlet初始化");
    }

    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
        System.out.println("CommentServlet服务中");
        super.service(arg0, arg1);
    }

    @Override
    public void destroy() {
        System.out.println("CommentServlet销毁");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
