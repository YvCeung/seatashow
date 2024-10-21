package com.zy.storage.service;

import com.zy.common.service.StorageService;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * @Author zy
 * @Date 2024/10/21 22:39
 **/
@DubboService
public class StorageServiceImpl implements StorageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Override
    public void reduceStorage(Long productId, Integer number) {
        LOGGER.info("received reduceStorage request productId:{},number:{}",productId,number);
    }
}
