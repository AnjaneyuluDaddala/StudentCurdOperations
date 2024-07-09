package com.springUsage;

import org.springframework.stereotype.Component;

@Component


public class Tyres {

private String BrandName;
private int cost;

public String getBrandName() {
	return BrandName;
}
public void setBrandName(String brandName) {
	BrandName = brandName;
}
public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}

public String toString() {
	return "It is invoked Tyres class--> working" ;
}

}
