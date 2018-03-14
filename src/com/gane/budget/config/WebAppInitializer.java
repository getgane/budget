package com.gane.budget.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
 
public class WebAppInitializer implements WebApplicationInitializer {
 
    @Override
    public void onStartup(ServletContext context) {
    	System.out.println("Startup webapp");
        AnnotationConfigWebApplicationContext webAppContext = new AnnotationConfigWebApplicationContext();
        context.addListener(new ContextLoaderListener(webAppContext));
        webAppContext.register(SpringConfig.class);
             
        ServletRegistration.Dynamic dispatcher = context.addServlet("dispatcher", new DispatcherServlet(webAppContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");         
    }
 }