package com.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Vehcile {
    @Id @GeneratedValue
	private int vehcileId;
	private String vehcileName;
	@ManyToMany(mappedBy = "vehcileList")
	private Collection<UserDetails> userDetails=new ArrayList<>();
	
	
	
	public Collection<UserDetails> getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(Collection<UserDetails> userDetails) {
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
