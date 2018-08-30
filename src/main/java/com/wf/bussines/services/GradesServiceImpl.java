package com.wf.bussines.services;

import java.io.Serializable;
import java.util.ArrayList;

import com.wf.Daos.GradesDao;
import com.wf.controllers.dto.AssessmentDto;
import com.wf.controllers.dto.CenterDto;
import com.wf.controllers.dto.GradesDto;
import com.wf.controllers.dto.UserDto;
import com.wf.entities.AssessmentLookup;
import com.wf.entities.Center;
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

	@Override
	public ArrayList<GradesDto> getGradesByCenterAndtype(int centerid, int assessmentid) throws Exception {
		// TODO Auto-generated method stub
	////////first parameter	
		ArrayList<GradesDto> Gradeslist=new ArrayList<GradesDto>();

		
		User user1=new User();
		Center center1=new Center();
		System.out.println("id="+centerid);
		center1.setId(centerid);
		//user1.setId(1001);
	    user1.setCenter(center1);
	  ///////second parameter///
	    AssessmentLookup assesstype=new AssessmentLookup();
	    
	    assesstype.setId(assessmentid);
	    
	    
		System.out.println("before-----");
		List<Grades> grade=gradesDao.getGradesByCenterAndtype(user1, assesstype);
		
		System.out.println("list size :"+grade.size());
		System.out.println("after-------");	
		int counter=0;
		if(grade==null)
			throw new Exception("No Students Available");
		else
		{
			for(Grades g:grade)
			{
				GradesDto gradesDto=new GradesDto();
				
				////////1
				gradesDto.setId(g.getId());
				//////////2
				gradesDto.setUsergrade(g.getUsergrade());
				
				// to get userid from user
				//UserDto user=new UserDto();
				User user2=g.getUser();
				UserDto usDto=new UserDto();
				usDto.setId(user2.getId());
				usDto.setName(user2.getName());
				CenterDto centtemp = new CenterDto();
				centtemp.setCentername(user2.getCenter().getCentername());
				usDto.setCenter(centtemp);
				
				////////////3
				gradesDto.setUserid(usDto);
				

				// to get assessment type
				//AssessmentLookup assess=g.getAssesmenttype();
				AssessmentDto assessDto=new AssessmentDto();
				assessDto.setAssessmentNameDto(g.getAssesmenttype().getAssessmentName());
				assessDto.setGradeFromDto(g.getAssesmenttype().getGradeFrom());
				assessDto.setId(g.getAssesmenttype().getId());
				////////////////////////3
				gradesDto.setAssessmenttype(assessDto);
				
				gradesDto.setRownumber(counter++);
				
				Gradeslist.add(gradesDto);
				

			}
		}
		
		
		
		return Gradeslist;

}
}