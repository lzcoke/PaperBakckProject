package com.lzcoke.paper.config;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS")
                .maxAge(3600);
        WebMvcConfigurer.super.addCorsMappings(registry);
    }

    /*使得login监听器成为spring容器*/
    @Bean
    public LoginHandleInterceptor loginHandlerInterceptor() {
        return new LoginHandleInterceptor();
    }

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "/backend/v1/login",
            "/500",
            "/static/**",
            "/static/swagger-resources/**",
            "/static/swagger-resources**",
            "/static/swagger-resources**",
            "/swagger-resources**",
            "/swagger-ui.html**",
            "/doc.html**",
            "/webjars/**"
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns添加拦截路由
        // excludePathPatterns 不拦截路由设置
        registry.addInterceptor(loginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns(CLASSPATH_RESOURCE_LOCATIONS);
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(
                "classpath:/static/",
                "classpath:/public/",
                "classpath:/resources/",
                "classpath:/META-INF/resources/"
        );
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
