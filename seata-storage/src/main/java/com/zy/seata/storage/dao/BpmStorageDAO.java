package com.zy.seata.storage.dao;

import com.zy.common.api.bo.BpmStorage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Description
 * @Author zy
 * @Date 2025/6/23 21:16
 **/
@Mapper
public interface BpmStorageDAO {
    @Select("SELECT * FROM BPM3.BPM_STORAGE WHERE ID = #{id}")
    BpmStorage selectById(Long id);
}
