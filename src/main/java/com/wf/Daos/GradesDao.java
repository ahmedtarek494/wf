package com.wf.Daos;

import java.util.List;

import org.springframework.context.annotation.Bean;

import com.wf.entities.AssessmentLookup;
import com.wf.entities.Center;
import com.wf.entities.Grades;
import com.wf.entities.User;



public interface GradesDao {

	
	@Bean

	 public void Creategradeform( AssessmentLookup assessment);
	
	public List<Grades> getGradesByCenterAndtype(User objcenter,AssessmentLookup type);

	
	public List <Grades> findGradeByUserID(User user);
	
	public List<Grades> getTopTenStudent();
	
	public int updateGrades(List<Grades> grades);
}
