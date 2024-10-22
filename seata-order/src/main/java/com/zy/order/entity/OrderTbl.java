package com.zy.order.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (OrderTbl)实体类
 *
 * @author makejava
 * @since 2024-10-22 23:18:39
 */
@Data
public class OrderTbl implements Serializable {
    private static final long serialVersionUID = -73360369322587052L;

    private Integer id;

    private String userId;

    private String commodityCode;

    private Integer count;

    private Integer money;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

}

