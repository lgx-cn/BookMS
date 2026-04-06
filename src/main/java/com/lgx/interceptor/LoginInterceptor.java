package com.lgx.interceptor;

import com.lgx.util.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");

        if (token == null || token.trim().isEmpty()) {
            response.getWriter().write("{\"code\":401,\"msg\":\"请先登录\",\"data\":null}");
            return false;
        }

        try {
            JwtUtil.parseToken(token);
            String username = JwtUtil.getUsername(token);
            request.setAttribute("username", username);
            return true;
        } catch (Exception e) {
            response.getWriter().write("{\"code\":401,\"msg\":\"登录无效或已过期\",\"data\":null}");
            return false;
        }
    }
}