package com.lgx.controller;

import com.lgx.common.Result;
import com.lgx.entity.Book;
import com.lgx.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping("/list")
    public Result<List<Book>> list() {
        return Result.success(bookService.list());
    }

    @GetMapping("/get/{id}")
    public Result<Book> getById(@PathVariable Long id) {
        return Result.success(bookService.getById(id));
    }

    @PostMapping("/add")
    public Result<String> add(@RequestBody Book book) {
        bookService.add(book);
        return Result.success("添加成功");
    }

    @PostMapping("/update")
    public Result<String> update(@RequestBody Book book) {
        bookService.update(book);
        return Result.success("修改成功");
    }

    @GetMapping("/delete/{id}")
    public Result<String> delete(@PathVariable Long id) {
        bookService.delete(id);
        return Result.success("删除成功");
    }

    @GetMapping("/search")
    public Result<List<Book>> search(@RequestParam String keyword) {
        return Result.success(bookService.search(keyword));
    }

    @GetMapping("/page")
    public Result<List<Book>> page(
            @RequestParam Integer pageNum,
            @RequestParam Integer pageSize) {
        return Result.success(bookService.getPage(pageNum, pageSize));
    }
}