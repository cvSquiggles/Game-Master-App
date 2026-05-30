package com.gamemaster.gmapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry) {

        /*addMapping("/**") allows CORS requests to all endpoints in the application.
        * allowedOrigins("http://localhost:5173")specifies that only requests from http://localhost:5173 are allowed.
        * The allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") is obvi... OPTIONS is something browsers use to check for cross-origin permission before executing a request.*/
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
