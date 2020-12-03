package com.hnjdzy.service;

import net.sf.json.JSONArray;

public interface NewsService {
    /**
    * 通过新闻id获取新闻的评论，以JSON形式返回
    *
     * @param nid 新闻id
    * @return: net.sf.json.JSONArray
    * @Author: BloodArea
    * @Date: 2020-11-29 14:07:36
    */
    JSONArray getNewsCommentsToJSON(String nid);
}
