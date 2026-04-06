package com.lgx.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 图书实体类
 * 作用：映射数据库t_book表，封装图书数据
 */
@Data
public class Book {
    private Long id;
    private String name;
    private String author;
    private BigDecimal price;
    private String bookCode;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}