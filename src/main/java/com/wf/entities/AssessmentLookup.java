package com.wf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="assessment_lookup")
public class AssessmentLookup implements Serializable {

	
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "assessmentid", unique = true, nullable = false)
	private int id;
	
	@Column(name="assessmentname")
	private String assessmentName;
	
	
	
	@Column(name="gradefrom")
	private float gradeFrom;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAssessmentName() {
		return assessmentName;
	}


	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}


	public float getGradeFrom() {
		return gradeFrom;
	}


	public void setGradeFrom(float gradeFrom) {
		this.gradeFrom = gradeFrom;
	}
	
	
	
}
