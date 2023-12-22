package com.spring.databaseApp.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.spring.databaseApp.interceptor.LoginInterceptor;
import com.spring.databaseApp.interceptor.UserAuthorityIntercepter;


@Configuration
public class IntercepterConfig implements WebMvcConfigurer{

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        
        List<String> patterns = new ArrayList<>();
        
        //注册白名单放行url
        patterns.add("/538/**");

        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/comment/**")   //拦截名单
                .excludePathPatterns(patterns);        //白名单
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/upload/**");
        registry.addInterceptor(new UserAuthorityIntercepter()).addPathPatterns("/admin/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //是否发送Cookie
                .allowCredentials(true)
                //放行哪些原始域
                .allowedOriginPatterns("http://localhost:*/")
                .allowedMethods(new String[]{"OPTIONS","GET", "POST", "PUT", "DELETE"})
                .allowedHeaders("*")
                .exposedHeaders("*");
    }

}
