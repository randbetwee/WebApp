package com.spring.databaseApp.interceptor;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class UserAuthorityIntercepter implements HandlerInterceptor{
    
    @Override
    public boolean preHandle(HttpServletRequest request, 
                            HttpServletResponse response, 
                            Object handler) throws IOException{
    Object obj=request.getSession().getAttribute("type");
    Object t=true;
    //用户不是管理员
    if(obj.equals(t)){
        response.sendRedirect("/");
        return false;
    }
    return true;
    }



    @Override
    public void postHandle(HttpServletRequest request, 
                            HttpServletResponse response, 
                            Object handler, 
                            ModelAndView modelAndView) throws Exception{}

    @Override
    public void afterCompletion(HttpServletRequest request, 
                            HttpServletResponse response, 
                            Object handler, 
                            Exception ex) throws Exception{}
}
