package com.authorization.oauth.config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/loginForm").setViewName("loginForm");
    }

}
