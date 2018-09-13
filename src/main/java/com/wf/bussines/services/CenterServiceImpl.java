package com.wf.bussines.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.Daos.CenterDao;
import com.wf.controllers.dto.CenterDto;
import com.wf.entities.Center;


@Service("centerservice")
public class CenterServiceImpl extends ServicesManager implements CenterService,Serializable {

	
	@Autowired
	private CenterDao centerDao;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ArrayList<CenterDto> getAllCenters() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<CenterDto> centerdto=new ArrayList<CenterDto>();
		List<Center> center=centerDao.findAll();
		if(center==null)
			throw new Exception("No Centers Available");
		else
		{
			for(Center c : center)
			{
				CenterDto centerdtotemp=new CenterDto();
				centerdtotemp.setId(c.getId());
				centerdtotemp.setCentername(c.getCentername());
				
				centerdto.add(centerdtotemp);
			}
		}
		
		return centerdto;
	}

}
