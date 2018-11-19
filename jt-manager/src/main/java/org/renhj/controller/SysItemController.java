package org.renhj.controller;


import org.renhj.common.PageObject;
import org.renhj.common.Result;
import org.renhj.service.SysItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/items")
public class SysItemController {
    @Autowired
    private SysItemService itemService;

    @RequestMapping(value = "")
    @ResponseBody
    public Result<PageObject> itemsList(@RequestParam(value = "pageCurrent", defaultValue = "1")Integer pageCurrent,
                                        @RequestParam(value = "pageSize", defaultValue = "5")Integer pageSize,
                                        @RequestParam(value = "title", defaultValue = "")String title){
        return new Result<PageObject>(itemService.findItemByTitleWithPage(title, pageCurrent, pageSize));
    }

}
