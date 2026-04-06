package com.lgx.mapper;

import com.lgx.entity.Book;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface BookMapper {

    List<Book> list();

    Book getById(@Param("id") Long id);

    Book getByCode(@Param("bookCode") String bookCode);

    int add(Book book);

    int update(Book book);

    int delete(@Param("id") Long id);

    List<Book> search(@Param("keyword") String keyword);

    List<Book> selectPage(@Param("offset") int offset, @Param("size") int size);

    long selectCount();

    int borrowBook(@Param("bookCode") String bookCode);

    int returnBook(@Param("bookCode") String bookCode);

    String getMaxBookCode();
}