package com.ptteng.college.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.college.home.model.AdmissionEmployment;
import com.ptteng.college.home.service.AdmissionEmploymentService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class AdmissionEmploymentServiceImpl extends BaseDaoServiceImpl implements AdmissionEmploymentService {

 

	private static final Log log = LogFactory.getLog(AdmissionEmploymentServiceImpl.class);



		   
		@Override
		public Long insert(AdmissionEmployment admissionEmployment)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + admissionEmployment);

		if (admissionEmployment == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		admissionEmployment.setCreateAt(currentTimeMillis);
		admissionEmployment.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(admissionEmployment);
		} catch (DaoException e) {
			log.error(" insert wrong : " + admissionEmployment);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<AdmissionEmployment> insertList(List<AdmissionEmployment> admissionEmploymentList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (admissionEmploymentList == null ? "null" : admissionEmploymentList.size()));
      
		List<AdmissionEmployment> resultList = null;

		if (CollectionUtils.isEmpty(admissionEmploymentList)) {
			return new ArrayList<AdmissionEmployment>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (AdmissionEmployment admissionEmployment : admissionEmploymentList) {
			admissionEmployment.setCreateAt(currentTimeMillis);
			admissionEmployment.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<AdmissionEmployment>) dao.batchSave(admissionEmploymentList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + admissionEmploymentList);
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
			result = dao.delete(AdmissionEmployment.class, id);
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
		public boolean update(AdmissionEmployment admissionEmployment)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (admissionEmployment == null ? "null" : admissionEmployment.getId()));

		boolean result = false;

		if (admissionEmployment == null) {
			return true;
		}

		admissionEmployment.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(admissionEmployment);
		} catch (DaoException e) {
			log.error(" update wrong : " + admissionEmployment);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + admissionEmployment);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<AdmissionEmployment> admissionEmploymentList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (admissionEmploymentList == null ? "null" : admissionEmploymentList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(admissionEmploymentList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (AdmissionEmployment admissionEmployment : admissionEmploymentList) {
			admissionEmployment.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(admissionEmploymentList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + admissionEmploymentList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + admissionEmploymentList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public AdmissionEmployment getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		AdmissionEmployment admissionEmployment = null;

		if (id == null) {
			return admissionEmployment;
		}

		try {
			admissionEmployment = (AdmissionEmployment) dao.get(AdmissionEmployment.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return admissionEmployment;		
		}	
		  
    	   
		@Override
		public List<AdmissionEmployment> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<AdmissionEmployment> admissionEmployment = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<AdmissionEmployment>();
		}

		try {
			admissionEmployment = (List<AdmissionEmployment>) dao.getList(AdmissionEmployment.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (admissionEmployment == null ? "null" : admissionEmployment.size()));
    
		return admissionEmployment;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getAdmissionEmploymentIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getAdmissionEmploymentIdsAll",new Object[] {},start, limit, false);
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
	public Integer countAdmissionEmploymentIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getAdmissionEmploymentIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getAdmissionEmploymentIds " ) ;
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

