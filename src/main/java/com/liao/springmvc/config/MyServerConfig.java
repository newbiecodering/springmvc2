package com.liao.springmvc.config;

import com.liao.springmvc.filter.MyFilter;
import com.liao.springmvc.listener.Mylistener;
import com.liao.springmvc.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class MyServerConfig  {

    @Bean
   public ServletRegistrationBean registrationBean(){
       ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new MyServlet(),"/myServlet");
       servletRegistrationBean.setLoadOnStartup(1);
       return servletRegistrationBean;
   }

   @Bean
   public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean bean= new FilterRegistrationBean();
        bean.setFilter(new MyFilter());
        bean.setUrlPatterns(Arrays.asList("/myServlet"));
        return bean;
   }

   @Bean
   public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean<Mylistener> bean=new ServletListenerRegistrationBean(new Mylistener());
        return bean;
   }
}
