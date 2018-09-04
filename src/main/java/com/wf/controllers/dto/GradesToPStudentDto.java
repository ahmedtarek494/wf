package com.wf.controllers.dto;

import java.io.Serializable;

public class GradesToPStudentDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private float usergrade;
	private String usercenter;
	private String usergender;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public float getUsergrade() {
		return usergrade;
	}
	public void setUsergrade(float usergrade) {
		this.usergrade = usergrade;
	}
	public String getUsercenter() {
		return usercenter;
	}
	public void setUsercenter(String usercenter) {
		this.usercenter = usercenter;
	}
	public String getUsergender() {
		return usergender;
	}
	public void setUsergender(String usergender) {
		this.usergender = usergender;
	}
	
	

	
	
}
