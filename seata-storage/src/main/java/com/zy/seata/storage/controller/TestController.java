package com.zy.seata.storage.controller;

import com.zy.common.api.bo.BpmStorage;
import com.zy.seata.storage.service.BpmTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author zy
 * @Date 2024/10/20 22:41
 **/
@RestController
@RequestMapping("/testStorage")
public class TestController {

    @Autowired
    BpmTypeService bpmTypeService;

    @GetMapping("/getNumber")
    public String getNumber(){
        return "123";
    }

    @GetMapping("/getBpm")
    public String getBpm(){
        BpmStorage byId = bpmTypeService.getById(1L);
        return "success";
    }


}
