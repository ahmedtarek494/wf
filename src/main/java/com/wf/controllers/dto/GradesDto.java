package com.wf.controllers.dto;

import java.io.Serializable;

public class GradesDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	
	private AssessmentDto assessmenttype;
	
	private UserDto userid;
	
	private int rownumber;
	
	public int getRownumber() {
		return rownumber;
	}

	public void setRownumber(int rownumber) {
		this.rownumber = rownumber;
	}

	public boolean isGradestatus() {
		if(usergrade==0.0)
			gradestatus=false;
	
		
		return gradestatus;
	}

	public void setGradestatus(boolean gradestatus) {
		this.gradestatus = gradestatus;
	}

	private float usergrade;
    
	private boolean gradestatus=true;
	
	public GradesDto()
	{
		
	}
	
	public GradesDto(int id, AssessmentDto assessmenttype, UserDto userid, float usergrade) {
		super();
		this.id = id;
		this.assessmenttype = assessmenttype;
		this.userid = userid;
		this.usergrade = usergrade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AssessmentDto getAssessmenttype() {
		return assessmenttype;
	}

	public void setAssessmenttype(AssessmentDto assessmenttype) {
		this.assessmenttype = assessmenttype;
	}

	public UserDto getUserid() {
		return userid;
	}

	public void setUserid(UserDto userid) {
		this.userid = userid;
	}

	public float getUsergrade() {
		return usergrade;
	}

	public void setUsergrade(float usergrade) {
		this.usergrade = usergrade;
	}



}
