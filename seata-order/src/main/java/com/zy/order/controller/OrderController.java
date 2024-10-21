package com.zy.order.controller;

import com.zy.common.service.StorageService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author zy
 * @Date 2024/10/21 22:35
 **/
@RestController
@RequestMapping("/testOrder")
public class OrderController {

    @DubboReference
    private StorageService storageService;

    @GetMapping("/createOrder")
    public String createOrder(@RequestParam("id") Long productId,
                              @RequestParam("number")Integer number){
        storageService.reduceStorage(productId,number);
        return "success";
    }
}
