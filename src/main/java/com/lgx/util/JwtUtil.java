package com.lgx.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {

    // 🔥 修复：密钥至少 32 个字符（256 bits），这里用 32 位随机字符串
    private static final String SECRET_KEY = "bookAdminSecretKey1234567890abcdefgh";
    private static final long EXPIRATION = 1000 * 60 * 60 * 24; // 1天

    // 生成密钥（固定写法）
    private static SecretKey getKey() {
        // 这里会自动把字符串转成 256 位密钥
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    // 生成 Token
    public static String createToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(getKey()) // 用修复后的密钥
                .compact();
    }

    // 解析 Token
    public static Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey()) // 用修复后的密钥
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // 获取用户名
    public static String getUsername(String token) {
        return parseToken(token).getSubject();
    }
}