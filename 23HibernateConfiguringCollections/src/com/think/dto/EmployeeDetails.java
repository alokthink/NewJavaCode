package com.think.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMP_DETAILS")
public class EmployeeDetails {
	@Id @GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "EMP_ID")
	private int empId;
	@Column(name = "EMP_NAME")
	private String name;
	@Embedded
	@AttributeOverrides({
	 @AttributeOverride(name = "street", column=@Column(name="HOME_STREET")),
	 @AttributeOverride(name = "city", column=@Column(name="HOME_CITY")),
	 @AttributeOverride(name = "State", column=@Column(name="HOME_STATE"))
	})
	private Address homeAddress;
	
	@Embedded
	private Address officeAddress;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	
	
}
