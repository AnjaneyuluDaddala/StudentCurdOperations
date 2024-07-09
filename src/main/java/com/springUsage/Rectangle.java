package com.springUsage;

import org.springframework.stereotype.Component;

@Component
public class Rectangle implements Shape{
	void m1() {
		System.out.println("Invoked");
	}

	@Override
	public void area(int dim1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void area(int dim1, int dim2) {
		System.out.println("Area of Rectangle is = "+dim1*dim2);
		
	}

}
