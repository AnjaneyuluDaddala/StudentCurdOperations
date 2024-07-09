package com.springUsage;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vechicle{
 @Autowired
  private Tyres tyre;
    
    public Tyres getTyre() {
		return tyre;
	}
	public void setTyre(Tyres tyre) {
		this.tyre = tyre;
	}

	
	public void drive() {
		System.out.println("Driving The car---> "+ tyre);
		
	}
	
}
