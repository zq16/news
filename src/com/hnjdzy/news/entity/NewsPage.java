package com.hnjdzy.news.entity;

import com.hnjdzy.news.dao.impl.NewsDaoImpl;
import com.hnjdzy.news.util.CommonUtil;
import net.sf.json.JSONArray;

import java.sql.SQLException;

public class NewsPage {
    private int currPage;
    private int pageSize;
    private JSONArray pageList;
    private int totalSize;
    private int totalPage;

    public NewsPage() {
    }

    public NewsPage(int ntid, int currPage, int pageSize) {
        try {
            this.currPage = currPage;
            this.pageSize = pageSize;
            setPageList(ntid, this.currPage, this.pageSize);
            this.totalSize = new NewsDaoImpl().findNewsByTopicCount(ntid);
            setTotalPage(this.totalSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public JSONArray getPageList() {
        return pageList;
    }

    public void setPageList(int ntid, int currPage, int pageSize) {
        try {
            this.pageList = CommonUtil.convertListToJSONArray(
                    new NewsDaoImpl().findNewsByTopicPage(ntid, (currPage - 1) * pageSize,
                            pageSize)
            );
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalSize) {
        if (totalSize % pageSize == 0) {
            totalPage = totalSize / pageSize;
        }
        if (totalSize % pageSize != 0) {
            totalPage = totalSize / pageSize + 1;
        }
    }

    @Override
    public String toString() {
        return "NewsPage [currPage=" + currPage + ", pageSize=" + pageSize + ", pageList=" + pageList + ", totalSize="
                + totalSize + ", totalPage=" + totalPage + "]";
    }

}
