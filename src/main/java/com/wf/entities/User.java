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
@Table(name="user")
public class User implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private int id;
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="mobilenumber")
	private String mobilenumber;
	
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="isstudent")
	private int isstudent;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "center", nullable = false)
	private Center center;


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


	public Center getCenter() {
		return center;
	}


	public void setCenter(Center center) {
		this.center = center;
	}

	
	public User()
	{
		
	}

	public User(int id, String name, String mobilenumber, String gender, int isstudent, Center center) {
	
		this.id = id;
		this.name = name;
		this.mobilenumber = mobilenumber;
		this.gender = gender;
		this.isstudent = isstudent;
		this.center = center;
	}
	
}
