package com.zy.seata.storage.impl;

import com.zy.common.api.bo.StockTblDO;
import com.zy.common.api.service.StockTblService;
import com.zy.seata.storage.dao.StockTblDao;
import org.apache.dubbo.config.annotation.DubboService;


import org.springframework.beans.factory.annotation.Autowired;

/**
 * (StockTbl)表服务实现类
 *
 * @author xiaoyuer
 * @since 2024-10-23 22:54:06
 */
@DubboService
public class StockTblServiceImpl implements StockTblService {

    @Autowired
    private StockTblDao stockTblDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StockTblDO queryById(Integer id) {
        return this.stockTblDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param stockTblDO 实例对象
     * @return 实例对象
     */
    @Override
    public StockTblDO insert(StockTblDO stockTblDO) {
        this.stockTblDao.insert(stockTblDO);
        return stockTblDO;
    }

    /**
     * 修改数据
     *
     * @param stockTblDO 实例对象
     * @return 实例对象
     */
    @Override
    public StockTblDO update(StockTblDO stockTblDO) {
        this.stockTblDao.update(stockTblDO);
        return this.queryById(stockTblDO.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.stockTblDao.deleteById(id) > 0;
    }

    @Override
    public void reduceStock(Integer id, Integer number) {
        StockTblDO stockTblDO = stockTblDao.queryById(id);
        if(stockTblDO.getCount() < number){
            //模拟异常
            int res = 1 / 0;
        }
        stockTblDao.reduceStock(id,number);
    }
}
