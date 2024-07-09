package com.springAnnotation;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
//@ComponentScan(basePackages = "com.springAnnotation,sql")
@ComponentScan(basePackages = {"com.springAnnotation", "sql"})

public class CollectingObjects {
//	@Bean
//	Samsung getMobile() {
//		
//		return new Samsung();
//	
//	}
//	
//	@Bean
//	ImplementCpu getCpu() {
//		
//		return new ImplementCpu();
//	}
	

}