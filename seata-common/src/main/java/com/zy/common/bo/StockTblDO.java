package com.zy.common.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xiaoyuer
 * @since 2024-10-23 22:54:05
 */

/**
 * (StockTbl)实体类
 *
 * @author makejava
 * @since 2024-10-23 22:54:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockTblDO implements Serializable {
    private static final long serialVersionUID = 403297484073914712L;

    private Integer id;

    private String commodityCode;

    private Integer count;


}

