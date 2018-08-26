package com.wf.bussines.services;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wf.Daos.AssessmentDao;
import com.wf.Daos.UserDao;
import com.wf.controllers.dto.AssessmentDto;
import com.wf.entities.AssessmentLookup;

@Service
public class AssessessmentServiceImpl extends ServicesManager implements AssessmentService,Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Autowired
	private AssessmentDao assessmentDao;

	
	

	
	@Override
	public void createAssessment(AssessmentDto assessmentDto) {
		// TODO Auto-generated method stub
		
		AssessmentLookup assessment=new AssessmentLookup();
		assessment.setAssessmentName(assessmentDto.getAssessmentNameDto());
		assessment.setGradeFrom(assessmentDto.getGradeFromDto());
	
		assessmentDao.addAssessment(assessment);
		
	}
	
	

}
