package com.springAnnotation.Practice;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean(initMethod = "customInit", destroyMethod = "customDestroy" )
     MyBean myBean() {
        return new MyBean();
    }
}


