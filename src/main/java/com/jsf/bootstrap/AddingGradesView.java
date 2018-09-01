package com.jsf.bootstrap;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wf.bussines.services.AssessmentService;
import com.wf.bussines.services.CenterService;
import com.wf.bussines.services.GradesService;
import com.wf.bussines.services.UserService;
import com.wf.controllers.dto.AssessmentDto;
import com.wf.controllers.dto.CenterDto;
import com.wf.controllers.dto.GradesDto;
import com.wf.controllers.dto.UserDto;


@ManagedBean
@RequestScope
public class AddingGradesView  implements Serializable{

	
	
	
	 @PostConstruct
	    private void init() {
	    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	        ServletContext servletContext = (ServletContext) externalContext.getContext();
		WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).
	                                   getAutowireCapableBeanFactory().
	                                   autowireBean(this);
		
		try {
			assessmentdto=assessmentservice.findAllAssessments();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	    }
	
	/**
	 * 
	 */
	 
	 private ArrayList<GradesDto> gradesdto;
	 public ArrayList<GradesDto> getGradesdto() {
		return gradesdto;
	}
	public void setGradesdto(ArrayList<GradesDto> gradesdto) {
		this.gradesdto = gradesdto;
	}

	private ArrayList<AssessmentDto> assessmentdto;

	public ArrayList<AssessmentDto> getAssessmentdto() {
		return assessmentdto;
	}
	public void setAssessmentdto(ArrayList<AssessmentDto> assessmentdto) {
		this.assessmentdto = assessmentdto;
	}

	private ArrayList<UserDto> userslistdto;
	 private ArrayList<CenterDto> centerlistdto;
	 
	 
	public ArrayList<CenterDto> getCenterlistdto() {
		return centerlistdto;
	}
	public void setCenterlistdto(ArrayList<CenterDto> centerlistdto) {
		this.centerlistdto = centerlistdto;
	}
	public ArrayList<UserDto> getUserslistdto() {
		return userslistdto;
	}
	public void setUserslistdto(ArrayList<UserDto> userslistdto) {
		this.userslistdto = userslistdto;
	}

	
	
	@Autowired
	UserService userservice;
	@Autowired
	CenterService centerservice;
	
	@Autowired
	AssessmentService assessmentservice;
	
	@Autowired
	GradesService gradesservice;
	
	
	
	private static final long serialVersionUID = 1L;
	private boolean student=false;
	private boolean grade=false;
	private ArrayList<UserDto> userslist;
	private boolean dropdownbool=false;
	private int centerid;
	private int assessmentid;
	private boolean gradestatus=true;
	
	
	
	
	public boolean isGradestatus() {
		return gradestatus;
	}
	public void setGradestatus(boolean gradestatus) {
		this.gradestatus = gradestatus;
	}
	public boolean isDropdownbool() {
		return dropdownbool;
	}
	public void setDropdownbool(boolean dropdownbool) {
		this.dropdownbool = dropdownbool;
	}

	private String studentcentervalue;
	
	public String getStudentcentervalue() {
		return studentcentervalue;
	}
	public void setStudentcentervalue(String studentcentervalue) {
		this.studentcentervalue = studentcentervalue;
	}
	public ArrayList<UserDto> getUserslist() {
		return userslist;
	}
	public void setUserslist(ArrayList<UserDto> userslist) {
		this.userslist = userslist;
	}
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
	
	public void AjaxStudentGrades() {
	
		
		System.out.println("ajax Student grade");
			student=true;
		 grade=false;
		 
	      try {
	       System.out.println("beforeeeeee");
	                       
	     this.gradesdto= gradesservice.getGradesByCenterAndtype(centerid, assessmentid);
	     
			System.out.println("after");
			
	      }
	      catch(Exception e)
	      {
	    	  System.out.println("exp "+ e.getMessage());
	    	  e.printStackTrace();
	    	  
	      }
			
	
		 
	
	System.out.println("student in student handle: "+student);
	System.out.println("grade in student handle: "+grade);
	}
	
	public void changeGradeStatus()
	{
		
		System.out.println("change  grade status");
		
		this.gradestatus=false;
		
		
	}
	
	public int getCenterid() {
		return centerid;
	}
	public void setCenterid(int centerid) {
		this.centerid = centerid;
	}
	public int getAssessmentid() {
		return assessmentid;
	}
	public void setAssessmentid(int assessmentid) {
		this.assessmentid = assessmentid;
	}
	public void handleAjaxGrade() {
		grade=true;
		student=false;
		System.out.println("handle ajax grade");
	}
	
	public void handleAjaxDropDown() {
		dropdownbool=true;
		try
		{
			
		
		centerlistdto=centerservice.getAllCenters();
		}
		  catch(Exception e)
	      {
	    	  System.out.println("exp "+ e.getMessage());
	    	  
	      }
		System.out.println("handle ajax dropdown");
	}
}
