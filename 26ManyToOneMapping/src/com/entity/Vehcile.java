package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vehcile {
    @Id @GeneratedValue
	private int vehcileId;
	private String vehcileName;
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserDetails userDetails;
	
	
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
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
