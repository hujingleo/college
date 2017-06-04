package com.ptteng.college.home.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.college.home.model.Teacher;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface TeacherService extends BaseDaoService {

	



   		   
		
		public Long insert(Teacher teacher)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Teacher> insertList(List<Teacher> teacherList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Teacher teacher)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Teacher> teacherList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Teacher getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Teacher> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getTeacherIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countTeacherIds() throws ServiceException, ServiceDaoException;
	

}

