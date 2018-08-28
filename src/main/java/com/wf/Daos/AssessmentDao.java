package com.wf.Daos;

import org.springframework.context.annotation.Bean;

import com.wf.entities.AssessmentLookup;
import com.wf.entities.User;

public interface AssessmentDao {
	
	@Bean
	 public int addAssessment(AssessmentLookup assessment);

}
