package com.ptteng.college.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.college.home.model.Teacher;
import com.ptteng.college.home.service.TeacherService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class TeacherServiceImpl extends BaseDaoServiceImpl implements TeacherService {

 

	private static final Log log = LogFactory.getLog(TeacherServiceImpl.class);



		   
		@Override
		public Long insert(Teacher teacher)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + teacher);

		if (teacher == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		teacher.setCreateAt(currentTimeMillis);
		teacher.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(teacher);
		} catch (DaoException e) {
			log.error(" insert wrong : " + teacher);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Teacher> insertList(List<Teacher> teacherList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (teacherList == null ? "null" : teacherList.size()));
      
		List<Teacher> resultList = null;

		if (CollectionUtils.isEmpty(teacherList)) {
			return new ArrayList<Teacher>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Teacher teacher : teacherList) {
			teacher.setCreateAt(currentTimeMillis);
			teacher.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Teacher>) dao.batchSave(teacherList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + teacherList);
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
			result = dao.delete(Teacher.class, id);
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
		public boolean update(Teacher teacher)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (teacher == null ? "null" : teacher.getId()));

		boolean result = false;

		if (teacher == null) {
			return true;
		}

		teacher.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(teacher);
		} catch (DaoException e) {
			log.error(" update wrong : " + teacher);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + teacher);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Teacher> teacherList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (teacherList == null ? "null" : teacherList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(teacherList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Teacher teacher : teacherList) {
			teacher.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(teacherList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + teacherList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + teacherList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Teacher getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Teacher teacher = null;

		if (id == null) {
			return teacher;
		}

		try {
			teacher = (Teacher) dao.get(Teacher.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return teacher;		
		}	
		  
    	   
		@Override
		public List<Teacher> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Teacher> teacher = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Teacher>();
		}

		try {
			teacher = (List<Teacher>) dao.getList(Teacher.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (teacher == null ? "null" : teacher.size()));
    
		return teacher;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getTeacherIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getTeacherIdsAll",new Object[] {},start, limit, false);
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
	public Integer countTeacherIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getTeacherIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getTeacherIds " ) ;
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

