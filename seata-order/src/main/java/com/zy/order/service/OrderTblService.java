package com.zy.order.service;

import com.zy.order.entity.OrderTbl;

/**
 * (OrderTbl)表服务接口
 *
 * @author makejava
 * @since 2024-10-22 23:18:44
 */
public interface OrderTblService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderTbl queryById(Integer id);

    /**
     * 新增数据
     *
     * @param orderTbl 实例对象
     * @return 实例对象
     */
    OrderTbl insert(OrderTbl orderTbl);

    /**
     * 修改数据
     *
     * @param orderTbl 实例对象
     * @return 实例对象
     */
    OrderTbl update(OrderTbl orderTbl);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
