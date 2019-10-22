package com.moon.order.dto;


import com.moon.product.dto.TbProductInfoDto;

import java.util.List;

public class TbOrderDto implements java.io.Serializable {

    private Long orderId;

    private List<TbProductInfoDto> products;

    private Integer productNum;

    private String cusId;

    private String cusName;

    private String cusAddress;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }


    public List<TbProductInfoDto> getProducts() {
        return products;
    }

    public void setProducts(List<TbProductInfoDto> products) {
        this.products = products;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }
}
