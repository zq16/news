package com.hnjdzy.news.dao.impl;

import com.hnjdzy.news.dao.BaseDao;
import com.hnjdzy.news.dao.UsersDao;
import com.hnjdzy.news.entity.News;
import com.hnjdzy.news.entity.User;
import com.hnjdzy.news.util.DatabaseUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl extends BaseDao implements UsersDao {
    @Override
    public List<User> findAllUser() throws SQLException {
        List<User> userList = new ArrayList<>();
        String sql = "select * from news_users";
        ResultSet rs = null;
        try {
            rs = executeQuery(sql, null);
            while (rs.next()) {
                User u = new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setUpwd(rs.getString("upwd"));
                userList.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.closeAll(conn, ps, rs);
        }
        return userList;
    }

    @Override
    public int findAllUserCount() throws SQLException {
        String sql = "select count(*) from news_users";
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
    public User findUser(int uid) throws SQLException {
        return null;
    }

    @Override
    public int addUser(User user) throws SQLException {
        return 0;
    }

    @Override
    public int setUser(User user) throws SQLException {
        return 0;
    }

    @Override
    public int delUser(int uid) throws SQLException {
        return 0;
    }
}
