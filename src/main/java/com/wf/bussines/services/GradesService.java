//package com.wf.bussines.services;0-=2l;/bn nm,.
import java.util.ArrayList;

import com.wf.controllers.dto.GradesDto;
import com.wf.controllers.dto.GradesToPStudentDto;

public interface GradesService {
	
	public ArrayList<GradesDto> getGradesByUserId (int sessionId) throws Exception;
	
	public ArrayList<GradesToPStudentDto> getTopTenStudentGrades()throws Exception;

}
