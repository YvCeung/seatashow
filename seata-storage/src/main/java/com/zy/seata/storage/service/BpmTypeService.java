package com.zy.seata.storage.service;

import com.zy.common.api.bo.BpmStorage;
import com.zy.seata.storage.dao.BpmStorageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author zy
 * @Date 2025/6/23 21:17
 **/
@Service
public class BpmTypeService {

    @Autowired
    private BpmStorageDAO bpmStorageDAO;

    public BpmStorage getById(Long id) {
        return bpmStorageDAO.selectById(id);
    }
}