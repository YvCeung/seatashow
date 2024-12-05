package com.zy.common.seataclient.storage.dao;

import com.zy.common.api.bo.StockTblDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * (StockTbl)表数据库访问层
 *
 * @author xiaoyuer
 * @since 2024-10-23 22:54:04
 */
public interface StockTblDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StockTblDO queryById(Integer id);

    /**
     * 统计总行数
     *
     * @param stockTblDO 查询条件
     * @return 总行数
     */
    long count(StockTblDO stockTblDO);

    /**
     * 新增数据
     *
     * @param stockTblDO 实例对象
     * @return 影响行数
     */
    int insert(StockTblDO stockTblDO);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<StockTbl> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<StockTblDO> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<StockTblDO> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<StockTblDO> entities);

    /**
     * 修改数据
     *
     * @param stockTblDO 实例对象
     * @return 影响行数
     */
    int update(StockTblDO stockTblDO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    void reduceStock(Integer id, Integer quantity);

    void addStock(Integer id, Integer quantity);
}

