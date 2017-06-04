package com.ptteng.college.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.college.home.model.Activity;
import com.ptteng.college.home.service.ActivityService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class ActivityServiceImpl extends BaseDaoServiceImpl implements ActivityService {

 

	private static final Log log = LogFactory.getLog(ActivityServiceImpl.class);



		   
		@Override
		public Long insert(Activity activity)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + activity);

		if (activity == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		activity.setCreateAt(currentTimeMillis);
		activity.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(activity);
		} catch (DaoException e) {
			log.error(" insert wrong : " + activity);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Activity> insertList(List<Activity> activityList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (activityList == null ? "null" : activityList.size()));
      
		List<Activity> resultList = null;

		if (CollectionUtils.isEmpty(activityList)) {
			return new ArrayList<Activity>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Activity activity : activityList) {
			activity.setCreateAt(currentTimeMillis);
			activity.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Activity>) dao.batchSave(activityList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + activityList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
    
		return resultList;
		
		
			
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
	
		            
	    log.info(" delete data : " + id);
 
		boolean result = false;

		if (id == null) {
			return true;
		}

		try {
			result = dao.delete(Activity.class, id);
		} catch (DaoException e) {
			log.error(" delete wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
 
		log.info(" delete data success : " + id);
   
		return result;
		
		}	
		  
    	   
		@Override
		public boolean update(Activity activity)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (activity == null ? "null" : activity.getId()));

		boolean result = false;

		if (activity == null) {
			return true;
		}

		activity.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(activity);
		} catch (DaoException e) {
			log.error(" update wrong : " + activity);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + activity);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Activity> activityList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (activityList == null ? "null" : activityList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(activityList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Activity activity : activityList) {
			activity.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(activityList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + activityList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + activityList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Activity getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Activity activity = null;

		if (id == null) {
			return activity;
		}

		try {
			activity = (Activity) dao.get(Activity.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return activity;		
		}	
		  
    	   
		@Override
		public List<Activity> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Activity> activity = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Activity>();
		}

		try {
			activity = (List<Activity>) dao.getList(Activity.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (activity == null ? "null" : activity.size()));
    
		return activity;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getActivityIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		
		log.info(" get ids   by start,limit  ================== " + start + " , " + limit);
		List<Long> idList = null;
		
		
		
		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}
		
		try {
			idList = dao.getIdList("getActivityIdsAll",new Object[] {},start, limit, false);
		} catch (DaoException e) {
			log.error(" get ids  wrong by start,limit)  : " + start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success == : " + (idList == null ? "null" : idList.size()));
		}
		return idList;
	}
	
	
		@Override
	public Integer countActivityIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getActivityIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getActivityIds " ) ;
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" count  : " + count);
		}
		return count;
	}

}

