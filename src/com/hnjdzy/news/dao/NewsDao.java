package com.hnjdzy.news.dao;

import java.sql.SQLException;
import java.util.List;

import com.hnjdzy.news.entity.Comment;
import com.hnjdzy.news.entity.News;

public interface NewsDao {
    /**
     * 查询所有新闻
     *
     * @param
     * @return: java.util.List<com.hnjdzy.news.entity.News>
     * @Author: BloodArea
     * @Date: 2020-11-29 14:11:30
     */
    List<News> findAllNews() throws SQLException;

    /**
     * 查询所有新闻的条数
     *
     * @param
     * @return: int
     * @Author: BloodArea
     * @Date: 2020-11-29 14:11:52
     */
    int findAllNewsCount() throws SQLException;

    List<News> findNewsByCondition(String keyWords) throws SQLException;

    /**
    * 查询某主题下的某页的新闻
    *
     * @param ntid 主题id
     * @param currpage 页码
     * @param pageSize 单页记录数
    * @return: java.util.List<com.hnjdzy.news.entity.News>
    * @Author: BloodArea
    * @Date: 2020-11-29 14:12:51
    */
    List<News> findNewsByTopicPage(int ntid, int currpage, int pageSize) throws SQLException;

    /**
    * 查询某主题下的新闻条数
    *
     * @param ntid 主题id
    * @return: int
    * @Author: BloodArea
    * @Date: 2020-11-29 14:12:11
    */
    int findNewsByTopicCount(int ntid) throws SQLException;

    /**
    * 通过新闻id查询新闻
    *
     * @param nid 新闻Id
    * @return: com.hnjdzy.news.entity.News
    * @Author: BloodArea
    * @Date: 2020-11-29 14:13:31
    */
    News findNews(int nid) throws SQLException;

    /**
    * 添加新闻
    *
     * @param news 新闻对象
    * @return: int
    * @Author: BloodArea
    * @Date: 2020-11-29 14:13:47
    */
    int addNews(News news) throws SQLException;

    /**
    *  修改新闻
    *
     * @param news 新闻对象
    * @return: int
    * @Author: BloodArea
    * @Date: 2020-11-29 14:27:58
    */
    int setNews(News news) throws SQLException;

    /**
    * 删除新闻
    *
     * @param nid 新闻id
    * @return: int
    * @Author: BloodArea
    * @Date: 2020-11-29 14:28:26
    */
    int delNews(int nid) throws SQLException;

    /**
    * 获取指定新闻下评论条数
    *
     * @param nid 新闻id
    * @return: int
    * @Author: BloodArea
    * @Date: 2020-11-29 14:30:06
    */
    int findNewsCommentsCount(int nid) throws SQLException;

}
