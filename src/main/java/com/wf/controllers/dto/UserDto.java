package com.wf.controllers.dto;

import java.io.Serializable;

public class UserDto implements Serializable  {

	
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


/**
	 * 
	 */



private String username;	

private String password;


public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

private	int id;
 
 private String name;
 
 private String mobilenumber;
 
 private String parentnumber;
 
 private String gender;
	
 private int isstudent;

 private CenterDto center;

public String getParentnumber() {
	return parentnumber;
}

public void setParentnumber(String parentnumber) {
	this.parentnumber = parentnumber;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getMobilenumber() {
	return mobilenumber;
}

public void setMobilenumber(String mobilenumber) {
	this.mobilenumber = mobilenumber;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public int getIsstudent() {
	return isstudent;
}

public void setIsstudent(int isstudent) {
	this.isstudent = isstudent;
}

public CenterDto getCenter() {
	return center;
}

public void setCenter(CenterDto center) {
	this.center = center;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}
public UserDto(int id, String name, String mobilenumber,String username,String password, String gender, int isstudent, CenterDto center,String parentnumber) {
	super();
	this.id = id;
	this.name = name;
	this.username=username;
	this.mobilenumber = mobilenumber;
	this.gender = gender;
	this.isstudent = isstudent;
	this.center = center;
	this.password=password;
	this.parentnumber=parentnumber;
}

public UserDto() {
	// TODO Auto-generated constructor stub
}
	
}
