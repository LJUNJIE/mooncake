package com.moon.common.model;

import io.swagger.models.auth.In;

import java.util.List;
import java.util.Map;

/**
 * 统一返回接口封装类
 * @param <T>
 */
public class ResultData<T> implements java.io.Serializable {

    private static final long serialVersionUID = -4185151304730685014L;

    // 返回编码
    private Integer code;
    // 返回数据
    private Object data;
    // 返回数据集
    private List<Map<String,Object>> dataList;
    // 返回异常信息
    private String msg;

    public Integer isCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ResultData(){

    }

    public ResultData (Integer code,Object data) {
        this.code  = code;
        this.data = data;
    }

    public ResultData (Integer code,String msg) {
        this.code  = code;
        this.msg = msg;
    }


    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<Map<String, Object>> getDataList() {
        return dataList;
    }

    public void setDataList(List<Map<String, Object>> dataList) {
        this.dataList = dataList;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
