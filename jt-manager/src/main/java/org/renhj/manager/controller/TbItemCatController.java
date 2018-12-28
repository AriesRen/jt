package org.renhj.manager.controller;

import org.renhj.common.pojo.vo.Result;
import org.renhj.manager.pojo.domain.TbItemCat;
import org.renhj.manager.service.TbItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/itemCats")
public class TbItemCatController {
    @Autowired
    private TbItemCatService itemCatService;

    @GetMapping
    public Result itemCats(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
        return Result.ok(itemCatService.findItemCatByParentId(parentId));
    }

    @GetMapping("/{id}")
    public Result itemCat(@PathVariable Long id) {
        return Result.ok(itemCatService.findItemCatById(id));
    }

    @PostMapping("/{id}")
    public Result updateItemCat(@PathVariable Long id, @RequestBody TbItemCat itemCat) {
        return Result.ok(itemCatService.updateItemCat(id, itemCat));
    }

    @DeleteMapping("{id}")
    public Result deleteItemCat(@PathVariable Long id) {
        return Result.build(200, "delete ok", itemCatService.deleteItemCat(id));
    }
}
