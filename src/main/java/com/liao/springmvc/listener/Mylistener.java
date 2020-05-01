package com.liao.springmvc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Mylistener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("listener init...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("listener destoryed....");
    }
}
