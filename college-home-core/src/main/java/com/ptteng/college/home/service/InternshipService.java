package com.ptteng.college.home.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.college.home.model.Internship;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface InternshipService extends BaseDaoService {

	



   		   
		
		public Long insert(Internship internship)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Internship> insertList(List<Internship> internshipList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Internship internship)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Internship> internshipList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Internship getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Internship> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getInternshipIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countInternshipIds() throws ServiceException, ServiceDaoException;
	

}

