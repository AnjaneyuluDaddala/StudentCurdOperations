package com.springUsage;

import org.springframework.stereotype.Component;

@Component
public class Square implements Shape{

	@Override
	public void area(int dim1) {
		System.out.println("Area of Square is = "+dim1*dim1);
		
	}

	@Override
	public void area(int dim1, int dim2) {
		// TODO Auto-generated method stub
		
	}

}
