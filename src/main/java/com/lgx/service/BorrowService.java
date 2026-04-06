package com.lgx.service;

import com.lgx.entity.Book;
import com.lgx.entity.Borrow;
import com.lgx.mapper.BookMapper;
import com.lgx.mapper.BorrowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class BorrowService {

    @Resource
    private BorrowMapper borrowMapper;

    @Resource
    private BookMapper bookMapper;

    // 借阅
    @Transactional
    public boolean borrow(String bookCode, String username) {
        // 1. 查询图书是否存在且在馆
        Book book = bookMapper.getByCode(bookCode);
        if (book == null || book.getStatus() == 1) {
            return false;
        }

        // 2. 修改图书状态为已借出
        bookMapper.borrowBook(bookCode);

        // 3. 新增借阅记录
        return borrowMapper.add(bookCode, username) > 0;
    }

    // 归还
    @Transactional
    public boolean returnBook(String bookCode, String username) {
        // 1. 查询是否有借阅中的记录
        Borrow borrow = borrowMapper.getBorrowingByCodeAndUser(bookCode, username);
        if (borrow == null) {
            return false;
        }

        // 2. 修改图书状态为在馆
        bookMapper.returnBook(bookCode);

        // 3. 修改借阅记录为已归还
        return borrowMapper.returnBook(bookCode, username) > 0;
    }

    // 查询我的借阅
    public Object myBorrow(String username) {
        return borrowMapper.listBorrowing(username);
    }
}