package com.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User23")
public class UserDetails {
	@Id @GeneratedValue
	private int userId;
	private String userName;
	@OneToMany(mappedBy ="userDetails" )
	private Collection<Vehcile> vehcileList=new ArrayList<>();
	
	
	
	public Collection<Vehcile> getVehcileList() {
		return vehcileList;
	}
	public void setVehcileList(Collection<Vehcile> vehcileList) {
		this.vehcileList = vehcileList;
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
