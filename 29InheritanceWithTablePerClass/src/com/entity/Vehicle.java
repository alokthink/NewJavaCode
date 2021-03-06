package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vehicle {
  @Id @GeneratedValue
  private int vehicleId;
  private String vehicleName;
  private String vehicleLogo;
  
  
public int getVehicleId() {
	return vehicleId;
}
public void setVehicleId(int vehicleId) {
	this.vehicleId = vehicleId;
}
public String getVehicleName() {
	return vehicleName;
}
public void setVehicleName(String vehicleName) {
	this.vehicleName = vehicleName;
}
public String getVehicleLogo() {
	return vehicleLogo;
}
public void setVehicleLogo(String vehicleLogo) {
	this.vehicleLogo = vehicleLogo;
}
  
  
}
