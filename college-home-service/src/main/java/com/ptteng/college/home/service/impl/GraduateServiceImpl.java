package com.ptteng.college.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.college.home.model.Graduate;
import com.ptteng.college.home.service.GraduateService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class GraduateServiceImpl extends BaseDaoServiceImpl implements GraduateService {

 

	private static final Log log = LogFactory.getLog(GraduateServiceImpl.class);



		   
		@Override
		public Long insert(Graduate graduate)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + graduate);

		if (graduate == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		graduate.setCreateAt(currentTimeMillis);
		graduate.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(graduate);
		} catch (DaoException e) {
			log.error(" insert wrong : " + graduate);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Graduate> insertList(List<Graduate> graduateList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (graduateList == null ? "null" : graduateList.size()));
      
		List<Graduate> resultList = null;

		if (CollectionUtils.isEmpty(graduateList)) {
			return new ArrayList<Graduate>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Graduate graduate : graduateList) {
			graduate.setCreateAt(currentTimeMillis);
			graduate.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Graduate>) dao.batchSave(graduateList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + graduateList);
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
			result = dao.delete(Graduate.class, id);
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
		public boolean update(Graduate graduate)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (graduate == null ? "null" : graduate.getId()));

		boolean result = false;

		if (graduate == null) {
			return true;
		}

		graduate.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(graduate);
		} catch (DaoException e) {
			log.error(" update wrong : " + graduate);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + graduate);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Graduate> graduateList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (graduateList == null ? "null" : graduateList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(graduateList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Graduate graduate : graduateList) {
			graduate.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(graduateList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + graduateList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + graduateList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Graduate getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Graduate graduate = null;

		if (id == null) {
			return graduate;
		}

		try {
			graduate = (Graduate) dao.get(Graduate.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return graduate;		
		}	
		  
    	   
		@Override
		public List<Graduate> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Graduate> graduate = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Graduate>();
		}

		try {
			graduate = (List<Graduate>) dao.getList(Graduate.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (graduate == null ? "null" : graduate.size()));
    
		return graduate;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getGraduateIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getGraduateIdsAll",new Object[] {},start, limit, false);
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
	public Integer countGraduateIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getGraduateIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getGraduateIds " ) ;
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

