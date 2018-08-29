package com.wf.bussines.services;

import java.util.ArrayList;

import com.wf.controllers.dto.GradesDto;

public interface GradesService {
	
	public ArrayList<GradesDto> getGradesByUserId (int sessionId) throws Exception;

}
