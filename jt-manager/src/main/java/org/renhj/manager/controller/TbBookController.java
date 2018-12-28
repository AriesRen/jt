package org.renhj.manager.controller;

import org.renhj.common.pojo.vo.Result;
import org.renhj.manager.pojo.domain.TbBook;
import org.renhj.manager.service.TbBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class TbBookController {
    @Autowired
    private TbBookService bookService;

    @GetMapping
    public Result books(@RequestParam(value = "pageCurrent", defaultValue = "1") Integer current,
                        @RequestParam(value = "pageSize", defaultValue = "5") Integer size) {
        return Result.ok(bookService.findBooksWithPage(current, size));
    }

    @PostMapping
    public Result addBooks(@RequestBody TbBook book) {
        return Result.build(201, "save ok", bookService.saveBook(book));
    }

    @GetMapping("/{id}")
    public Result getBook(@PathVariable String id) {
        return Result.ok(bookService.findBookById(id));
    }

    @PostMapping("/{id}")
    public Result updateBook(@PathVariable String id, @RequestBody TbBook book) {
        return Result.build(200, "update ok", bookService.updateBook(book));
    }
}
