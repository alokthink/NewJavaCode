package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vehcile {
    @Id @GeneratedValue
	private int vehcileId;
	private String vehcileName;
	public int getVehcileId() {
		return vehcileId;
	}
	public void setVehcileId(int vehcileId) {
		this.vehcileId = vehcileId;
	}
	public String getVehcileName() {
		return vehcileName;
	}
	public void setVehcileName(String vehcileName) {
		this.vehcileName = vehcileName;
	}
	
	
	
}
