package com.wf.utilities;

public class EditStudentBean {

	String name;
	String gender;
	String mobilenumber;
	String parentnumber;
	String center;
	String username;
	String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getParentnumber() {
		return parentnumber;
	}
	public void setParentnumber(String parentnumber) {
		this.parentnumber = parentnumber;
	}
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public EditStudentBean(String name, String gender, String mobilenumber, String parentnumber, String center,
			String username, String password) {
		super();
		this.name = name;
		this.gender = gender;
		this.mobilenumber = mobilenumber;
		this.parentnumber = parentnumber;
		this.center = center;
		this.username = username;
		this.password = password;
	}
	public EditStudentBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
