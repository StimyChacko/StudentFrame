package com.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table ( name = "stdaddress" )
public class stdaddress {
	
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	@Column ( name = "Add_Id" )
	private int addId;
	
	@Column ( name = "Add_Street" )
	private String addstreet;
	
	
	@Column ( name = "Add_City" )
	private String addcity;
	
	@Column ( name = "Pincode" )
	private int pincode;
	
	
	@Column ( name = "Mobile" )
	private int mobile;
	
	public stdaddress () {
		
	}

	public stdaddress(String addstreet, String addcity, int pincode, int mobile) {
		super();
		this.addcity = addcity;
		this.addstreet = addstreet;
		this.pincode = pincode;
		this.mobile = mobile;
	}

	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}

	public String getAddstreet() {
		return addstreet;
	}

	public void setAddstreet(String addstreet) {
		this.addstreet = addstreet;
	}

	public String getAddcity() {
		return addcity;
	}

	public void setAddcity(String addcity) {
		this.addcity = addcity;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	

}
