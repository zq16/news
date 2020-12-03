package com.hnjdzy.news.dao;

import com.hnjdzy.news.entity.News;
import com.hnjdzy.news.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UsersDao {
    /**
    * 查询所有用户
    *
     * @param
    * @return: java.util.List<com.hnjdzy.news.entity.User>
    * @Author: BloodArea
    * @Date: 2020-11-29 17:11:18
    */
    List<User> findAllUser() throws SQLException;

    /**
    * 查询所有用户个数
    *
     * @param
    * @return: int
    * @Author: BloodArea
    * @Date: 2020-11-29 17:11:34
    */
    int findAllUserCount() throws SQLException;

    /**
    * 通过用户id查询用户
    *
     * @param uid 用户id
    * @return: com.hnjdzy.news.entity.User
    * @Author: BloodArea
    * @Date: 2020-11-29 17:12:38
    */
    User findUser(int uid) throws SQLException;

    /** 
    * 添加用户
    *
     * @param user 用户对象
    * @return: int 
    * @Author: BloodArea 
    * @Date: 2020-11-29 17:19:11 
    */
    int addUser(User user) throws SQLException;

    /**
    * 修改用户
    *
     * @param user 用户对象
    * @return: int
    * @Author: BloodArea
    * @Date: 2020-11-29 17:22:51
    */
    int setUser(User user) throws SQLException;

    /**
    * 删除指定用户
    *
     * @param uid 用户Id
    * @return: int
    * @Author: BloodArea
    * @Date: 2020-11-29 17:23:16
    */
    int delUser(int uid) throws SQLException;
}
