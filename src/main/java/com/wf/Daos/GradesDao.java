package com.wf.Daos;

import java.util.List;

import org.springframework.context.annotation.Bean;

<<<<<<< HEAD
import com.wf.entities.AssessmentLookup;
=======
import com.wf.entities.Center;
>>>>>>> a56597266563b746e811cd13f1418fde655ef9f9
import com.wf.entities.Grades;
import com.wf.entities.User;



public interface GradesDao {

	
	@Bean
<<<<<<< HEAD
	 public void Creategradeform( List <User> user,Grades grade);
	
	public List<Grades> getGradesByCenterAndtype(User objcenter,AssessmentLookup type);
=======
	 public int Creategradeform(Grades grade);
	
	public List <Grades> findGradeByUserID(User user);
	
>>>>>>> a56597266563b746e811cd13f1418fde655ef9f9
}
