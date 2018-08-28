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
import com.wf.Daos.GradesDao;
import com.wf.Daos.UserDao;
import com.wf.controllers.dto.AssessmentDto;
import com.wf.controllers.dto.GradesDto;
import com.wf.entities.AssessmentLookup;
import com.wf.entities.Grades;

@Service
public class AssessessmentServiceImpl extends ServicesManager implements AssessmentService,Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Autowired
	private AssessmentDao assessmentDao;

	@Autowired
	private GradesDao gradeDao;
	

	
	@Override
	public void createAssessment(AssessmentDto assessmentDto) {
		// TODO Auto-generated method stub
		
		AssessmentLookup assessment=new AssessmentLookup();
		assessment.setAssessmentName(assessmentDto.getAssessmentNameDto());
		assessment.setGradeFrom(assessmentDto.getGradeFromDto());
	
		int assessmentid=assessmentDao.addAssessment(assessment);
		
		assessment.setId(assessmentid);
		
		
		Grades grade=new Grades();
		grade.setAssesmenttype(assessment);;
		
		System.out.println("Assessment created");
		System.out.println("******* Start create Assessment grades for students");
	int id=	gradeDao.Creategradeform(grade);
		System.out.println("finished "+id);
		
	}
	
	

}
