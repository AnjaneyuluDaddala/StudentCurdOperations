package com.springAnnotation.Practice;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class MyBean implements BeanNameAware, InitializingBean, DisposableBean{

	    private String beanName;

	    @Override
	    public void setBeanName(String name) {
	        this.beanName = name;
	        System.out.println("Bean name set to " + name);
	    }

	    @Override
	    public void afterPropertiesSet() throws Exception {
	        System.out.println("After properties set");
	    }

	    @PostConstruct
	    public void postConstruct() {
	        System.out.println("Post Construct");
	    }

	    public void customInit() {
	        System.out.println("Custom Init Method");
	    }

	    @Override
	    public void destroy() throws Exception {
	        System.out.println("DisposableBean Destroy Method");
	    }

	    @PreDestroy
	    public void preDestroy() {
	        System.out.println("Pre Destroy Method");
	    }

	    public void customDestroy() {
	        System.out.println("Custom Destroy Method");
	    }
	}

