package com.wf.Daos;

import java.util.List;

import org.springframework.context.annotation.Bean;

import com.wf.entities.AssessmentLookup;
import com.wf.entities.Grades;
import com.wf.entities.User;



public interface GradesDao {

	
	@Bean
	 public void Creategradeform( List <User> user,Grades grade);
	
	public List<Grades> getGradesByCenterAndtype(User objcenter,AssessmentLookup type);
}
