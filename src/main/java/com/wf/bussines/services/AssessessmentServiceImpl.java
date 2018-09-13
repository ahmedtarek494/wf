package com.wf.bussines.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.Daos.AssessmentDao;
import com.wf.Daos.GradesDao;
import com.wf.Daos.UserDao;
import com.wf.controllers.dto.AssessmentDto;
import com.wf.entities.AssessmentLookup;
import com.wf.entities.Grades;
import com.wf.entities.User;

@Service("assessmentservice")
public class AssessessmentServiceImpl extends ServicesManager implements AssessmentService,Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Autowired
	private AssessmentDao assessmentDao;

	@Autowired
	private GradesDao gradeDao;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void createAssessment(AssessmentDto assessmentDto) {
		// TODO Auto-generated method stub
		
		AssessmentLookup assessment=new AssessmentLookup();
		assessment.setAssessmentName(assessmentDto.getAssessmentNameDto());
		assessment.setGradeFrom(assessmentDto.getGradeFromDto());
	
		int assessmentid=assessmentDao.addAssessment(assessment);
		
		assessment.setId(assessmentid);
		
		///////////////////////////
		List<User> user=userDao.findAll();
		
		
		Grades grade=new Grades();
		grade.setAssesmenttype(assessment);;
		
		System.out.println("Assessment created");
		System.out.println("******* Start create Assessment grades for students");
	gradeDao.Creategradeform( user,grade);
		System.out.println("finished ");
		
	}

	@Override
	public ArrayList<AssessmentDto> findAllAssessments() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<AssessmentDto> resultAssessmentDto=new ArrayList<AssessmentDto>();
		
		List<AssessmentLookup> assessments=assessmentDao.findAll();
		
		if(assessments==null)
			throw new Exception("No Assessments Available");
		else {
			
			for (AssessmentLookup object: assessments)
			{
				
				AssessmentDto temp=new AssessmentDto();
				
				temp.setId(object.getId());
				temp.setAssessmentNameDto(object.getAssessmentName());
				temp.setGradeFromDto(object.getGradeFrom());
				
				
				
				resultAssessmentDto.add(temp);
				
				
			}
			
			
			return resultAssessmentDto;
		}
		
		
	}
	
	

}
