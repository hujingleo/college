package com.ptteng.college.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.college.home.model.Internship;
import com.ptteng.college.home.service.InternshipService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class InternshipServiceImpl extends BaseDaoServiceImpl implements InternshipService {

 

	private static final Log log = LogFactory.getLog(InternshipServiceImpl.class);



		   
		@Override
		public Long insert(Internship internship)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + internship);

		if (internship == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		internship.setCreateAt(currentTimeMillis);
		internship.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(internship);
		} catch (DaoException e) {
			log.error(" insert wrong : " + internship);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Internship> insertList(List<Internship> internshipList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (internshipList == null ? "null" : internshipList.size()));
      
		List<Internship> resultList = null;

		if (CollectionUtils.isEmpty(internshipList)) {
			return new ArrayList<Internship>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Internship internship : internshipList) {
			internship.setCreateAt(currentTimeMillis);
			internship.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Internship>) dao.batchSave(internshipList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + internshipList);
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
			result = dao.delete(Internship.class, id);
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
		public boolean update(Internship internship)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (internship == null ? "null" : internship.getId()));

		boolean result = false;

		if (internship == null) {
			return true;
		}

		internship.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(internship);
		} catch (DaoException e) {
			log.error(" update wrong : " + internship);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + internship);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Internship> internshipList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (internshipList == null ? "null" : internshipList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(internshipList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Internship internship : internshipList) {
			internship.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(internshipList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + internshipList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + internshipList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Internship getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Internship internship = null;

		if (id == null) {
			return internship;
		}

		try {
			internship = (Internship) dao.get(Internship.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return internship;		
		}	
		  
    	   
		@Override
		public List<Internship> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Internship> internship = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Internship>();
		}

		try {
			internship = (List<Internship>) dao.getList(Internship.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (internship == null ? "null" : internship.size()));
    
		return internship;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getInternshipIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getInternshipIdsAll",new Object[] {},start, limit, false);
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
	public Integer countInternshipIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getInternshipIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getInternshipIds " ) ;
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

