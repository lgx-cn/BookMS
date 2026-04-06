package com.lgx.mapper;

import com.lgx.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户Mapper接口
 * 作用：定义用户数据操作
 */
@Mapper
public interface UserMapper {
    /**
     * 根据用户名查询用户
     */
    User selectByUsername(String username);
}