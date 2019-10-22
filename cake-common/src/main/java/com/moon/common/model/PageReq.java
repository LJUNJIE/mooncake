package com.moon.common.model;

public class PageReq implements java.io.Serializable{

    private Integer pageNum; // 页码

    private Integer pageSize; // 页数

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
