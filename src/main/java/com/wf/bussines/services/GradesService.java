package com.wf.bussines.services;


import java.util.ArrayList;

import com.wf.controllers.dto.GradesDto;
import com.wf.controllers.dto.GradesToPStudentDto;

public interface GradesService {
	
	public ArrayList<GradesDto> getGradesByUserId (int sessionId) throws Exception;
	
	public ArrayList<GradesToPStudentDto> getTopTenStudentGrades()throws Exception;

	public ArrayList<GradesDto> getGradesByCenterAndtype ( int center ,int assessmentid)throws Exception;
	public int updateStudentsGrades ( ArrayList<GradesDto> gradeslist) throws Exception;
}
	