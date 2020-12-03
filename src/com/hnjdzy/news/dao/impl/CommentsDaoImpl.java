package com.hnjdzy.news.dao.impl;

import com.hnjdzy.news.dao.BaseDao;
import com.hnjdzy.news.dao.CommentsDao;
import com.hnjdzy.news.entity.Comment;
import com.hnjdzy.news.util.DatabaseUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentsDaoImpl extends BaseDao implements CommentsDao {
    @Override
    public List<Comment> findCommentsByNid(int nid) throws SQLException {
        List<Comment> comtList = new ArrayList<>();
        String sql = "select * from comments where cnid = ? order by cdate desc";
        ResultSet rs = null;
        try {
            rs = executeQuery(sql, nid);
            while(rs.next()) {
                Comment c = new Comment();
                c.setCid(rs.getInt("cid"));
                c.setCnid(rs.getInt("cnid"));
                c.setCcontent(rs.getString("ccontent"));
                c.setCdate(rs.getDate("cdate"));
                c.setCip(rs.getString("cip"));
                c.setCauthor(rs.getString("cauthor"));
                c.setCthumb(rs.getInt("cthumb"));
                comtList.add(c);
            }
        }catch (SQLException e) {
            // TODO: handle exception
        }finally {
            DatabaseUtil.closeAll(conn, ps, rs);
        }
        return comtList;
    }

    @Override
    public int addComment(Comment comment) throws SQLException {
        String sql = "insert into comments(cnid,ccontent,cdate,cip,cauthor,cthumb) values(?,?,?,?,?,?)";
        return executeUpdate(sql, comment.getCnid(),comment.getCcontent(),comment.getCdate(),comment.getCip(),comment.getCauthor(),comment.getCthumb());
    }

    @Override
    public int delComment(int cid) throws SQLException {
        String sql = "delete from comments where cid = ?";
        return executeUpdate(sql, cid);
    }

    @Override
    public int delCommentsByNid(int nid) throws SQLException {
        String sql = "delete from comments where cnid = ?";
        return executeUpdate(sql, nid);
    }
}
