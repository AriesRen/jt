package org.renhj.manager.controller;

import org.renhj.common.pojo.vo.Result;
import org.renhj.manager.pojo.domain.TbItem;
import org.renhj.manager.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class TbItemController {
    @Autowired
    private TbItemService itemService;

    // 分页获取商品信息
    @GetMapping
    public Result items(@RequestParam("pageCurrent")Integer pageCurrent,
                        @RequestParam("pageSize")Integer pageSize){
        return Result.ok(itemService.findItemWithPage(pageCurrent, pageSize));
    }
    // 添加一个商品信息
    @PostMapping
    public Result addItem(@RequestBody TbItem item){
        return Result.build(201, "save ok", itemService.saveItem(item));
    }

    // 获得某一个商品信息
    @GetMapping("/{id}")
    public Result item(@PathVariable Long id){
        return Result.ok(itemService.findItemById(id));
    }

    // 修改某一个商品所有信息
    @PostMapping("/{id}")
    public Result updateItem(@PathVariable Long id,@RequestBody TbItem item){
        return Result.build(200, "update ok", itemService.updateItem(item));
    }

    // 修改某一个商品某个属性信息
    @PatchMapping("/{id}")
    public Result patchItem(@PathVariable Long id, @RequestBody TbItem item){
        return Result.build(200, "patch ok", itemService.patchItem(id, item));
    }
    // 删除某一个商品信息
    @DeleteMapping("/{id}")
    public Result deleteItem(@PathVariable Long id){
        return Result.ok(itemService.deleteItemById(id));
    }
}
