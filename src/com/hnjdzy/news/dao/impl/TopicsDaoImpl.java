package com.hnjdzy.news.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hnjdzy.news.dao.BaseDao;
import com.hnjdzy.news.dao.TopicsDao;
import com.hnjdzy.news.entity.Topic;
import com.hnjdzy.news.util.DatabaseUtil;

public class TopicsDaoImpl extends BaseDao implements TopicsDao {

	@Override
	public List<Topic> findAllTopics() throws SQLException {
		List<Topic> topicList = new ArrayList<>();
		String sql = "select * from topic ";
		ResultSet rs = executeQuery(sql, null);
		while(rs.next()) {
			Topic t = new Topic();
			t.setTid(rs.getInt("tid"));
			t.setTname(rs.getString("tname"));
			topicList.add(t);
		}
		DatabaseUtil.closeAll(null, null, rs);
		return topicList;
	}

	@Override
	public int findAllTopicsCount() throws SQLException {
		String sql = "select count(*) from topic";
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
	public Topic findTopic(int tid) throws SQLException {
		List<Topic> topicList = new ArrayList<>();
		String sql = "select * from topic where tid = ?";
		ResultSet rs = executeQuery(sql, null);
		Topic t = new Topic();
		while(rs.next()) {
			t.setTid(rs.getInt("tid"));
			t.setTname(rs.getString("tname"));
			topicList.add(t);
		}
		DatabaseUtil.closeAll(null, null, rs);
		return t;
	}

	@Override
	public int addTopic(Topic topic) throws SQLException {
		String sql = "insert into topic(tname) values(?)";
		return executeUpdate(sql,topic.getTname());
	}

	@Override
	public int setTopic(Topic topic) throws SQLException {
		String sql = "update topic set tname=? where tid = ?";
		return executeUpdate(sql, topic.getTname(),topic.getTid());
	}

	@Override
	public int delTopic(int tid) throws SQLException {
		String sql = "delete from topic where tid = ?";
		return executeUpdate(sql, tid);
	}

}
