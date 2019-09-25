package com.moon.systemapi.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="user对象",description="用户对象user")
public class User implements java.io.Serializable {
    @ApiModelProperty(value="userId",name="id",example="1")
    private String id;

    @ApiModelProperty(value="用户名",name="username",example="guoxi")
    private String userName;

    @ApiModelProperty(value="密码",name="password",example="123456")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
