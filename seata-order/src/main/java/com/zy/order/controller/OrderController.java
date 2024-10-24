package com.zy.order.controller;

import com.zy.common.bo.OrderTblDO;
import com.zy.common.service.StockTblService;
import com.zy.common.service.OrderTblService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
    private StockTblService stockTblService;

    @Autowired
    private OrderTblService orderTblService;


    @GetMapping("/createOrderRandom")
    @Transactional
    public String createOrder(@RequestParam("id") Integer productId,
                              @RequestParam("number")Integer number){

        //先创建订单(本系统)
        OrderTblDO orderTblDO = new OrderTblDO();
        orderTblDO.setCount(number);
        orderTblDO.setMoney(number * 100);
        orderTblDO.setCommodityCode("C00321");
        orderTblDO.setUserId("123456");
        OrderTblDO order = orderTblService.createOrder(orderTblDO);
        //在扣减库存
        stockTblService.reduceStock(productId,number);
        //失败，预期会回滚
        return "success";
    }

    @GetMapping("/createOrderFail")
    @Transactional
    public String createOrder2(@RequestParam("id") Integer productId,
                              @RequestParam("number")Integer number){

        //先扣减库存(保证扣减成功)
        stockTblService.reduceStock(productId,number);

        //在创建订单(本系统)
        OrderTblDO orderTblDO = new OrderTblDO();
        orderTblDO.setCount(number);
        orderTblDO.setMoney(number * 100);
        orderTblDO.setCommodityCode("C00321");
        orderTblDO.setUserId("123456");

        //成功创建
        OrderTblDO order = orderTblService.createOrder(orderTblDO);
        //失败，预期会回滚
        int res = 1 / 0;
        return "success";
    }
}
