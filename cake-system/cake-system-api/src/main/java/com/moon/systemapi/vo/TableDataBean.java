package com.moon.systemapi.vo;

import java.util.List;

public class TableDataBean<T> {
	//表格数据
	private List<T> dataList;
	//当前页坐标
	private Integer currentPageNum;
	//总条数
	private Integer totalNum;
	//总页数
	private Integer totalPage;
	//每页条数
	private Integer pageSize;
	
	public TableDataBean() {
		super();
	}

	public TableDataBean(List<T> dataList, Integer currentPageNum, Integer totalNum, Integer totalPage,
			Integer pageSize) {
		super();
		this.dataList = dataList;
		this.currentPageNum = currentPageNum;
		this.totalNum = totalNum;
		this.totalPage = totalPage;
		this.pageSize = pageSize;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public Integer getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(Integer currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
