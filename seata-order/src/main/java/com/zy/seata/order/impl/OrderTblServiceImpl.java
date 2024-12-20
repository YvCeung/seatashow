package com.zy.seata.order.impl;

import com.zy.common.api.bo.OrderTblDO;
import com.zy.common.api.service.OrderTblService;
import com.zy.seata.order.dao.OrderTblDao;
import org.apache.dubbo.config.annotation.DubboService;


import org.springframework.beans.factory.annotation.Autowired;

/**
 * (OrderTbl)表服务实现类
 *
 * @author xiaoyuer
 * @since 2024-10-23 22:48:18
 */
@DubboService
public class OrderTblServiceImpl implements OrderTblService {

    @Autowired
    private OrderTblDao orderTblDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OrderTblDO queryById(Integer id) {
        return this.orderTblDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param orderTblDO 实例对象
     * @return 实例对象
     */
    @Override
    public OrderTblDO createOrder(OrderTblDO orderTblDO) {
        this.orderTblDao.insert(orderTblDO);
        return orderTblDO;
    }

    @Override
    public OrderTblDO createOrderWithError(OrderTblDO orderTblDO) {
        int res = 1 / 0;
        this.orderTblDao.insert(orderTblDO);
        return orderTblDO;
    }

    /**
     * 修改数据
     *
     * @param orderTblDO 实例对象
     * @return 实例对象
     */
    @Override
    public OrderTblDO update(OrderTblDO orderTblDO) {
        this.orderTblDao.update(orderTblDO);
        return this.queryById(orderTblDO.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.orderTblDao.deleteById(id) > 0;
    }
}
