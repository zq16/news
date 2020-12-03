package com.hnjdzy.news.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hnjdzy.news.dao.BaseDao;
import com.hnjdzy.news.dao.NewsDao;
import com.hnjdzy.news.entity.Comment;
import com.hnjdzy.news.entity.News;
import com.hnjdzy.news.util.DatabaseUtil;

public class NewsDaoImpl extends BaseDao implements NewsDao {

    @Override
    public List<News> findAllNews() {
        List<News> newsList = new ArrayList<>();
        String sql = "select * from news order by nmodifyDate desc";
        ResultSet rs = null;
        try {
            rs = executeQuery(sql, null);
            while (rs.next()) {
                News n = new News();
                n.setNid(rs.getInt("nid"));
                n.setNtid(rs.getInt("ntid"));
                n.setNtitle(rs.getString("ntitle"));
                n.setNauthor(rs.getString("nauthor"));
                n.setNcreatedate(rs.getDate("ncreateDate"));
                n.setNpicpath(rs.getString("npicPath"));
                n.setNcontent(rs.getString("ncontent"));
                n.setNmodifydate(rs.getDate("nmodifyDate"));
                n.setNsummary(rs.getString("nsummary"));
                n.setNcommentcount(findNewsCommentsCount(n.getNid()));
                newsList.add(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.closeAll(conn, ps, rs);
        }
        return newsList;
    }

    @Override
    public int findAllNewsCount() throws SQLException {
        String sql = "select count(*) from news";
        ResultSet rs = null;
        int count = 0;
        try {
            rs = executeQuery(sql);
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            DatabaseUtil.closeAll(conn, ps, rs);
        }
        return count;
    }

    @Override
    public List<News> findNewsByCondition(String keyWords) throws SQLException {
        List<News> newsList = new ArrayList<>();
        String sql = "select * from news where ntitle like ? or nsummary like ? or nauthor like ? or ncontent like ?";
        ResultSet rs = null;
        try {
            rs = executeQuery(sql, "%"+ keyWords +"%","%"+ keyWords+"%","%"+ keyWords+"%","%"+ keyWords+"%");
            while (rs.next()) {
                News n = new News();
                n.setNid(rs.getInt("nid"));
                n.setNtid(rs.getInt("ntid"));
                n.setNtitle(rs.getString("ntitle"));
                n.setNauthor(rs.getString("nauthor"));
                n.setNcreatedate(rs.getDate("ncreateDate"));
                n.setNpicpath(rs.getString("npicPath"));
                n.setNcontent(rs.getString("ncontent"));
                n.setNmodifydate(rs.getDate("nmodifyDate"));
                n.setNsummary(rs.getString("nsummary"));
                n.setNcommentcount(findNewsCommentsCount(n.getNid()));
                newsList.add(n);
            }
        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            DatabaseUtil.closeAll(conn, ps, rs);
        }
        return newsList;
    }

    @Override
    public List<News> findNewsByTopicPage(int ntid, int currpage, int pageSize) {
        List<News> newsList = new ArrayList<>();
        String sql = "select * from news where ntid = ? order by nmodifyDate desc limit ?,?";
        ResultSet rs = null;
        try {
            rs = executeQuery(sql, ntid, currpage, pageSize);
            while (rs.next()) {
                News n = new News();
                n.setNid(rs.getInt("nid"));
                n.setNtid(rs.getInt("ntid"));
                n.setNtitle(rs.getString("ntitle"));
                n.setNauthor(rs.getString("nauthor"));
                n.setNcreatedate(rs.getDate("ncreateDate"));
                n.setNpicpath(rs.getString("npicPath"));
                n.setNcontent(rs.getString("ncontent"));
                n.setNmodifydate(rs.getDate("nmodifyDate"));
                n.setNsummary(rs.getString("nsummary"));
                n.setNcommentcount(findNewsCommentsCount(n.getNid()));
                newsList.add(n);
            }
        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            DatabaseUtil.closeAll(conn, ps, rs);
        }
        return newsList;
    }

    @Override
    public int findNewsByTopicCount(int ntid) throws SQLException {
        String sql = "select count(*) from news where ntid = ?";
        ResultSet rs = null;
        int count = 0;
        try {
            rs = executeQuery(sql, ntid);
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            DatabaseUtil.closeAll(conn, ps, rs);
        }
        return count;
    }

    @Override
    public News findNews(int nid) {
        String sql = "select * from news where nid = ?";
        ResultSet rs = null;
        News n = null;
        try {
            rs = executeQuery(sql, nid);
            n = new News();
            while (rs.next()) {
                n.setNid(rs.getInt("nid"));
                n.setNtid(rs.getInt("ntid"));
                n.setNtitle(rs.getString("ntitle"));
                n.setNauthor(rs.getString("nauthor"));
                n.setNcreatedate(rs.getDate("ncreateDate"));
                n.setNpicpath(rs.getString("npicPath"));
                n.setNcontent(rs.getString("ncontent"));
                n.setNmodifydate(rs.getDate("nmodifyDate"));
                n.setNsummary(rs.getString("nsummary"));
                n.setNcommentcount(findNewsCommentsCount(n.getNid()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.closeAll(conn, ps, rs);
        }
        return n;
    }

    @Override
    public int addNews(News news) throws SQLException {
        String sql = "insert into news(ntid,ntitle,nauthor,ncreateDate,npicPath,ncontent,nmodifyDate,nsummary) values(?,?,?,?,?,?,?,?)";
        return executeUpdate(sql, news.getNtid(), news.getNtitle(), news.getNauthor(), news.getNcreatedate(), news.getNpicpath(), news.getNcontent(), news.getNmodifydate(), news.getNsummary());
    }

    @Override
    public int setNews(News news) throws SQLException {
        String sql = "update news set ntid=?,ntitle=?,nauthor=?,ncreateDate=?,npicPath=?,ncontent=?,nmodifyDate=?,nsummary=? where nid = ?";
        return executeUpdate(sql, news.getNtid(), news.getNtitle(), news.getNauthor(), news.getNcreatedate(), news.getNpicpath(), news.getNcontent(), news.getNmodifydate(), news.getNsummary(), news.getNid());
    }

    @Override
    public int delNews(int nid) throws SQLException {
        String sql = "delete from news where nid = ?";
        return executeUpdate(sql, nid);
    }

    @Override
    public int findNewsCommentsCount(int nid) throws SQLException {
        String sql = "select count(*) from comments where cnid = ?";
        ResultSet rs = null;
        int count = 0;
        try {
            rs = executeQuery(sql, nid);
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            DatabaseUtil.closeAll(conn, ps, rs);
        }
        return count;
    }

}
