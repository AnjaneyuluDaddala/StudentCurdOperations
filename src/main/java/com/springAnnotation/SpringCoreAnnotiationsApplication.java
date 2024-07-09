package com.springAnnotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springAnnotation.Practice.MyBean;

@SpringBootApplication
//spring core annotation
public class SpringCoreAnnotiationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreAnnotiationsApplication.class, args);
		
		ApplicationContext factory=new AnnotationConfigApplicationContext(CollectingObjects.class);
//		Samsung sam=factory.getBean(Samsung.class);
//		
//		sam.configure();
		
		MyBean bean = factory.getBean(MyBean.class);
//		bean.setBeanName("Intilized");
//		bean.customInit();
//		bean.postConstruct();		
//		bean.customDestroy();
//	    bean.preDestroy();
		
	}

}
