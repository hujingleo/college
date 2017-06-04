package com.ptteng.college.home.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.college.home.model.Graduate;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface GraduateService extends BaseDaoService {

	



   		   
		
		public Long insert(Graduate graduate)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Graduate> insertList(List<Graduate> graduateList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Graduate graduate)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Graduate> graduateList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Graduate getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Graduate> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getGraduateIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countGraduateIds() throws ServiceException, ServiceDaoException;
	

}

