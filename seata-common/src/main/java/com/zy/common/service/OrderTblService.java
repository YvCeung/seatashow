package com.zy.common.service;


import com.zy.common.bo.OrderTblDO;

/**
 * (OrderTbl)表服务接口
 *
 * @author xiaoyuer
 * @since 2024-10-23 22:48:18
 */
public interface OrderTblService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderTblDO queryById(Integer id);


    /**
     * 新增数据
     *
     * @param orderTblDO 实例对象
     * @return 实例对象
     */
    OrderTblDO createOrder(OrderTblDO orderTblDO);

    OrderTblDO createOrderWithError(OrderTblDO orderTblDO);

    /**
     * 修改数据
     *
     * @param orderTblDO 实例对象
     * @return 实例对象
     */
    OrderTblDO update(OrderTblDO orderTblDO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
