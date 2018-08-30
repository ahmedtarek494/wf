package com.wf.bussines.services;

import java.io.Serializable;
import java.util.ArrayList;

import com.wf.Daos.GradesDao;
import com.wf.controllers.dto.AssessmentDto;
import com.wf.controllers.dto.GradesDto;
import com.wf.controllers.dto.UserDto;
import com.wf.entities.Grades;
import com.wf.entities.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradesServiceImpl extends ServicesManager implements GradesService,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private GradesDao gradesDao;
	
	@Override
	public ArrayList<GradesDto> getGradesByUserId(int sessionId) throws Exception {
		// TODO Auto-generated method stub
		
		ArrayList<GradesDto> Gradeslist=new ArrayList<GradesDto>();
		
		
		User user1=new User();
		user1.setId(sessionId);
		System.out.println("before-----");
		List<Grades> grade=gradesDao.findGradeByUserID(user1);
		System.out.println("after-------");
		if(grade==null)
			throw new Exception("No Students Available");
		else
		{
			for(Grades g:grade)
			{
				GradesDto gradesDto=new GradesDto();
				
				gradesDto.setUsergrade(g.getUsergrade());
				
				// to get userid from user
				//UserDto user=new UserDto();
				User user2=g.getUser();
				UserDto usDto=new UserDto();
				usDto.setId(user2.getId());
				
				gradesDto.setUserid(usDto);
				

				// to get assessment type
				//AssessmentLookup assess=g.getAssesmenttype();
				AssessmentDto assessDto=new AssessmentDto();
				gradesDto.setAssessmenttype(assessDto);
				
				Gradeslist.add(gradesDto);
				

			}
		}
		
		
		
		return Gradeslist;
	}

}
