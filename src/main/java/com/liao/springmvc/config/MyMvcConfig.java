package com.liao.springmvc.config;

import com.liao.springmvc.compoment.LoginHandlerInterceptor;
import com.liao.springmvc.compoment.MyLocaleResolver;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer{

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
//        registry.addViewController("/").setViewName("login");
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer login = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/").setViewName("login");
                registry.addViewController("").setViewName("login");
                registry.addViewController("/dashboard.html").setViewName("dashboard");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

//            @Override
////            public void addInterceptors(InterceptorRegistry registry) {
////                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
////                        excludePathPatterns("/login.html","/","/dashboard","/webjars/**");
////            }
        };
        return login;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}