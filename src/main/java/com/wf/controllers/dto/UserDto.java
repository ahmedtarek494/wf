package com.wf.controllers.dto;

import com.wf.entities.Center;

public class UserDto  implements AbstractDTO{

	
 private	int id;
 
 private String name;
 
 private String mobilenumber;
 
 private String gender;
	
 private int isstudent;

 private CenterDto center;

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

public UserDto(int id, String name, String mobilenumber, String gender, int isstudent, CenterDto center) {
	super();
	this.id = id;
	this.name = name;
	this.mobilenumber = mobilenumber;
	this.gender = gender;
	this.isstudent = isstudent;
	this.center = center;
}

public UserDto() {
	// TODO Auto-generated constructor stub
}
	
}
