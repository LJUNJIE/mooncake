package com.moon.product.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xjl
 * @since 2019-10-15
 */
@TableName("tb_product_info")
public class TbProductInfo extends Model<TbProductInfo> {

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
    protected Serializable pkVal() {
        return null;
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
