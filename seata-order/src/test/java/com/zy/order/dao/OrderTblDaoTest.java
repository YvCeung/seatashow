package com.zy.order.dao;

import com.zy.order.entity.OrderTbl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description
 * @Author zy
 * @Date 2024/10/22 23:28
 **/
public class OrderTblDaoTest {

    @Autowired
    private OrderTblDao orderTblDao;
    @Test
    public void test11(){
        OrderTbl orderTbl = orderTblDao.queryById(1);
        System.out.println(orderTbl.getId());
    }
}