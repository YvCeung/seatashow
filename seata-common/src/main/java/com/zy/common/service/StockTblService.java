package com.zy.common.service;


import com.zy.common.bo.StockTblDO;

/**
 * (StockTbl)表服务接口
 *
 * @author xiaoyuer
 * @since 2024-10-23 22:54:06
 */
public interface StockTblService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StockTblDO queryById(Integer id);


    /**
     * 新增数据
     *
     * @param stockTblDO 实例对象
     * @return 实例对象
     */
    StockTblDO insert(StockTblDO stockTblDO);

    /**
     * 修改数据
     *
     * @param stockTblDO 实例对象
     * @return 实例对象
     */
    StockTblDO update(StockTblDO stockTblDO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 扣减库存
     * @param id
     * @param number
     */
    void reduceStock(Integer id,Integer number);

}
