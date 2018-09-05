package com.wf;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {
       
    	registry.addViewController( "/" ).setViewName( "forward:/faces/test.xhtml" );
        registry.addViewController( "/HomePage" ).setViewName( "forward:/faces/studentHomePage.xhtml" );
     //   registry.addViewController( "/faces/HomePage" ).setViewName( "forward:/faces/adminHomePage.xhtml" );
        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
        super.addViewControllers( registry );
    }
}