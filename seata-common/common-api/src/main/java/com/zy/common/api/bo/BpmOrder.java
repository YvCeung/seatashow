package com.zy.common.api.bo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Description
 * @Author zy
 * @Date 2025/6/23 21:13
 **/
@Data
public class BpmOrder {
    private Long id;
    private String code;
    private String name;
    private String createdBy;
    private Timestamp createdDate;
    private String lastModifiedBy;
    private Timestamp lastModifiedDate;
    private String tenantId;
    private String sort;
    private String createdByName;
    private String lastModifiedByName;
}
