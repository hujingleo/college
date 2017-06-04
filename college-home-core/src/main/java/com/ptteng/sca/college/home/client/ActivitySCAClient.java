package com.ptteng.sca.college.home.client;

import java.util.List;
import java.util.Map;

import com.ptteng.college.home.model.Activity;
import com.ptteng.college.home.service.ActivityService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class ActivitySCAClient implements ActivityService {

    private ActivityService activityService;

	public ActivityService getActivityService() {
		return activityService;
	}
	
	
	public void setActivityService(ActivityService activityService) {
		this.activityService =activityService;
	}
	
	
			   
		@Override
		public Long insert(Activity activity)throws ServiceException, ServiceDaoException{
		
		return activityService.insert(activity);
		          
		
		}	
		  
    	   
		@Override
		public List<Activity> insertList(List<Activity> activityList)throws ServiceException, ServiceDaoException{
		
		return activityService.insertList(activityList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return activityService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Activity activity)throws ServiceException, ServiceDaoException{
		
		return activityService.update(activity);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Activity> activityList)throws ServiceException, ServiceDaoException{
		
		return activityService.updateList(activityList);
		          
		
		}	
		  
    	   
		@Override
		public Activity getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return activityService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Activity> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return activityService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getActivityIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return activityService.getActivityIds(start, limit);
	}

	@Override
	public Integer countActivityIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return activityService.countActivityIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return activityService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return activityService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   activityService.deleteList(clz, ids);
		
	}
	
	//@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	return null;
		//return this.activityService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

