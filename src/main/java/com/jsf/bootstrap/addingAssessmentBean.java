package com.jsf.bootstrap;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wf.bussines.services.AssessmentService;
import com.wf.bussines.services.UserService;
import com.wf.controllers.dto.AssessmentDto;

@RequestScope
@ManagedBean
public class addingAssessmentBean {


	@Autowired
	AssessmentService assessmentService;
	
	
	@PostConstruct
	    private void init() {
	    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	        ServletContext servletContext = (ServletContext) externalContext.getContext();
		WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).
	                                   getAutowireCapableBeanFactory().
	                                   autowireBean(this);
	}
	
	
	private String assessmentName;
	private float gradeFrom=0;
	
	private boolean checkAssessmentFaliure;
	private String checkAssessmentFailureMessage;
	
	private boolean checkAssessmentSuccess;
	private String checkAssessmentSuccessMessage;
	
	
		
	
	public boolean isCheckAssessmentSuccess() {
		return checkAssessmentSuccess;
	}
	public void setCheckAssessmentSuccess(boolean checkAssessmentSuccess) {
		this.checkAssessmentSuccess = checkAssessmentSuccess;
	}
	public String getCheckAssessmentSuccessMessage() {
		return checkAssessmentSuccessMessage;
	}
	public void setCheckAssessmentSuccessMessage(String checkAssessmentSuccessMessage) {
		this.checkAssessmentSuccessMessage = checkAssessmentSuccessMessage;
	}
	public String getCheckAssessmentFailureMessage() {
		return checkAssessmentFailureMessage;
	}
	public void setCheckAssessmentFailureMessage(String checkAssessmentFailureMessage) {
		this.checkAssessmentFailureMessage = checkAssessmentFailureMessage;
	}
	public boolean isCheckAssessmentFaliure() {
		return checkAssessmentFaliure;
	}
	public void setCheckAssessmentFaliure(boolean checkAssessmentFaliure) {
		this.checkAssessmentFaliure = checkAssessmentFaliure;
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
	
	public void addAssessment() throws Exception{
		AssessmentDto assessmentDto=new AssessmentDto();
		assessmentDto.setAssessmentNameDto(this.assessmentName);
		assessmentDto.setGradeFromDto(this.gradeFrom);
	try {	
		assessmentService.createAssessment(assessmentDto);
		checkAssessmentSuccess=true;
		setCheckAssessmentSuccessMessage("Well done! You successfully added assessment");
	}
	catch (Exception e) {
		// TODO: handle exception
		checkAssessmentFaliure=true;
		setCheckAssessmentFailureMessage("Warning! Try again to add assessment");
	}
	
	}
	
	
	
	
	
}
