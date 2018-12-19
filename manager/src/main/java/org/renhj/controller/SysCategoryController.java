package org.renhj.controller;

import org.renhj.common.Result;
import org.renhj.entity.SysCategory;
import org.renhj.service.SysCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class SysCategoryController {
    @Autowired
    private SysCategoryService cateService;

    @GetMapping("")
    public Result<Object> getCategories(@RequestParam(value = "pageCurrent", defaultValue = "1")Integer pageCurrent,
                                        @RequestParam(value = "pageSize", defaultValue = "5")Integer pageSize,
                                        @RequestParam(value = "search", defaultValue = "")String search){
        return new Result<>(200, "ok", cateService.findCategoryWithPage(search, pageCurrent, pageSize));
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Object> postCategory(@RequestBody SysCategory cate){
        return new Result<Object>(201, "save ok", cateService.saveCategory(cate));
    }

    @DeleteMapping("/{id}")
    public Result<Integer> deleteCategory(@PathVariable("id")Long id){
        return new Result<>(cateService.deleteCategory(id));
    }

    @GetMapping("/{id}")
    public Result<?> getCategory(@PathVariable("id")Long id){
        return new Result<Object>(200, "success", cateService.findCategoryById(id));
    }
}
