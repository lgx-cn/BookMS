📚 BookMS 图书管理系统
基于 SpringBoot + MyBatis + MySQL 的简易图书管理系统
项目介绍
这是一个简易的图书管理系统，实现了用户管理、图书管理、借书还书等核心功能。适合毕业设计、课程设计、学习 SpringBoot 实战使用。
功能模块
用户注册 / 登录
图书信息增删改查
图书借阅与归还
借阅记录管理
权限区分（用户 / 管理员）
技术栈
后端：SpringBoot 2.x
持久层：MyBatis
数据库：MySQL 8.0+
构建工具：Maven
数据库设计
共 3 张核心表：
t_user —— 用户表
t_book —— 图书表
t_borrow —— 借阅记录表
项目结构
plaintext
com
└── example
    ├── controller   // 控制层
    ├── service      // 业务逻辑层
    ├── mapper       // 数据访问层
    └── entity       // 实体类
部署说明
创建 MySQL 数据库
执行 SQL 文件创建三张表
修改 application.yml 中的数据库连接信息
启动项目访问
注意事项
数据库配置文件不上传至 GitHub，请自行配置
本项目仅用于学习与毕业设计使用
作者
你的名字
项目：图书管理系统 BookMS
