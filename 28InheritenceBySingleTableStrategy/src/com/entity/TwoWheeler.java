package com.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BIKE")
public class TwoWheeler extends Vehicle {
	
	private String sterringHandle;
	public String getSterringHandle() {
		return sterringHandle;
	}

	public void setSterringHandle(String sterringHandle) {
		this.sterringHandle = sterringHandle;
	}
	
	

}
