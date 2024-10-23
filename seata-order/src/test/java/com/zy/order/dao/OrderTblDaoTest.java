package com.zy.order.dao;

import com.zy.common.bo.OrderTblDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description
 * @Author zy
 * @Date 2024/10/22 23:28
 **/
public class OrderTblDaoTest extends OrderBaseTest {

    @Autowired
    private OrderTblDao orderTblDao;
    @Test
    public void test11(){
        OrderTblDO orderTblDO = orderTblDao.queryById(1);
        System.out.println(orderTblDO.getUserId());
    }
}
