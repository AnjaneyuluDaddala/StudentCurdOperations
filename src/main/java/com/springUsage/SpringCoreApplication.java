package com.springUsage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreApplication.class, args);
		// Application Interface
		//
		ApplicationContext context=new ClassPathXmlApplicationContext("Spring1.xml");
//		Shape rf=(Shape)context.getBean("square");
//		rf.area(12);
		
  	    Car vh=(Car)context.getBean("car");
	     vh.drive();
		
		
//    	Tyres t=(Tyres)context.getBean("Tyres");
//     	System.out.println(t);
//		System.out.println(t.getBrandName()+" "+t.getCost());
		
		
	}

}
