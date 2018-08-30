package com.wf.Daos;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;
import org.springframework.stereotype.Repository;

import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.search.Results;
import com.wf.entities.Grades;
import com.wf.entities.User;


@Repository
public class GradesDaoImpl extends AbstractDao implements GradesDao,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int Creategradeform(Grades grade) {
		// TODO Auto-generated method stub
		String hqlInsert = "insert into Grades(userid,assessmenttype) select id,"+grade.getAssesmenttype().getId()+" from user";
		System.out.println("before query");
		int updateCount = getSession().createQuery(hqlInsert).executeUpdate();
		
		System.out.println("count :"+ updateCount);
		
		
		return updateCount;
	}

	@Override
	public List<Grades> findGradeByUserID(User user) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Grades.class);
		criteria.add(Restrictions.eq("userid", user));
		
		return criteria.list();
	}
	
	public List<Grades> getTopTenStudent()
	{
		org.hibernate.Query query= getSession().createQuery("SELECT new map userid,SUM(g.usergrade) AS total_grades from Grades as g group by userid order by total_grades desc").setResultTransformer(new ResultTransformer(Results.class))
		        .list();
		return query.list();
	}

}
