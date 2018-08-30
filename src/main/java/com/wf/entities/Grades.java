package com.wf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import com.google.apphosting.api.proto2api.UserServicePbInternalDescriptors;

@Entity
@Table(name="Grades")
public class Grades implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	public Grades() {}
	
	public Grades(int id, User userid, AssessmentLookup assesmenttype, float usergrade) {
		super();
		this.id = id;
		this.userid = userid;
		this.assessmenttype = assesmenttype;
		this.usergrade = usergrade;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public User getUser() {
		return userid;
	}



	public void setUser(User userid) {
		this.userid = userid;
}

	public AssessmentLookup getAssesmenttype() {
		return assessmenttype;
	}


	public void setAssesmenttype(AssessmentLookup assesmenttype) {
		this.assessmenttype = assesmenttype;
	}


	public float getUsergrade() {
		return usergrade;
	}


	public void setUsergrade(float usergrade) {
		this.usergrade = usergrade;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "userid", nullable = false)
	private User userid;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "assessmenttype", nullable = false)
	private AssessmentLookup assessmenttype;
	
	
	@Column(name="usergrade")
	private float usergrade;
	
    
}
