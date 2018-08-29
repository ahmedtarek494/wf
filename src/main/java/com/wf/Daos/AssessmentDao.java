package com.wf.Daos;

import java.util.List;

import org.springframework.context.annotation.Bean;

import com.wf.entities.AssessmentLookup;
import com.wf.entities.Center;
import com.wf.entities.User;

public interface AssessmentDao {
	
	@Bean
	 public int addAssessment(AssessmentLookup assessment);

	 public List <AssessmentLookup> findAll();}
