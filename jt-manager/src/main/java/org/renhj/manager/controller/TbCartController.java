package org.renhj.manager.controller;

import com.sun.prism.shader.Mask_TextureSuper_AlphaTest_Loader;
import org.renhj.common.pojo.vo.Result;
import org.renhj.manager.pojo.domain.TbCart;
import org.renhj.manager.service.TbCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class TbCartController {
    @Autowired
    private TbCartService cartService;

    @GetMapping
    public Result carts(@RequestParam(value = "pageCurrent",defaultValue = "1")Integer current,
                        @RequestParam(value = "pageSize",defaultValue = "5")Integer size){
        return Result.ok(cartService.findCartsWithPage(current, size));
    }

    @PostMapping
    public Result addCart(@RequestBody TbCart cart){
        return Result.build(201, "save ok", cartService.saveCart(cart));
    }

    @GetMapping("/{id}")
    public Result getCart(@PathVariable String id){
        return Result.ok(cartService.findCartById(id));
    }

    @PostMapping("/{id}")
    public Result updateCart(@PathVariable String id, @RequestBody TbCart cart){
        return Result.build(200,"update ok", cartService.updateCart(cart));
    }
}
