package com.zy.common.bo;

import java.io.Serializable;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author xiaoyuer
 * @since 2024-10-23 22:48:17
 */

/**
 * (OrderTbl)实体类
 *
 * @author makejava
 * @since 2024-10-23 22:48:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderTblDO implements Serializable {
    private static final long serialVersionUID = -48721227012603759L;

    private Integer id;

    private String userId;

    private String commodityCode;

    private Integer count;

    private Integer money;


}

