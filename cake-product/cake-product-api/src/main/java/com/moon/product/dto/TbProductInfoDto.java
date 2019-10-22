package com.moon.product.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class TbProductInfoDto implements java.io.Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private double price;

    private String desc;

    private int num;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "TbProductInfo{" +
                "id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", desc=" + desc +
                ", num=" + num +
                "}";
    }
}
