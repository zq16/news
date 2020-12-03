package com.hnjdzy.service.impl;

import com.hnjdzy.news.dao.impl.CommentsDaoImpl;
import com.hnjdzy.news.util.CommonUtil;
import com.hnjdzy.service.NewsService;
import net.sf.json.JSONArray;

import java.sql.SQLException;

public class NewsServiceImpl implements NewsService {
    @Override
    public JSONArray getNewsCommentsToJSON(String nid) {
        try {
            return CommonUtil.convertListToJSONArray(new CommentsDaoImpl().findCommentsByNid(Integer.parseInt(nid)));
        } catch (SQLException | IllegalAccessException throwables) {
            throwables.printStackTrace();
        }
        return new JSONArray();
    }
}
