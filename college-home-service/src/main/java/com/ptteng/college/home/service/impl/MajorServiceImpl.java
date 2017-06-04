package com.ptteng.college.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.college.home.model.Major;
import com.ptteng.college.home.service.MajorService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class MajorServiceImpl extends BaseDaoServiceImpl implements MajorService {

 

	private static final Log log = LogFactory.getLog(MajorServiceImpl.class);



		   
		@Override
		public Long insert(Major major)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + major);

		if (major == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		major.setCreateAt(currentTimeMillis);
		major.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(major);
		} catch (DaoException e) {
			log.error(" insert wrong : " + major);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Major> insertList(List<Major> majorList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (majorList == null ? "null" : majorList.size()));
      
		List<Major> resultList = null;

		if (CollectionUtils.isEmpty(majorList)) {
			return new ArrayList<Major>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Major major : majorList) {
			major.setCreateAt(currentTimeMillis);
			major.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Major>) dao.batchSave(majorList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + majorList);
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
			result = dao.delete(Major.class, id);
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
		public boolean update(Major major)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (major == null ? "null" : major.getId()));

		boolean result = false;

		if (major == null) {
			return true;
		}

		major.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(major);
		} catch (DaoException e) {
			log.error(" update wrong : " + major);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + major);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Major> majorList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (majorList == null ? "null" : majorList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(majorList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Major major : majorList) {
			major.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(majorList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + majorList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + majorList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Major getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Major major = null;

		if (id == null) {
			return major;
		}

		try {
			major = (Major) dao.get(Major.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return major;		
		}	
		  
    	   
		@Override
		public List<Major> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Major> major = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Major>();
		}

		try {
			major = (List<Major>) dao.getList(Major.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (major == null ? "null" : major.size()));
    
		return major;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getMajorIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getMajorIdsAll",new Object[] {},start, limit, false);
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
	public Integer countMajorIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getMajorIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getMajorIds " ) ;
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

