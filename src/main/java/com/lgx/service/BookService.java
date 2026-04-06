package com.lgx.service;

import com.lgx.entity.Book;
import com.lgx.mapper.BookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookService {

    @Resource
    private BookMapper bookMapper;

    public List<Book> list() {
        return bookMapper.list();
    }

    public Book getById(Long id) {
        return bookMapper.getById(id);
    }

    // 新增：自动生成编码，默认在馆
    public boolean add(Book book) {
        book.setBookCode(generateNextBookCode());
        book.setStatus(0);
        return bookMapper.add(book) > 0;
    }

    public boolean update(Book book) {
        return bookMapper.update(book) > 0;
    }

    public boolean delete(Long id) {
        return bookMapper.delete(id) > 0;
    }

    public List<Book> search(String keyword) {
        return bookMapper.search(keyword);
    }

    public List<Book> getPage(Integer pageNum, Integer pageSize) {
        int offset = (pageNum - 1) * pageSize;
        return bookMapper.selectPage(offset, pageSize);
    }

    // 自动生成 0001 0002 编码
    public String generateNextBookCode() {
        String maxCode = bookMapper.getMaxBookCode();
        if (maxCode == null) {
            return "0001";
        }
        int nextNum = Integer.parseInt(maxCode) + 1;
        return String.format("%04d", nextNum);
    }
}