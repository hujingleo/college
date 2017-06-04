package com.ptteng.college.home.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.college.home.model.Major;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface MajorService extends BaseDaoService {

	



   		   
		
		public Long insert(Major major)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Major> insertList(List<Major> majorList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Major major)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Major> majorList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Major getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Major> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getMajorIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countMajorIds() throws ServiceException, ServiceDaoException;
	

}

