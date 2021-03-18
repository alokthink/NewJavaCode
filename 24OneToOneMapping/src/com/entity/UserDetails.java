package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User23")
public class UserDetails {
	@Id @GeneratedValue
	private int userId;
	private String userName;
	@OneToOne
	@JoinColumn(name = "VEHICILE_ID")
	private Vehcile vehcile;
	
	
	public Vehcile getVehcile() {
		return vehcile;
	}
	public void setVehcile(Vehcile vehcile) {
		this.vehcile = vehcile;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	

}
