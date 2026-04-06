package com.lgx.mapper;

import com.lgx.entity.Borrow;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface BorrowMapper {

    int add(@Param("bookCode") String bookCode, @Param("username") String username);

    int returnBook(@Param("bookCode") String bookCode, @Param("username") String username);

    List<Borrow> listBorrowing(@Param("username") String username);

    Borrow getBorrowingByCodeAndUser(@Param("bookCode") String bookCode, @Param("username") String username);
}