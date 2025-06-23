package com.zy.common.api.service;


import com.zy.common.api.bo.BpmStorage;

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
    BpmStorage queryById(Integer id);


    /**
     * 新增数据
     *
     * @param BpmStorage 实例对象
     * @return 实例对象
     */
    BpmStorage insert(BpmStorage BpmStorage);

    /**
     * 修改数据
     *
     * @param BpmStorage 实例对象
     * @return 实例对象
     */
    BpmStorage update(BpmStorage BpmStorage);

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
