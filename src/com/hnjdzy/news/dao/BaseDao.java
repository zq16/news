package com.hnjdzy.news.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.hnjdzy.news.util.DatabaseUtil;

/**
 * 执行数据库操作的工具类
 * 
 * @author 北大青鸟
 */
public class BaseDao {
	
	public Connection conn = null;
	
	public PreparedStatement ps = null;
    
    public BaseDao() {
	}

	/**
     * 增、删、改操作
     * 
     * @param sql
     *            sql语句
     * @param prams
     *            参数数组
     * @return 执行结果
     * @throws SQLException 
     */
    protected int executeUpdate(String sql, Object... params) throws SQLException {
    	conn = DatabaseUtil.getConnection();
        int result = 0;
        try {
            ps = conn.prepareStatement(sql);
            if(params != null) {
            	for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            DatabaseUtil.closeAll(conn, ps, null);
        }
        return result;
    }

    /**
     * 查询操作
     * 
     * @param sql
     *            sql语句
     * @param params
     *            参数数组
     * @return 查询结果�?
     * @throws SQLException 
     */
    protected ResultSet executeQuery(String sql, Object... params) throws SQLException {
    	conn = DatabaseUtil.getConnection();
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            if(params != null) {
            	for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return rs;
    }
}
