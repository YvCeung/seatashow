package com.zy.common.api.service;


/**
 * (OrderTbl)表服务接口
 *
 * @author xiaoyuer
 * @since 2024-10-23 22:48:18
 */
public interface OrderTblService {

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
