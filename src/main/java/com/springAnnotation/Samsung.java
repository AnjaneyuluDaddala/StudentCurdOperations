package com.springAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import sql.Rectangle;
@Component
public class Samsung {
	
	@Autowired
	//@Qualifier("ImplementCpu1")
	private InterfaceCPU cpu;
	private Rectangle rc;
	
	void configure() {
		System.out.println("Samsung ,5G ,256 GB , 30000");
		cpu.processor();
		rc.area(12,12);
			
	}
	
	public InterfaceCPU getCpu() {
		return cpu;
	}

	public void setCpu(InterfaceCPU cpu) {
		this.cpu = cpu;
	}
	

	public Rectangle getRc() {
		return rc;
	}

 @Autowired
	public void setRc(Rectangle rc) {
		this.rc = rc;
	}


	

}
