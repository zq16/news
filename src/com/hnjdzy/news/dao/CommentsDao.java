package com.hnjdzy.news.dao;

import com.hnjdzy.news.entity.Comment;
import com.hnjdzy.news.entity.News;

import java.sql.SQLException;
import java.util.List;

public interface CommentsDao {
    /**
     * 通过新闻id获取该新闻下的评论
     *
     * @param nid 新闻id
     * @return: java.util.List<com.hnjdzy.news.entity.Comment>
     * @Author: BloodArea
     * @Date: 2020-11-29 14:09:08
     */
    List<Comment> findCommentsByNid(int nid) throws SQLException;

    /**
    * 添加评论
    *
     * @param comment 评论对象
    * @return: int
    * @Author: BloodArea
    * @Date: 2020-11-29 14:10:00
    */
    int addComment(Comment comment) throws SQLException;

    /**
    * 通过评论id删除评论
    *
     * @param cid 评论id
    * @return: int
    * @Author: BloodArea
    * @Date: 2020-11-29 14:10:17
    */
    int delComment(int cid) throws SQLException;

    /**
    * 通过新闻id删除评论
    *
     * @param nid 新闻id
    * @return: int
    * @Author: BloodArea
    * @Date: 2020-11-29 14:10:52
    */
    int delCommentsByNid(int nid) throws SQLException;
}
