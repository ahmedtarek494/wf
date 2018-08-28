package com.wf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	public Grades(int id, User user, AssessmentLookup assesmenttype, float usergrade) {
		super();
		this.id = id;
		this.user = user;
		this.assesmenttype = assesmenttype;
		this.usergrade = usergrade;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public AssessmentLookup getAssesmenttype() {
		return assesmenttype;
	}


	public void setAssesmenttype(AssessmentLookup assesmenttype) {
		this.assesmenttype = assesmenttype;
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


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false)
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assessmenttype", nullable = false)
	private AssessmentLookup assesmenttype;
	
	
	@Column(name="usergrade")
	private float usergrade;
	

}
