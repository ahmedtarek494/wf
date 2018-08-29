package com.wf.controllers.dto;

import java.io.Serializable;

public class AssessmentDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	private String assessmentNameDto;
	private float gradeFromDto;
	public String getAssessmentNameDto() {
		return assessmentNameDto;
	}
	public void setAssessmentNameDto(String assessmentNameDto) {
		this.assessmentNameDto = assessmentNameDto;
	}
	public float getGradeFromDto() {
		return gradeFromDto;
	}
	public void setGradeFromDto(float gradeFromDto) {
		this.gradeFromDto = gradeFromDto;
	}
	public AssessmentDto() {
		
	}
	
	public AssessmentDto(String assessmentNameDto, float gradeFromDto) {
		super();
		this.assessmentNameDto = assessmentNameDto;
		this.gradeFromDto = gradeFromDto;
	}
	
	
}
