package com.lgx.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Borrow {
    private Long id;
    private String bookCode;      // 对应数据库 book_code
    private String username;      // 对应数据库 username
    private LocalDateTime borrowTime; // 对应数据库 borrow_time
    private LocalDateTime returnTime; // 对应数据库 return_time
    private Integer status;      // 对应数据库 status
}