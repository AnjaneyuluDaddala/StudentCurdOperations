package com.springAnnotation;



import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ImplementCpu1 implements InterfaceCPU {

	@Override
	public void processor() {
		System.out.println("cpu 2 is invoked");
		
	}

}
