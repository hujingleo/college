package com.ptteng.college.home.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.college.home.model.Activity;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface ActivityService extends BaseDaoService {

	



   		   
		
		public Long insert(Activity activity)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Activity> insertList(List<Activity> activityList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Activity activity)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Activity> activityList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Activity getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Activity> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getActivityIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countActivityIds() throws ServiceException, ServiceDaoException;
	

}

