package com.lgx.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 用户实体类
 * 作用：映射数据库t_user表，封装用户数据
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String role;
    private LocalDateTime createTime;
}