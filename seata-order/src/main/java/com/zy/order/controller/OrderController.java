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


    @GetMapping("/createOrder")
    @Transactional
    public String createOrder(@RequestParam("id") Integer productId,
                              @RequestParam("number")Integer number){
        //创建订单(本系统)
        OrderTblDO orderTblDO = new OrderTblDO();
        orderTblDO.setCount(number);
        orderTblDO.setMoney(number * 100);
        orderTblDO.setCommodityCode("C00321");
        orderTblDO.setUserId("123456");
        OrderTblDO order = orderTblService.createOrder(orderTblDO);
        //失败，预期会回滚
        stockTblService.reduceStockWithError(productId,number);
        return "success";
    }

    @GetMapping("/createOrder2")
    @Transactional
    public String createOrder2(@RequestParam("id") Integer productId,
                              @RequestParam("number")Integer number){

        //成功扣减
        stockTblService.reduceStockWithError(productId,number);

        //创建订单(本系统)
        OrderTblDO orderTblDO = new OrderTblDO();
        orderTblDO.setCount(number);
        orderTblDO.setMoney(number * 100);
        orderTblDO.setCommodityCode("C00321");
        orderTblDO.setUserId("123456");
        OrderTblDO order = orderTblService.createOrder(orderTblDO);
        int res = 1 / 0;
        return "success";
    }
}
