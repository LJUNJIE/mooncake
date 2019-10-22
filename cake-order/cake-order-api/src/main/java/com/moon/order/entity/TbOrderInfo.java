package com.moon.order.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
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
@TableName("tb_order_info")
public class TbOrderInfo extends Model<TbOrderInfo> {

    private static final long serialVersionUID = 1L;

    private Long id;

    @TableField("cus_id")
    private String cusId;

    @TableField("cus_phone")
    private double cusPhone;

    @TableField("cus_address")
    private String cusAddress;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    @TableField("sum_price")
    private Double sumPrice;

    @TableField("pay_status")
    private String payStatus;

    @TableField("ord_status")
    private String ordStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }
    public double getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(double cusPhone) {
        this.cusPhone = cusPhone;
    }
    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(double sumPrice) {
        this.sumPrice = sumPrice;
    }
    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }
    public String getOrdStatus() {
        return ordStatus;
    }

    public void setOrdStatus(String ordStatus) {
        this.ordStatus = ordStatus;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "TbOrderInfo{" +
        "id=" + id +
        ", cusId=" + cusId +
        ", cusPhone=" + cusPhone +
        ", cusAddress=" + cusAddress +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", sumPrice=" + sumPrice +
        ", payStatus=" + payStatus +
        ", ordStatus=" + ordStatus +
        "}";
    }
}
