package com.wf.Daos;

import java.util.List;

import org.springframework.context.annotation.Bean;

import com.wf.entities.GradesStudentView;

public interface GradesTopStudentDao {

	@Bean
	
	public List<GradesStudentView> getTopTenStudent();
}
