package org.renhj.manager.controller;

import org.renhj.common.pojo.vo.Result;
import org.renhj.manager.pojo.domain.TbOrder;
import org.renhj.manager.service.TbOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class TbOrderController {
    @Autowired
    private TbOrderService orderService;

    @GetMapping
    public Result orders(@RequestParam(value = "pageCurrent", defaultValue = "1")Integer current,
                         @RequestParam(value = "pageSize", defaultValue = "5")Integer size){
        return Result.build(200, "success",orderService.findOrdersWithPage(current, size));
    }

    @PostMapping
    public Result addOrders(@RequestBody TbOrder order){
        return Result.build(201, "save ok", orderService.saveOrder(order));
    }

    @GetMapping("/{id}")
    public Result getOrder(@PathVariable String id){
        return Result.ok(orderService.findOrderById(id));
    }

    @PostMapping("/{id}")
    public Result updateOrder(@PathVariable String id, @RequestBody TbOrder order){
        return Result.build(200, "update ok", orderService.updateOrder(order));
    }
}
