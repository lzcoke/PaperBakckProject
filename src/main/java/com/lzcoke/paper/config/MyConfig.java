package com.lzcoke.paper.config;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    /*使得login监听器成为spring容器*/
    @Bean
    public LoginHandleInterceptor loginHandlerInterceptor() {
        return new LoginHandleInterceptor();
    }

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "/login",
            "/500",
            "/doc.html**",
            "/webjars/**",
            "/webjar/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/backend/**",
    };

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // addPathPatterns添加拦截路由
//        // excludePathPatterns 不拦截路由设置
//        registry.addInterceptor(loginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns(CLASSPATH_RESOURCE_LOCATIONS);
//    }
}
