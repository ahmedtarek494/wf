package com.jsf.bootstrap;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Ajax  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean student=false;
	private boolean grade=false;
	public boolean isStudent() {
		return student;
	}
	public void setStudent(boolean student) {
		this.student = student;
	}
	
	public boolean isGrade() {
		return grade;
	}
	
	public void setGrade(boolean grade) {
		this.grade = grade;
	}
	
	public void handleAjaxStudent() {
	
		System.out.println("handle ajax student");
			student=true;
		 grade=false;
	
	System.out.println("student in student handle: "+student);
	System.out.println("grade in student handle: "+grade);
	}
	
	public void handleAjaxGrade() {
		grade=true;
		student=false;
		System.out.println("handle ajax grade");
	}
}
