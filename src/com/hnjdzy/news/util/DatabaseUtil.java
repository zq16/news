package com.hnjdzy.news.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 数据库连接与关闭工具类。
 * 
 * @author 北大青鸟
 */
public class DatabaseUtil {
    private static String driver = ConfigManager.getProperty("driver");// 数据库驱动字符串
    private static String url = ConfigManager.getProperty("url");// 连接URL字符串
    private static String user = ConfigManager.getProperty("user"); // 数据库用户名
    private static String password = ConfigManager.getProperty("password"); // 用户密码
    private static DruidDataSource dds = new DruidDataSource(); //druid连接池

    static {
		dds.setUrl(url);
		dds.setDriverClassName(driver); //这个可以缺省的，会根据url自动识别
        dds.setUsername(user);
        dds.setPassword(password);
        dds.setInitialSize(10);  //初始连接数，默认0
        dds.setMaxActive(1000);  //最大连接数，默认8
        dds.setMinIdle(10);  //最小闲置数
        dds.setMaxWait(2000);  //获取连接的最大等待时间，单位毫秒
        dds.setPoolPreparedStatements(true); //缓存PreparedStatement，默认false
        dds.setMaxOpenPreparedStatements(20);//缓存PreparedStatement的最大数量，默认-1（不缓存）。大于0时会自动开启缓存PreparedStatement，所以可以省略上一句代码
    }

    /**
     * 获取数据库连接对象。
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException {
        // 获取连接并捕获异常
        Connection conn = null;
        try {
        	conn = dds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return conn;// 返回连接对象
    }

    /**
     * 关闭数据库连接。
     * 
     * @param conn
     *            数据库连接
     * @param stmt
     *            Statement对象
     * @param rs
     *            结果集
     */
    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        // 若结果集对象不为空，则关闭
        try {
            if (rs != null && !rs.isClosed())
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 若Statement对象不为空，则关闭
        try {
            if (stmt != null && !stmt.isClosed())
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 若数据库连接对象不为空，则关闭
        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
