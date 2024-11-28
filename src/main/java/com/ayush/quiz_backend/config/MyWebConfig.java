package com.ayush.quiz_backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // adjust the path as needed
                .allowedOrigins("http://127.0.0.1:5500") // or use "*" to allow all origins
                .allowedMethods("GET", "POST", "PUT", "DELETE") // specify allowed methods
                .allowCredentials(true);
    }
}
