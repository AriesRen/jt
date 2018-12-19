package org.renhj.controller;


import org.renhj.common.PageObject;
import org.renhj.common.Result;
import org.renhj.entity.SysItem;
import org.renhj.service.SysItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class SysItemController {
    @Autowired
    private SysItemService itemService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result<PageObject> itemsList(@RequestParam(value = "pageCurrent", defaultValue = "1")Integer pageCurrent,
                                        @RequestParam(value = "pageSize", defaultValue = "5")Integer pageSize,
                                        @RequestParam(value = "title", defaultValue = "")String title){
        return new Result<PageObject>(itemService.findItemByTitleWithPage(title, pageCurrent, pageSize));
    }

    @PostMapping(value = "")
    public Result<Object> insertItem(@RequestBody SysItem item){
        return new Result<Object>(itemService.saveItem(item));
    }

    @GetMapping("/{id}")
    public Result<Object> findItem(@PathVariable("id")Long id){
        return new Result<Object>(200, "success", itemService.findItemById(id));
    }

    @DeleteMapping("/{id}")
    public Result<Object> deleteItem(@PathVariable("id")Long id){
        return new Result<Object>(200, "success", itemService.deleteItem(id));
    }

    @PatchMapping("/{id}")
    public Result<Object> updateItem(@PathVariable("id")Integer id, @RequestBody SysItem item){
        return new Result<Object>(200, "success", itemService.updateItem(item));
    }

}
