package com.moon.systemapi.entity;

import io.swagger.annotations.ApiModel;

@ApiModel(value="PolClaim对象",description="保单对象PolClaim")
public class ClT4PolClaim implements java.io.Serializable{

    private String polno;

    public String getPolno() {
        return polno;
    }

    public void setPolno(String polno) {
        this.polno = polno;
    }
}
