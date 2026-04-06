package com.lgx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * 作用：SpringBoot项目入口，扫描Mapper接口
 */
@SpringBootApplication
@MapperScan("com.lgx.mapper")  // 扫描mapper包下的所有接口
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}