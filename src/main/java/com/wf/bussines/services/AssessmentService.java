package com.wf.bussines.services;

import java.util.ArrayList;


import com.wf.controllers.dto.AssessmentDto;

public interface AssessmentService {
	public void createAssessment(AssessmentDto assessmentDto) throws Exception;
    public ArrayList<AssessmentDto> findAllAssessments()throws Exception;
}
