package com.spring.databaseApp.interceptor;

import java.io.IOException;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor{
    


    @Override
    public boolean preHandle(HttpServletRequest request, 
                            HttpServletResponse response, 
                            Object handler) throws IOException{
    Object obj=request.getSession().getAttribute("id");
    if(obj==null){
        response.sendRedirect("web/login.html");
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
