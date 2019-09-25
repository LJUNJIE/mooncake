package com.moon.systemapi.vo;

import java.util.Map;

public class ResultBean {

	private boolean success;
	
	private String msg;
	
	private Map<String, Object> data;

	public ResultBean() {
		super();
	}

	public ResultBean(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}
	
	public ResultBean(boolean success, String msg, Map<String, Object> data) {
		super();
		this.success = success;
		this.msg = msg;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
