package com.zy.order.service.impl;

import com.zy.order.entity.OrderTbl;
import com.zy.order.dao.OrderTblDao;
import com.zy.order.service.OrderTblService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * (OrderTbl)表服务实现类
 *
 * @author makejava
 * @since 2024-10-22 23:18:44
 */
@Service("orderTblService")
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
    public OrderTbl queryById(Integer id) {
        return this.orderTblDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param orderTbl 实例对象
     * @return 实例对象
     */
    @Override
    public OrderTbl insert(OrderTbl orderTbl) {
        this.orderTblDao.insert(orderTbl);
        return orderTbl;
    }

    /**
     * 修改数据
     *
     * @param orderTbl 实例对象
     * @return 实例对象
     */
    @Override
    public OrderTbl update(OrderTbl orderTbl) {
        this.orderTblDao.update(orderTbl);
        return this.queryById(orderTbl.getId());
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
