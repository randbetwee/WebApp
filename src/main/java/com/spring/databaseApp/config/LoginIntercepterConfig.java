package com.spring.databaseApp.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.spring.databaseApp.interceptor.LoginInterceptor;


@Configuration
public class LoginIntercepterConfig implements WebMvcConfigurer{
    
    
    public void addIntercepter(InterceptorRegistry registry){
        HandlerInterceptor intercepter=new LoginInterceptor();
        List<String> patterns = new ArrayList<>();
        
        //注册白名单放行url
        patterns.add("/**");


        registry.addInterceptor(intercepter);
                //.addPathPatterns("/**")    //拦截名单
                //.excludePathPatterns(patterns);        //白名单
    }
}
