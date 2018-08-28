package com.wf.Daos;

import org.springframework.context.annotation.Bean;

import com.wf.entities.Grades;



public interface GradesDao {

	
	@Bean
	 public int Creategradeform(Grades grade);
}
