package com.zy.seata.order.controller;

import com.zy.common.api.bo.OrderTblDO;
import com.zy.common.api.service.OrderTblService;
import com.zy.common.api.service.StockTblService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * @Description
 * @Author zy
 * @Date 2024/10/21 22:35
 **/
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @DubboReference
    private StockTblService stockTblService;

    @Autowired
    private OrderTblService orderTblService;


    @GetMapping("/healthcheck")
    public String healthcheck(){
        OrderTblDO orderTblDO = orderTblService.queryById(1);
        return "health";
    }


    @GetMapping("/createOrderRandom")
    @Transactional
    public String createOrderRandom(@RequestParam("commodityCode") String commodityCode,
                              @RequestParam("number")Integer number){

        //先创建订单(本系统)
        OrderTblDO orderTblDO = new OrderTblDO();
        orderTblDO.setCount(number);
        orderTblDO.setMoney(number * 100);
        orderTblDO.setCommodityCode(commodityCode);
        orderTblDO.setUserId("123456");
        OrderTblDO order = orderTblService.createOrder(orderTblDO);
        //在扣减库存
        stockTblService.reduceStockByCode(commodityCode,number);
        //失败，预期会回滚
        return "success1";
    }

    @GetMapping("/createOrderWithReduceStock")
    @GlobalTransactional
    public String createOrder2(@RequestParam("commodityCode") String commodityCode,
                               @RequestParam("number")Integer number){


        //在创建订单(本系统) 执行本地操作
        OrderTblDO orderTblDO = new OrderTblDO();
        orderTblDO.setCount(number);
        orderTblDO.setMoney(number * 100);
        orderTblDO.setCommodityCode(commodityCode);
        orderTblDO.setUserId("xiaoyu");

        //成功创建
        OrderTblDO order = orderTblService.createOrder(orderTblDO);
        if(Objects.nonNull(order)){
            log.info("创建订单成功");
        }

        //先扣减库存(保证扣减成功)
        boolean reduceRes = stockTblService.reduceStockByCode(commodityCode, number);
        log.info("库存扣减结果 :{}", reduceRes);
        return "success";
    }

    @GetMapping("/reduceStockWithCreateOrder")
    @GlobalTransactional
    public String reduceStockWithCreateOrder(@RequestParam("commodityCode") String commodityCode,
                               @RequestParam("number")Integer number){


        //先扣减库存(保证扣减成功)
        boolean reduceRes = stockTblService.reduceStockByCode(commodityCode, number);
        log.info("库存扣减结果 :{}", reduceRes);
        throw new RuntimeException("模拟创建订单异常");
    }

    @PostConstruct
    public void init() {
        System.out.println("===> OrderController loaded");
    }

}
