package com.wf.Daos;

import java.util.List;

import org.springframework.context.annotation.Bean;

import com.wf.entities.Center;
import com.wf.entities.Grades;
import com.wf.entities.User;



public interface GradesDao {

	
	@Bean
	 public int Creategradeform(Grades grade);
	
	public List <Grades> findGradeByUserID(User user);
	
}
