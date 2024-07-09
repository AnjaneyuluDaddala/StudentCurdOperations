package com.springAnnotation;

import org.springframework.stereotype.Component;

@Component
public class ImplementCpu implements InterfaceCPU{

	@Override
	public void processor() {
		System.out.println("World Best cpu have choosen -->");
		System.out.println("Contrats! have a Nice day...");
		
	}

}
