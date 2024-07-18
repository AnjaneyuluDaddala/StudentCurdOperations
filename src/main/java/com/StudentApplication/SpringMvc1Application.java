package com.StudentApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.StudentApplication.Config.StudentConfig;

@SpringBootApplication
public class SpringMvc1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvc1Application.class, args);
		ApplicationContext con=new AnnotationConfigApplicationContext(StudentConfig.class);
	}

}
