package com.zy.storage.controller;

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

    @GetMapping("/getNumber")
    public String getNumber(){
        return "123";
    }
}
