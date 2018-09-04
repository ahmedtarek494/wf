package com.jsf.bootstrap;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wf.bussines.services.GradesService;
import com.wf.controllers.dto.CenterDto;
import com.wf.controllers.dto.GradesDto;
import com.wf.controllers.dto.GradesToPStudentDto;

@ManagedBean
@RequestScope
public class StudentHomePageView implements Serializable {

	@Autowired
	GradesService gradesService;
	
 private ArrayList<GradesDto> gradeslistdto;


public ArrayList<GradesDto> getGradeslistdto() {
	return gradeslistdto;
}


public void setGradeslistdto(ArrayList<GradesDto> gradeslistdto) {
	this.gradeslistdto = gradeslistdto;
}


//to get student user name
private String studentname;

	
	 public String getStudentname() {
	return studentname;
}


public void setStudentname(String studentname) {
	this.studentname = studentname;
}

//to get id of grades
private int id;


	public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


//to view leaderboard
private ArrayList<GradesToPStudentDto> gradesToPStudentDtos;




	public ArrayList<GradesToPStudentDto> getGradesToPStudentDtos() {
	return gradesToPStudentDtos;
}


public void setGradesToPStudentDtos(ArrayList<GradesToPStudentDto> gradesToPStudentDtos) {
	this.gradesToPStudentDtos = gradesToPStudentDtos;
}


	@PostConstruct
	    private void init()  {
	    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	        ServletContext servletContext = (ServletContext) externalContext.getContext();
		WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).
	                                   getAutowireCapableBeanFactory().
	                                   autowireBean(this);
		
		try {
			gradeslistdto=gradesService.getGradesByUserId(1001);
			studentname=gradeslistdto.get(0).getUserid().getUsername();
			System.out.println("student name : "+gradeslistdto.get(0).getUserid().getUsername());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			gradesToPStudentDtos=gradesService.getTopTenStudentGrades();
			
			
		}catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		

	    }

		
	
	


	
	
	
	
	
}
