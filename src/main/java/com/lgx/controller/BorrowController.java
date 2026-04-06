package com.lgx.controller;

import com.lgx.common.Result;
import com.lgx.service.BorrowService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Resource
    private BorrowService borrowService;

    @PostMapping("/add")
    public Result<String> borrow(@RequestParam String bookCode, HttpServletRequest request) {
        String username = (String) request.getAttribute("username");
        boolean success = borrowService.borrow(bookCode, username);
        return success ? Result.success("借阅成功") : Result.error("借阅失败");
    }

    @PostMapping("/return")
    public Result<String> returnBook(@RequestParam String bookCode, HttpServletRequest request) {
        String username = (String) request.getAttribute("username");
        boolean success = borrowService.returnBook(bookCode, username);
        return success ? Result.success("归还成功") : Result.error("归还失败");
    }

    @GetMapping("/my")
    public Result myBorrow(HttpServletRequest request) {
        String username = (String) request.getAttribute("username");
        return Result.success(borrowService.myBorrow(username));
    }
}