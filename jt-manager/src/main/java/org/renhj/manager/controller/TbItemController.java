package org.renhj.manager.controller;

import com.sun.prism.shader.Mask_TextureSuper_AlphaTest_Loader;
import org.renhj.common.pojo.vo.Result;
import org.renhj.manager.pojo.domain.TbItem;
import org.renhj.manager.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class TbItemController {
    @Autowired
    private TbItemService itemService;

    @GetMapping
    public Result items(@RequestParam(value = "pageCurrent", defaultValue = "1")Integer pageCurrent,
                        @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize){
        return Result.ok(itemService.findItemWithPage(pageCurrent, pageSize));
    }

    @PostMapping
    public Result addItem(@RequestBody TbItem item){
        return Result.build(201, "save ok", itemService.saveItem(item));
    }

    @GetMapping("/{id}")
    public Result item(@PathVariable Long id){
        return Result.ok(itemService.findItemById(id));
    }

    @PostMapping("/{id}")
    public Result updateItem(@PathVariable Long id,@RequestBody TbItem item){
        return Result.build(200, "update ok", itemService.updateItem(item));
    }

    @DeleteMapping("/{id}")
    public Result deleteItem(@PathVariable String id){
        return Result.ok(itemService.deleteItemById(id));
    }
}
