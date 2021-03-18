package com.think.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;



@Entity
@Table(name = "EMP_DETAILS")
public class EmployeeDetails {
	@Id @GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "EMP_ID")
	private int empId;
	@Column(name = "EMP_NAME")
	private String name;
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name="USER_ADDRESS",
	joinColumns = @JoinColumn(name="USER_ID")
	)
//	@GenericGenerator(name="hilo-gen", strategy ="hilo")
//	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type = "long"))
//	private Collection<Address> listAddress=new ArrayList<>();
	private Set<Address> listOfAddress = new HashSet<>();
	
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
	public Set<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Set<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
//	public Collection<Address> getListAddress() {
//		return listAddress;
//	}
//	public void setListAddress(Collection<Address> listAddress) {
//		this.listAddress = listAddress;
//	}

	
}
