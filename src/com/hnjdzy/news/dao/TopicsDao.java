package com.hnjdzy.news.dao;

import java.sql.SQLException;
import java.util.List;

import com.hnjdzy.news.entity.Topic;

public interface TopicsDao {
	/**
	* 查询所有主题
	*
	 * @param
	* @return: java.util.List<com.hnjdzy.news.entity.Topic>
	* @Author: BloodArea
	* @Date: 2020-11-29 16:47:52
	*/
	List<Topic> findAllTopics() throws SQLException;

	/**
	* 查询所有主题个数
	*
	 * @param
	* @return: int
	* @Author: BloodArea
	* @Date: 2020-11-29 16:53:17
	*/
	int findAllTopicsCount() throws SQLException;

	/**
	* 查询指定主题
	*
	 * @param tid 主题id
	* @return: com.hnjdzy.news.entity.Topic
	* @Author: BloodArea
	* @Date: 2020-11-29 16:48:09
	*/
	Topic findTopic(int tid) throws SQLException;

	/**
	* 添加主题
	*
	 * @param topic 主题对象
	* @return: int
	* @Author: BloodArea
	* @Date: 2020-11-29 16:48:20
	*/
	int addTopic(Topic topic) throws SQLException;

	/**
	* 修改主题
	*
	 * @param topic 主题对象
	* @return: int
	* @Author: BloodArea
	* @Date: 2020-11-29 16:48:35
	*/
	int setTopic(Topic topic) throws SQLException;

	/**
	* 删除主题
	*
	 * @param tid 主题id
	* @return: int
	* @Author: BloodArea
	* @Date: 2020-11-29 16:48:59
	*/
	int delTopic(int tid) throws SQLException;
}
